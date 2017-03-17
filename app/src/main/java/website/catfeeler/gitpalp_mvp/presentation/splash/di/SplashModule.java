package website.catfeeler.gitpalp_mvp.presentation.splash.di;

import dagger.Module;
import dagger.Provides;
import website.catfeeler.gitpalp_mvp.di.ActivityScope;
import website.catfeeler.gitpalp_mvp.di.AppModule;
import website.catfeeler.gitpalp_mvp.presentation.splash.SplashPresenter;

/**
 * Created by CAT_Caterpiller on 16.03.2017.
 */

@Module(includes = {AppModule.class})
public class SplashModule {

    @Provides @ActivityScope
    public SplashContract.Presenter injectSplashPresenter() {
        return new SplashPresenter();
    }
}
