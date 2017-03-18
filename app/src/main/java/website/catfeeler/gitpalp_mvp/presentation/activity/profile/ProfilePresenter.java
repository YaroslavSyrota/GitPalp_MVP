package website.catfeeler.gitpalp_mvp.presentation.activity.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import website.catfeeler.gitpalp_mvp.Constants;
import website.catfeeler.gitpalp_mvp.data.PreferenceController;
import website.catfeeler.gitpalp_mvp.data.model.User;
import website.catfeeler.gitpalp_mvp.domain.interactors.ProfileInteractor;
import website.catfeeler.gitpalp_mvp.utils.ErrorHandler;

/**
 * Created by CAT_Caterpiller on 18.03.2017.
 */

public final class ProfilePresenter extends ProfileContract.Presenter<ProfileContract.View> {

    private ProfileInteractor profileInteractor;
    private PreferenceController preferenceController;
    private ErrorHandler errorHandler;

    @Inject
    public ProfilePresenter(ProfileInteractor profileInteractor,
                            PreferenceController preferenceController,
                            ErrorHandler errorHandler) {
        this.profileInteractor = profileInteractor;
        this.preferenceController = preferenceController;
        this.errorHandler = errorHandler;
    }

    @Override
    public void onViewCreated(@Nullable Bundle savedInstanceState) {
        super.onViewCreated(savedInstanceState);
        sendProfileRequest();
    }

    private void sendProfileRequest() {
        view.changeProgressState(true);
        addSubscription(profileInteractor.getUser(preferenceController.getToken())
                .timeout(Constants.Api.TIMEOUT, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::successProfile, this::error));
    }

    private void error(Throwable throwable) {
        view.changeProgressState(false);
        errorHandler.onError(view, throwable);
    }

    private void successProfile(User user) {
        view.showToast("profile");
    }

    @Override
    void clickSearch(String query) {
        if (!query.isEmpty()) {

        }
    }
}
