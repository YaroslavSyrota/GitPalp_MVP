package website.catfeeler.gitpalp_mvp.presentation.base;

import android.support.annotation.LayoutRes;

/**
 * Created by CAT_Caterpiller on 18.03.2017.
 */

public interface BaseDialogContract {

    interface View<P extends Presenter> {
        P createPresenter();
        void findUI();
        @LayoutRes int getLayoutRes();
        void closeDialog();
    }

    interface Presenter<V extends View> {
        void bindView(V view);
        void closeDialog();
        void onDestroy();
    }
}
