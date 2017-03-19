package website.catfeeler.gitpalp_mvp.presentation.activity.details;

import website.catfeeler.gitpalp_mvp.data.model.Repository;
import website.catfeeler.gitpalp_mvp.presentation.base.BaseActivityContract;
import website.catfeeler.gitpalp_mvp.utils.ImageUtils;

/**
 * Created by CAT_Caterpiller on 19.03.2017.
 */

public interface DetailsContract {

    interface View<P extends Presenter> extends BaseActivityContract.View<P> {
        void setRepository(Repository repository);
    }

    abstract class Presenter<V extends View> extends BaseActivityContract.Presenter<V> {
        abstract void setRepository(Repository repository);
        abstract ImageUtils getImageUtils();
    }
}
