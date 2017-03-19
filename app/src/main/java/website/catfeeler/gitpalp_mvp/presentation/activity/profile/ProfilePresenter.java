package website.catfeeler.gitpalp_mvp.presentation.activity.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import website.catfeeler.gitpalp_mvp.Constants;
import website.catfeeler.gitpalp_mvp.data.PreferenceController;
import website.catfeeler.gitpalp_mvp.data.model.User;
import website.catfeeler.gitpalp_mvp.data.model.UserRepository;
import website.catfeeler.gitpalp_mvp.domain.interactors.ProfileInteractor;
import website.catfeeler.gitpalp_mvp.presentation.activity.profile.supports.OwnerRecyclerAdapter;
import website.catfeeler.gitpalp_mvp.presentation.activity.repositories.RepositoriesActivity;
import website.catfeeler.gitpalp_mvp.presentation.base.BaseRecyclerAdapter;
import website.catfeeler.gitpalp_mvp.utils.ErrorHandler;
import website.catfeeler.gitpalp_mvp.utils.ImageUtils;

/**
 * Created by CAT_Caterpiller on 18.03.2017.
 */

public final class ProfilePresenter extends ProfileContract.Presenter<ProfileContract.View> {

    private ProfileInteractor profileInteractor;
    private PreferenceController preferenceController;
    private ErrorHandler errorHandler;
    private ImageUtils imageUtils;

    private BaseRecyclerAdapter recyclerAdapter;

    @Inject
    public ProfilePresenter(ProfileInteractor profileInteractor,
                            PreferenceController preferenceController,
                            ErrorHandler errorHandler,
                            ImageUtils imageUtils) {
        this.profileInteractor = profileInteractor;
        this.preferenceController = preferenceController;
        this.errorHandler = errorHandler;
        this.imageUtils = imageUtils;
    }

    @Override
    public void onViewCreated(@Nullable Bundle savedInstanceState) {
        super.onViewCreated(savedInstanceState);
        recyclerAdapter = new OwnerRecyclerAdapter();
        view.setRecyclerAdapter(recyclerAdapter);
        sendProfileRequest();
    }

    private void sendProfileRequest() {
        view.changeProgressState(true);
        addSubscription(profileInteractor.getUser(preferenceController.getToken())
                .timeout(Constants.Api.TIMEOUT, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::successProfile, this::error));
    }

    private void error(Throwable throwable) {
        view.changeProgressState(false);
        errorHandler.onError(view, throwable);
    }

    private void successProfile(User user) {
        view.setProfile(user);
        addSubscription(profileInteractor.getUserRepositories(preferenceController.getToken())
                .timeout(Constants.Api.TIMEOUT, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::successRepositories, this::error));
    }

    private void successRepositories(List<UserRepository> repositories) {
        view.changeProgressState(false);
        recyclerAdapter.addAll(repositories);
    }

    @Override
    void clickSearch(String query) {
        if (!TextUtils.isEmpty(query)) {
            view.startActivity(RepositoriesActivity.class, prepareSearchBundle(query));
        }
    }

    private Bundle prepareSearchBundle(String search) {
        Bundle bundle = new Bundle();
        bundle.putString(Constants.Activity.SEARCH_KEY, search);
        return bundle;
    }

    @Override
    ImageUtils getImageUtils() {
        return imageUtils;
    }
}
