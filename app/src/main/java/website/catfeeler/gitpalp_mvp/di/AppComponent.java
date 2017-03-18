package website.catfeeler.gitpalp_mvp.di;

import javax.inject.Singleton;

import dagger.Component;
import website.catfeeler.gitpalp_mvp.App;
import website.catfeeler.gitpalp_mvp.data.PreferenceController;
import website.catfeeler.gitpalp_mvp.network.RestApiClient;

/**
 * Created by CAT_Caterpiller on 16.03.2017.
 */

@Singleton
@Component(modules = {AppModule.class, AndroidModule.class})
public interface AppComponent {

    void inject(App app);

    RestApiClient getRestClient();

    PreferenceController getPreferenceController();
}
