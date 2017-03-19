package website.catfeeler.gitpalp_mvp.presentation.activity.details.di;

import dagger.Component;
import website.catfeeler.gitpalp_mvp.di.ActivityScope;
import website.catfeeler.gitpalp_mvp.di.AppComponent;
import website.catfeeler.gitpalp_mvp.presentation.activity.details.DetailsActivity;

/**
 * Created by CAT_Caterpiller on 19.03.2017.
 */

@ActivityScope
@Component(dependencies = {AppComponent.class}, modules = {DetailsModule.class})
public interface DetailsComponent {
    void inject(DetailsActivity detailsActivity);
}
