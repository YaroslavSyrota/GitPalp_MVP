package website.catfeeler.gitpalp_mvp.di;

import javax.inject.Singleton;

import dagger.Component;
import website.catfeeler.gitpalp_mvp.App;

/**
 * Created by CAT_Caterpiller on 16.03.2017.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(App app);
}
