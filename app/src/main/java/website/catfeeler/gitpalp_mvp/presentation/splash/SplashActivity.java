package website.catfeeler.gitpalp_mvp.presentation.splash;

import website.catfeeler.gitpalp_mvp.di.AppComponent;
import website.catfeeler.gitpalp_mvp.presentation.base.BaseActivity;
import website.catfeeler.gitpalp_mvp.presentation.splash.di.DaggerSplashComponent;
import website.catfeeler.gitpalp_mvp.presentation.splash.di.SplashContract;

/**
 * Created by CAT_Caterpiller on 16.03.2017.
 */

public final class SplashActivity extends BaseActivity<SplashContract.Presenter>
        implements SplashContract.View<SplashContract.Presenter> {

    @Override
    public void findUI() {

    }

    @Override
    public void setupUI() {

    }

    @Override
    public void setupComponent(AppComponent appComponent) {
        DaggerSplashComponent.builder()
                .appComponent(appComponent)
                .build().inject(this);
    }

    @Override
    public int getLayoutRes() {
        return 0;
    }
}
