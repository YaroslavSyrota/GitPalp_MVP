package website.catfeeler.gitpalp_mvp.presentation.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import javax.inject.Inject;

import website.catfeeler.gitpalp_mvp.App;
import website.catfeeler.gitpalp_mvp.Constants;

/**
 * Created by CAT_Caterpiller on 16.03.2017.
 */

public abstract class BaseActivity<P extends BaseActivityContract.Presenter>
        extends AppCompatActivity implements BaseActivityContract.View<P> {

    @Inject
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent(((App) getApplication()).getAppComponent());
        if (getLayoutRes() != 0) setContentView(getLayoutRes());
        presenter.bindView(this);
        if (getIntent().hasExtra(Constants.Activity.BUNDLE_KEY)) {
            readBundle(getIntent().getBundleExtra(Constants.Activity.BUNDLE_KEY));
        }
        findUI();
        setupUI();
        presenter.onViewCreated(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroyView();
        super.onDestroy();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getStringValue(@StringRes int id) {
        return getString(id);
    }

    @Override
    public <T extends BaseActivity> void startActivity(Class<T> tClass, @Nullable Bundle bundle) {
        Intent intent = new Intent(this, tClass);
        if (bundle != null) {
            intent.putExtra(Constants.Activity.BUNDLE_KEY, bundle);
        }
        startActivity(intent);
    }

    @Override
    public void readBundle(Bundle bundle) {

    }
}
