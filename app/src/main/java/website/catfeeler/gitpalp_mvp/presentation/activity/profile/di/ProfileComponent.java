package website.catfeeler.gitpalp_mvp.presentation.activity.profile.di;

import dagger.Component;
import website.catfeeler.gitpalp_mvp.di.ActivityScope;
import website.catfeeler.gitpalp_mvp.di.AppComponent;
import website.catfeeler.gitpalp_mvp.presentation.activity.profile.ProfileActivity;

/**
 * Created by CAT_Caterpiller on 18.03.2017.
 */

@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = {ProfileModule.class})
public interface ProfileComponent {
    void inject(ProfileActivity profileActivity);
}
