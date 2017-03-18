package website.catfeeler.gitpalp_mvp.presentation.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
import website.catfeeler.gitpalp_mvp.di.AppComponent;

/**
 * Created by CAT_Caterpiller on 16.03.2017.
 */

public interface BaseActivityContract {

    interface View<P extends Presenter> extends BaseView<P> {
        void findUI();
        void setupUI();
        void setupComponent(AppComponent appComponent);
        void showErrorMessage(String message);
        <T extends BaseActivity> void startActivity(Class<T> tClass, @Nullable Bundle bundle);
        void readBundle(Bundle bundle);
    }

    abstract class Presenter<V extends View> implements BasePresenter<V> {
        private CompositeSubscription compositeSubscription;

        public Presenter() {
            compositeSubscription = new CompositeSubscription();
        }

        protected V view;

        @Override
        public void bindView(V view) {
            this.view = view;
        }

        @Override
        public void onDestroyView() {
            if (compositeSubscription.hasSubscriptions()) {
                compositeSubscription.unsubscribe();
            }
            view = null;
        }

        @Override
        public void onViewCreated(@Nullable Bundle savedInstanceState) {

        }

        public void addSubscription(Subscription subscription) {
            compositeSubscription.add(subscription);
        }

//        public <T> Observable<T> execute(Observable<T> observable) {
//            return observable
//                    .timeout(Constants.Api.TIMEOUT, TimeUnit.SECONDS)
//                    .subscribeOn(Schedulers.computation())
//                    .observeOn(AndroidSchedulers.mainThread());
//        }
    }
}
