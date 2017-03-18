package website.catfeeler.gitpalp_mvp.presentation.activity.profile.di;

import dagger.Module;
import dagger.Provides;
import website.catfeeler.gitpalp_mvp.di.ActivityScope;
import website.catfeeler.gitpalp_mvp.presentation.activity.profile.ProfileContract;
import website.catfeeler.gitpalp_mvp.presentation.activity.profile.ProfilePresenter;

/**
 * Created by CAT_Caterpiller on 18.03.2017.
 */

@Module
public class ProfileModule {

    @Provides @ActivityScope
    public ProfileContract.Presenter provideProfilePresenter() {
        return new ProfilePresenter();
    }
}
