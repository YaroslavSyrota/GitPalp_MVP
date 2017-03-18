package website.catfeeler.gitpalp_mvp.presentation.activity.login;

import android.content.ContentResolver;

import website.catfeeler.gitpalp_mvp.presentation.base.BaseActivity;
import website.catfeeler.gitpalp_mvp.presentation.base.BaseActivityContract;

/**
 * Created by CAT_Caterpiller on 17.03.2017.
 */

public interface LoginContract {

    interface View<P extends Presenter> extends BaseActivityContract.View<P> {
        void changeProgressState(boolean isVisible);
        ContentResolver getResolver();
        <T extends BaseActivity> void startAloneActivity(Class<T> tClass);
    }

    abstract class Presenter<V extends View> extends BaseActivityContract.Presenter<V> {
        abstract void clickLogin(String login, String password);
    }
}
