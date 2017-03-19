package website.catfeeler.gitpalp_mvp.presentation.activity.repositories;

import website.catfeeler.gitpalp_mvp.presentation.base.BaseActivityContract;
import website.catfeeler.gitpalp_mvp.presentation.base.BaseRecyclerAdapter;

/**
 * Created by CAT_Caterpiller on 19.03.2017.
 */

public interface RepositoriesContract {

    interface View<P extends Presenter> extends BaseActivityContract.View<P> {
        void changeProgressState(boolean isVisible);
        void setRecyclerAdapter(BaseRecyclerAdapter adapter);
        void getBack();
    }

    abstract class Presenter<V extends View> extends BaseActivityContract.Presenter<V> {
        abstract void setSearch(String query);
        abstract void clickSearch(String text);
        abstract void clickBack();
        abstract void clickItem(int position);
    }
}
