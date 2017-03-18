package website.catfeeler.gitpalp_mvp.presentation.activity.profile;

import java.util.List;

import website.catfeeler.gitpalp_mvp.data.model.User;
import website.catfeeler.gitpalp_mvp.data.model.UserRepository;
import website.catfeeler.gitpalp_mvp.presentation.base.BaseActivityContract;

/**
 * Created by CAT_Caterpiller on 18.03.2017.
 */

public interface ProfileContract {

    interface View<P extends Presenter> extends BaseActivityContract.View<P> {
        void changeProgressState(boolean isVisible);
        void setProfile(User user);
        void setRepositories(List<UserRepository> repositories);
    }

    abstract class Presenter<V extends View> extends BaseActivityContract.Presenter<V> {
        abstract void clickSearch(String text);
    }
}
