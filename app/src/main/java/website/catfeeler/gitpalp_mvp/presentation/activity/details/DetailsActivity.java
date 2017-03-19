package website.catfeeler.gitpalp_mvp.presentation.activity.details;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import website.catfeeler.gitpalp_mvp.Constants;
import website.catfeeler.gitpalp_mvp.R;
import website.catfeeler.gitpalp_mvp.data.model.Repository;
import website.catfeeler.gitpalp_mvp.di.AppComponent;
import website.catfeeler.gitpalp_mvp.presentation.activity.details.di.DaggerDetailsComponent;
import website.catfeeler.gitpalp_mvp.presentation.base.BaseActivity;

/**
 * Created by CAT_Caterpiller on 19.03.2017.
 */

public class DetailsActivity extends BaseActivity<DetailsContract.Presenter>
        implements DetailsContract.View<DetailsContract.Presenter> {

    private Toolbar toolbar;
    private ImageView ivAvatar;
    private TextView tvUserName;
    private TextView tvUserUrl;
    private TextView tvType;
    private TextView tvRepoName;
    private TextView tvRepoDescription;
    private TextView tvForkCount;
    private TextView tvLanguage;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_details;
    }

    @Override
    public void setupComponent(AppComponent appComponent) {
        DaggerDetailsComponent.builder()
                .appComponent(appComponent)
                .build().inject(this);
    }

    @Override
    public void findUI() {
        toolbar         = (Toolbar) findViewById(R.id.toolbar);
        ivAvatar        = (ImageView) findViewById(R.id.ivAvatar_DA);
        tvUserName      = (TextView) findViewById(R.id.tvName_DA);
        tvUserUrl       = (TextView) findViewById(R.id.tvUrl_DA);
        tvType          = (TextView) findViewById(R.id.tvRepoCount_DA);
        tvRepoName      = (TextView) findViewById(R.id.tvRepoName_DA);
        tvRepoDescription = (TextView) findViewById(R.id.tvDescription_DA);
        tvForkCount     = (TextView) findViewById(R.id.tvForkCount_DA);
        tvLanguage      = (TextView) findViewById(R.id.tvLanguage_DA);
    }

    @Override
    public void setupUI() {
        setupToolbar();
    }

    @Override
    public void setRepository(Repository repository) {
        getSupportActionBar().setTitle(repository.name);
        presenter.getImageUtils().setCircleImageWithBorder(ivAvatar, repository.owner.avatarUrl);
        tvUserName.setText(repository.owner.login);
        tvUserUrl.setText(repository.owner.url);
        tvType.setText(repository.owner.type);
        tvRepoName.setText(repository.name);
        tvRepoDescription.setText((!TextUtils.isEmpty(repository.description))
                ? repository.description
                : getString(R.string.description_is_missing));
        tvLanguage.setText((!TextUtils.isEmpty(repository.language))
                ? repository.language
                : getString(R.string.no_language));
        tvForkCount.setText(getString(R.string.forks_count) + repository.forksCount);
    }

    private void setupToolbar() {
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);
    }

    @Override
    public void readBundle(Bundle bundle) {
        presenter.setRepository(bundle.getParcelable(Constants.Activity.REPO_KEY));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
