package website.catfeeler.gitpalp_mvp.di;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import website.catfeeler.gitpalp_mvp.data.PreferenceController;
import website.catfeeler.gitpalp_mvp.data.SharedPreferenceManager;

/**
 * Created by CAT_Caterpiller on 17.03.2017.
 */

@Module
public class AndroidModule {

    @Provides @Singleton
    public PreferenceController providePreferenceController(Context appContext) {
        return new SharedPreferenceManager(appContext);
    }
}
