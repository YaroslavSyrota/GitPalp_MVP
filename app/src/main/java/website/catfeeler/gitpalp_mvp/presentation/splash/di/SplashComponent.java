package website.catfeeler.gitpalp_mvp.presentation.splash.di;

import dagger.Component;
import website.catfeeler.gitpalp_mvp.di.ActivityScope;
import website.catfeeler.gitpalp_mvp.di.AppComponent;
import website.catfeeler.gitpalp_mvp.presentation.splash.SplashActivity;

/**
 * Created by CAT_Caterpiller on 16.03.2017.
 */

@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = {SplashModule.class})
public interface SplashComponent {
    void inject(SplashActivity activity);
}
