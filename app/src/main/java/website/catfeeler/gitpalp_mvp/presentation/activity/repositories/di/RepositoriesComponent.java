package website.catfeeler.gitpalp_mvp.presentation.activity.repositories.di;

import dagger.Component;
import website.catfeeler.gitpalp_mvp.di.ActivityScope;
import website.catfeeler.gitpalp_mvp.di.AppComponent;
import website.catfeeler.gitpalp_mvp.presentation.activity.repositories.RepositoriesActivity;

/**
 * Created by CAT_Caterpiller on 19.03.2017.
 */

@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = {RepositoriesModule.class})
public interface RepositoriesComponent {
    void inject(RepositoriesActivity repositoriesActivity);
}
