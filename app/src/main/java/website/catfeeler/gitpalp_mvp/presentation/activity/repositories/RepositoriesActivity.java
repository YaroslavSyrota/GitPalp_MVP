package website.catfeeler.gitpalp_mvp.presentation.activity.repositories;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import website.catfeeler.gitpalp_mvp.Constants;
import website.catfeeler.gitpalp_mvp.R;
import website.catfeeler.gitpalp_mvp.di.AppComponent;
import website.catfeeler.gitpalp_mvp.presentation.activity.repositories.di.DaggerRepositoriesComponent;
import website.catfeeler.gitpalp_mvp.presentation.activity.repositories.supports.ItemTouchListener;
import website.catfeeler.gitpalp_mvp.presentation.base.BaseActivity;
import website.catfeeler.gitpalp_mvp.presentation.base.BaseRecyclerAdapter;

/**
 * Created by CAT_Caterpiller on 19.03.2017.
 */

public final class RepositoriesActivity extends BaseActivity<RepositoriesContract.Presenter>
        implements RepositoriesContract.View<RepositoriesContract.Presenter> {

    private ImageButton btnBack;
    private ImageButton btnSearch;
    private EditText etSearch;

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private String query;

    @Override
    public int getLayoutRes() {
        return R.layout.activity_repositories;
    }

    @Override
    public void setupComponent(AppComponent appComponent) {
        DaggerRepositoriesComponent.builder()
                .appComponent(appComponent)
                .build().inject(this);
    }

    @Override
    public void findUI() {
        btnBack         = (ImageButton) findViewById(R.id.btnBack_RS);
        btnSearch       = (ImageButton) findViewById(R.id.btnSearch_RS);
        etSearch        = (EditText) findViewById(R.id.etSearch_RS);
        recyclerView    = (RecyclerView) findViewById(R.id.recyclerView_RA);
        progressBar     = (ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    public void setupUI() {
        etSearch.setText(query);
        btnBack.setOnClickListener(view -> presenter.clickBack());
        btnSearch.setOnClickListener(view -> presenter.clickSearch(etSearch.getText().toString()));
        recyclerView.addOnItemTouchListener(new ItemTouchListener(this, (view, position) -> presenter.clickItem(position)));
    }

    @Override
    public void changeProgressState(boolean isVisible) {
        progressBar.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    @Override
    public void setRecyclerAdapter(BaseRecyclerAdapter adapter) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void readBundle(Bundle bundle) {
        query = bundle.getString(Constants.Activity.SEARCH_KEY);
        presenter.setSearch(query);
    }

    @Override
    public void getBack() {
        onBackPressed();
    }
}
