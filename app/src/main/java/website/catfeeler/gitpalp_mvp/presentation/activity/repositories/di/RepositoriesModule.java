package website.catfeeler.gitpalp_mvp.presentation.activity.repositories.di;

import dagger.Module;
import dagger.Provides;
import website.catfeeler.gitpalp_mvp.data.providers.RepositoriesProvider;
import website.catfeeler.gitpalp_mvp.di.ActivityScope;
import website.catfeeler.gitpalp_mvp.domain.interactors.RepositoriesInteractor;
import website.catfeeler.gitpalp_mvp.domain.repository.RepositoriesRepository;
import website.catfeeler.gitpalp_mvp.network.RestApiClient;
import website.catfeeler.gitpalp_mvp.presentation.activity.repositories.RepositoriesContract;
import website.catfeeler.gitpalp_mvp.presentation.activity.repositories.RepositoriesPresenter;
import website.catfeeler.gitpalp_mvp.utils.ErrorHandler;
import website.catfeeler.gitpalp_mvp.utils.ImageUtils;

/**
 * Created by CAT_Caterpiller on 19.03.2017.
 */

@Module
public class RepositoriesModule {

    @Provides @ActivityScope
    public RepositoriesContract.Presenter provideProfilePresenter(RepositoriesInteractor repositoriesInteractor,
                                                                  ErrorHandler errorHandler,
                                                                  ImageUtils imageUtils) {
        return new RepositoriesPresenter(repositoriesInteractor, errorHandler, imageUtils);
    }

    @Provides @ActivityScope
    public RepositoriesInteractor provideRepoInteractor(RepositoriesRepository repoRepository) {
        return new RepositoriesInteractor(repoRepository);
    }

    @Provides @ActivityScope
    public RepositoriesRepository provideRepoRepository(RestApiClient restApiClient) {
        return new RepositoriesProvider(restApiClient);
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
