package website.catfeeler.gitpalp_mvp;

import android.app.Application;

import com.facebook.stetho.Stetho;

import website.catfeeler.gitpalp_mvp.di.AndroidModule;
import website.catfeeler.gitpalp_mvp.di.AppComponent;
import website.catfeeler.gitpalp_mvp.di.AppModule;
import website.catfeeler.gitpalp_mvp.di.DaggerAppComponent;

/**
 * Created by CAT_Caterpiller on 16.03.2017.
 */

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder()
                .androidModule(new AndroidModule())
                .appModule(new AppModule(this)).build();

        Stetho.initializeWithDefaults(this);
    }

    public AppComponent getAppComponent() {
        return this.appComponent;
    }
}
