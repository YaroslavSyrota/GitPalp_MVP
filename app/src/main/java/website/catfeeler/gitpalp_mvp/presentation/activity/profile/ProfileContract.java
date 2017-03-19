package website.catfeeler.gitpalp_mvp.presentation.activity.profile;

import website.catfeeler.gitpalp_mvp.data.model.User;
import website.catfeeler.gitpalp_mvp.presentation.base.BaseActivityContract;
import website.catfeeler.gitpalp_mvp.presentation.base.BaseRecyclerAdapter;
import website.catfeeler.gitpalp_mvp.utils.ImageUtils;

/**
 * Created by CAT_Caterpiller on 18.03.2017.
 */

public interface ProfileContract {

    interface View<P extends Presenter> extends BaseActivityContract.View<P> {
        void changeProgressState(boolean isVisible);
        void setProfile(User user);
        void setRecyclerAdapter(BaseRecyclerAdapter adapter);
    }

    abstract class Presenter<V extends View> extends BaseActivityContract.Presenter<V> {
        abstract void clickSearch(String text);
        abstract ImageUtils getImageUtils();
    }
}
