package website.catfeeler.gitpalp_mvp.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import website.catfeeler.gitpalp_mvp.App;
import website.catfeeler.gitpalp_mvp.network.RestApiClient;

/**
 * Created by CAT_Caterpiller on 16.03.2017.
 */

@Module
public class AppModule {

    private App application;

    public AppModule(App application) {
        this.application = application;
    }

    @Provides @Singleton
    Context provideContext(){
        return application.getApplicationContext();
    }

    @Provides
    public RestApiClient provideRestClient(){ return RestApiClient.getInstance(); }
}
