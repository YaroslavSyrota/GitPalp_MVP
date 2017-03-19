package website.catfeeler.gitpalp_mvp.presentation.activity.repositories;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import website.catfeeler.gitpalp_mvp.Constants;
import website.catfeeler.gitpalp_mvp.data.model.Repository;
import website.catfeeler.gitpalp_mvp.domain.interactors.RepositoriesInteractor;
import website.catfeeler.gitpalp_mvp.network.responses.SearchResponse;
import website.catfeeler.gitpalp_mvp.presentation.activity.repositories.supports.RepoRecyclerAdapter;
import website.catfeeler.gitpalp_mvp.presentation.base.BaseRecyclerAdapter;
import website.catfeeler.gitpalp_mvp.utils.ErrorHandler;
import website.catfeeler.gitpalp_mvp.utils.ImageUtils;

/**
 * Created by CAT_Caterpiller on 19.03.2017.
 */

public final class RepositoriesPresenter extends RepositoriesContract.Presenter<RepositoriesContract.View> {

    private String query;

    private RepositoriesInteractor repositoriesInteractor;
    private ErrorHandler errorHandler;
    private ImageUtils imageUtils;
    private BaseRecyclerAdapter<Repository> recyclerAdapter;

    @Inject
    public RepositoriesPresenter(RepositoriesInteractor repositoriesInteractor,
                                 ErrorHandler errorHandler,
                                 ImageUtils imageUtils) {
        this.repositoriesInteractor = repositoriesInteractor;
        this.errorHandler = errorHandler;
        this.imageUtils = imageUtils;
    }

    @Override
    public void onViewCreated(@Nullable Bundle savedInstanceState) {
        super.onViewCreated(savedInstanceState);
        recyclerAdapter = new RepoRecyclerAdapter(imageUtils);
        view.setRecyclerAdapter(recyclerAdapter);
        sendSearchRequest(query);
    }

    private void sendSearchRequest(String text) {
        view.changeProgressState(true);
        addSubscription(repositoriesInteractor.getSearchRepo(text)
                .timeout(Constants.Api.TIMEOUT, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::successSearch, this::error));
    }

    private void successSearch(SearchResponse response) {
        view.changeProgressState(false);
        recyclerAdapter.addAll(response.items);
    }

    private void error(Throwable throwable) {
        view.changeProgressState(false);
        errorHandler.onError(view, throwable);
    }

    @Override
    void clickSearch(String text) {
        if (!TextUtils.isEmpty(text)) {
            sendSearchRequest(text);
        }
    }

    @Override
    void clickBack() {
        view.getBack();
    }

    @Override
    void clickItem(int position) {
        view.showToast(recyclerAdapter.getItem(position).name);
    }

    @Override
    void setSearch(String query) {
        this.query = query;
    }
}
