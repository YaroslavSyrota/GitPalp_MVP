package website.catfeeler.gitpalp_mvp.presentation.activity.splash;

import website.catfeeler.gitpalp_mvp.presentation.base.BaseActivityContract;

/**
 * Created by CAT_Caterpiller on 16.03.2017.
 */

public interface SplashContract {

    interface View<P extends Presenter> extends BaseActivityContract.View<P> {

    }

    abstract class Presenter<V extends View> extends BaseActivityContract.Presenter<V> {
        protected abstract void startWithPostDelayed();
    }
}
