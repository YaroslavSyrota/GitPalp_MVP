package website.catfeeler.gitpalp_mvp.presentation.activity.details.di;

import dagger.Module;
import dagger.Provides;
import website.catfeeler.gitpalp_mvp.di.ActivityScope;
import website.catfeeler.gitpalp_mvp.presentation.activity.details.DetailsContract;
import website.catfeeler.gitpalp_mvp.presentation.activity.details.DetailsPresenter;
import website.catfeeler.gitpalp_mvp.utils.ImageUtils;

/**
 * Created by CAT_Caterpiller on 19.03.2017.
 */

@Module
public class DetailsModule {

    @Provides @ActivityScope
    public DetailsContract.Presenter provideDetailsPresenter(ImageUtils imageUtils) {
        return new DetailsPresenter(imageUtils);
    }

    @Provides @ActivityScope
    public ImageUtils provideImageUtils() {
        return new ImageUtils();
    }
}
