package website.catfeeler.gitpalp_mvp.presentation.activity.login;

import android.content.ContentResolver;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v4.content.IntentCompat;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import website.catfeeler.gitpalp_mvp.R;
import website.catfeeler.gitpalp_mvp.di.AppComponent;
import website.catfeeler.gitpalp_mvp.presentation.base.BaseActivity;
import website.catfeeler.gitpalp_mvp.presentation.activity.login.di.DaggerLoginComponent;

/**
 * Created by CAT_Caterpiller on 17.03.2017.
 */

public final class LoginActivity extends BaseActivity<LoginContract.Presenter>
        implements LoginContract.View<LoginContract.Presenter> {

    private TextInputEditText etLogin;
    private TextInputEditText etPassword;
    private TextView buttonLogin;
    private ProgressBar progressBar;

    @Override
    public void findUI() {
        etLogin     = (TextInputEditText) findViewById(R.id.etLogin_LA);
        etPassword  = (TextInputEditText) findViewById(R.id.etPassword_LA);
        buttonLogin = (TextView) findViewById(R.id.btnLogin_LA);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    public void setupUI() {
        buttonLogin.setOnClickListener(view ->
                presenter.clickLogin(etLogin.getText().toString(), etPassword.getText().toString()));
    }

    @Override
    public void setupComponent(AppComponent appComponent) {
        DaggerLoginComponent.builder()
                .appComponent(appComponent)
                .build().inject(this);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_login;
    }

    @Override
    public void changeProgressState(boolean isVisible) {
        progressBar.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    @Override
    public ContentResolver getResolver() {
        return getApplicationContext().getContentResolver();
    }

    @Override
    public <T extends BaseActivity> void startAloneActivity(Class<T> tClass) {
        final Intent intent = new Intent(this, tClass);
        intent.setFlags(IntentCompat.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
