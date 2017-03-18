package website.catfeeler.gitpalp_mvp.presentation.activity.splash.di;

import dagger.Module;
import dagger.Provides;
import website.catfeeler.gitpalp_mvp.di.ActivityScope;
import website.catfeeler.gitpalp_mvp.presentation.activity.splash.SplashContract;
import website.catfeeler.gitpalp_mvp.presentation.activity.splash.SplashPresenter;

/**
 * Created by CAT_Caterpiller on 16.03.2017.
 */

@Module
public class SplashModule {

    @Provides @ActivityScope
    public SplashContract.Presenter injectSplashPresenter() {
        return new SplashPresenter();
    }
}
