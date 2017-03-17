package website.catfeeler.gitpalp_mvp.presentation.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import website.catfeeler.gitpalp_mvp.di.AppComponent;

/**
 * Created by CAT_Caterpiller on 16.03.2017.
 */

public interface BaseActivityContract {

    interface View<P extends Presenter> extends BaseView<P> {
        void findUI();
        void setupUI();
        void setupComponent(AppComponent appComponent);
        <T extends BaseActivity> void startActivity(Class<T> tClass, @Nullable Bundle bundle);
        //TODO delete this
//        void setToolbarTitle(@StringRes int textRes);
        void readBundle(Bundle bundle);
//        Intent getIntent();
    }

    abstract class Presenter<V extends View> implements BasePresenter<V> {

        protected V view;

        @Override
        public void bindView(V view) {
            this.view = view;
        }

        @Override
        public void onDestroyView() {
            view = null;
        }

        @Override
        public void onViewCreated(@Nullable Bundle savedInstanceState) {

        }
    }
}
