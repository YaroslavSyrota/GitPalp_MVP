package website.catfeeler.gitpalp_mvp.presentation.activity.repositories.supports;

import android.support.annotation.NonNull;
import android.view.View;

import website.catfeeler.gitpalp_mvp.R;
import website.catfeeler.gitpalp_mvp.data.model.Repository;
import website.catfeeler.gitpalp_mvp.presentation.base.BaseAdapterDelegate;
import website.catfeeler.gitpalp_mvp.utils.ImageUtils;

/**
 * Created by CAT_Caterpiller on 19.03.2017.
 */

public class RepoAdapterDelegate extends BaseAdapterDelegate<Repository, RepoViewHolder> {

    private ImageUtils imageUtils;

    public RepoAdapterDelegate(ImageUtils imageUtils) {
        this.imageUtils = imageUtils;
    }

    @Override
    protected int getHolderLayoutRes() {
        return R.layout.holder_repo;
    }

    @Override
    protected RepoViewHolder getHolder(@NonNull View inflatedView) {
        return new RepoViewHolder(inflatedView, imageUtils);
    }
}