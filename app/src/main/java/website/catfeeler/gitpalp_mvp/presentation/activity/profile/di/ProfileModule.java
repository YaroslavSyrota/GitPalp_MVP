package website.catfeeler.gitpalp_mvp.presentation.activity.profile.di;

import dagger.Module;
import dagger.Provides;
import website.catfeeler.gitpalp_mvp.data.PreferenceController;
import website.catfeeler.gitpalp_mvp.data.providers.ProfileProvider;
import website.catfeeler.gitpalp_mvp.di.ActivityScope;
import website.catfeeler.gitpalp_mvp.domain.interactors.ProfileInteractor;
import website.catfeeler.gitpalp_mvp.domain.repository.ProfileRepository;
import website.catfeeler.gitpalp_mvp.network.RestApiClient;
import website.catfeeler.gitpalp_mvp.presentation.activity.profile.ProfileContract;
import website.catfeeler.gitpalp_mvp.presentation.activity.profile.ProfilePresenter;
import website.catfeeler.gitpalp_mvp.utils.ErrorHandler;
import website.catfeeler.gitpalp_mvp.utils.ImageUtils;

/**
 * Created by CAT_Caterpiller on 18.03.2017.
 */

@Module
public class ProfileModule {

    @Provides @ActivityScope
    public ProfileContract.Presenter provideProfilePresenter(ProfileInteractor profileInteractor,
                                                             PreferenceController preferenceController,
                                                             ErrorHandler errorHandler,
                                                             ImageUtils imageUtils) {
        return new ProfilePresenter(profileInteractor, preferenceController, errorHandler, imageUtils);
    }

    @Provides @ActivityScope
    public ProfileInteractor provideProfileInteractor(ProfileRepository profileRepository) {
        return new ProfileInteractor(profileRepository);
    }

    @Provides @ActivityScope
    public ProfileRepository provideProfileRepository(RestApiClient restApiClient) {
        return new ProfileProvider(restApiClient);
    }

    @Provides @ActivityScope
    public ErrorHandler provideErrorHandler() {
        return new ErrorHandler();
    }

    @Provides @ActivityScope
    public ImageUtils provideImageUtils() {
        return new ImageUtils();
    }
}
