package website.catfeeler.gitpalp_mvp.presentation.splash;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import website.catfeeler.gitpalp_mvp.presentation.splash.di.SplashContract;

/**
 * Created by CAT_Caterpiller on 16.03.2017.
 */

public final class SplashPresenter extends SplashContract.Presenter {

    private Handler handler;
    private static final long SPLASH_DELAY = 3000;

    @Override
    public void onViewCreated(@Nullable Bundle savedInstanceState) {
        super.onViewCreated(savedInstanceState);

        startWithPostDelayed();
    }

    @Override
    protected void startWithPostDelayed() {
        handler = new Handler();
        handler.postDelayed(() -> view.startActivity(SplashActivity.class, null), SPLASH_DELAY);
    }
}
