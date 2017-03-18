package website.catfeeler.gitpalp_mvp.presentation.activity.login.di;

import dagger.Module;
import dagger.Provides;
import website.catfeeler.gitpalp_mvp.data.PreferenceController;
import website.catfeeler.gitpalp_mvp.data.providers.LoginProvider;
import website.catfeeler.gitpalp_mvp.di.ActivityScope;
import website.catfeeler.gitpalp_mvp.domain.interactors.LoginInteractor;
import website.catfeeler.gitpalp_mvp.domain.repository.LoginRepository;
import website.catfeeler.gitpalp_mvp.network.RestApiClient;
import website.catfeeler.gitpalp_mvp.presentation.activity.login.LoginContract;
import website.catfeeler.gitpalp_mvp.presentation.activity.login.LoginPresenter;
import website.catfeeler.gitpalp_mvp.utils.ErrorHandler;

/**
 * Created by CAT_Caterpiller on 17.03.2017.
 */

@Module
public class LoginModule {

    @Provides @ActivityScope
    public LoginContract.Presenter provideLoginPresenter(LoginInteractor interactor,
                                                         PreferenceController controller,
                                                         ErrorHandler errorHandler) {
        return new LoginPresenter(interactor, controller, errorHandler);
    }

    @Provides @ActivityScope
    public LoginInteractor provideLoginInteractor(LoginRepository loginRepository) {
        return new LoginInteractor(loginRepository);
    }

    @Provides @ActivityScope
    public LoginRepository provideLoginRepository(RestApiClient restApiClient) {
        return new LoginProvider(restApiClient);
    }

    @Provides @ActivityScope
    public ErrorHandler provideErrorHandler() {
        return new ErrorHandler();
    }
}
