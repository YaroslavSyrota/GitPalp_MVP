package website.catfeeler.gitpalp_mvp.presentation.activity.login;

import android.os.Build;
import android.provider.Settings;
import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import website.catfeeler.gitpalp_mvp.Constants;
import website.catfeeler.gitpalp_mvp.R;
import website.catfeeler.gitpalp_mvp.data.PreferenceController;
import website.catfeeler.gitpalp_mvp.domain.interactors.LoginInteractor;
import website.catfeeler.gitpalp_mvp.network.requests.LoginRequest;
import website.catfeeler.gitpalp_mvp.network.responses.LoginResponse;
import website.catfeeler.gitpalp_mvp.utils.ErrorHandler;

/**
 * Created by CAT_Caterpiller on 17.03.2017.
 */

public class LoginPresenter extends LoginContract.Presenter<LoginContract.View> {

    private LoginInteractor loginInteractor;
    private PreferenceController preferenceController;
    private ErrorHandler errorHandler;
    private String basic;

    @Inject
    public LoginPresenter(LoginInteractor loginInteractor, PreferenceController preferenceController, ErrorHandler errorHandler) {
        this.loginInteractor = loginInteractor;
        this.preferenceController = preferenceController;
        this.errorHandler = errorHandler;
    }

    @Override
    void clickLogin(String login, String password) {
        String credentials = login + ":" + password;
        basic = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);

        view.changeProgressState(true);
        addSubscription(loginInteractor.getAuthorizations(basic)
                .timeout(Constants.Api.TIMEOUT, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::successAuth, this::errorAuth));
    }

    private void successAuth(List<LoginResponse> responses) {
        onCheckAlreadyExistUser(basic, responses);
        loginUser();
    }

    private void errorAuth(Throwable throwable) {
        if (errorHandler.isUserUnregister(throwable)) {
            loginUser();
        } else {
            errorHandler.onError(view, throwable);
        }
    }

    private void loginUser() {
        addSubscription(loginInteractor.loginUser(basic, createLoginRequest())
                .timeout(Constants.Api.TIMEOUT, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .map(loginResponse -> loginResponse.token)
                .subscribe(this::successLogin, this::error));
    }

    private void onCheckAlreadyExistUser(String basic, List<LoginResponse> loginResponses) {
        for (LoginResponse loginResponse : loginResponses) {
            String fingerprint = loginResponse.fingerprint;
            if (fingerprint != null && fingerprint.equals(getHashedDeviceId())){
                addSubscription(loginInteractor.deleteAuth(basic, loginResponse.id)
                        .timeout(Constants.Api.TIMEOUT, TimeUnit.SECONDS)
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe());
            }
        }
    }

    private void successLogin(String token) {
        view.changeProgressState(false);
        preferenceController.saveToken(token);
        view.showToast(token);
    }

    private void error(Throwable throwable) {
        view.changeProgressState(false);
        errorHandler.onError(view, throwable);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private LoginRequest createLoginRequest() {
        LoginRequest loginRequest   = new LoginRequest();
        loginRequest.appKey         = view.getStringValue(R.string.client_id);
        loginRequest.appSecret      = view.getStringValue(R.string.client_secret_id);
        loginRequest.note           = getDeviceDescription();
        loginRequest.fingerprint    = getHashedDeviceId();
        loginRequest.scopes         = Collections.singletonList("public_repo");
        return loginRequest;
    }

    private String getDeviceDescription() {
        return view.getStringValue(R.string.app_name) + " " + Build.MANUFACTURER + " " + Build.MODEL;
    }

    private String getHashedDeviceId() {
        String androidId = Settings.Secure.getString(view.getResolver(),
                Settings.Secure.ANDROID_ID);
        if (androidId == null) {
            androidId = Build.FINGERPRINT;
        }

        try {
            MessageDigest digest    = MessageDigest.getInstance("SHA-1");
            byte[] result           = digest.digest(androidId.getBytes("UTF-8"));
            StringBuilder sb        = new StringBuilder();
            for (byte b : result) {
                sb.append(String.format(Locale.US, "%02X", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            // won't happen
            return androidId;
        }
    }
}
