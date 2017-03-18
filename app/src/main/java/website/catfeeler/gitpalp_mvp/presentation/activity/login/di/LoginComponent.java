package website.catfeeler.gitpalp_mvp.presentation.activity.login.di;

import dagger.Component;
import website.catfeeler.gitpalp_mvp.di.ActivityScope;
import website.catfeeler.gitpalp_mvp.di.AppComponent;
import website.catfeeler.gitpalp_mvp.presentation.activity.login.LoginActivity;

/**
 * Created by CAT_Caterpiller on 17.03.2017.
 */


@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = {LoginModule.class})
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
