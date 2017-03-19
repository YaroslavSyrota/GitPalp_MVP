package website.catfeeler.gitpalp_mvp.presentation.activity.details;

import android.os.Bundle;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import website.catfeeler.gitpalp_mvp.data.model.Repository;
import website.catfeeler.gitpalp_mvp.utils.ImageUtils;

/**
 * Created by CAT_Caterpiller on 19.03.2017.
 */

public class DetailsPresenter extends DetailsContract.Presenter<DetailsContract.View> {

    private Repository repository;
    private ImageUtils imageUtils;

    @Inject
    public DetailsPresenter(ImageUtils imageUtils) {
        this.imageUtils = imageUtils;
    }

    @Override
    public void onViewCreated(@Nullable Bundle savedInstanceState) {
        super.onViewCreated(savedInstanceState);
        view.setRepository(repository);
    }

    @Override
    void setRepository(Repository repository) {
        this.repository = repository;
    }

    @Override
    ImageUtils getImageUtils() {
        return imageUtils;
    }
}
