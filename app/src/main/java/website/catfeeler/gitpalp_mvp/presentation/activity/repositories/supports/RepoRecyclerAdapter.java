package website.catfeeler.gitpalp_mvp.presentation.activity.repositories.supports;

import android.support.annotation.NonNull;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager;

import website.catfeeler.gitpalp_mvp.data.model.Repository;
import website.catfeeler.gitpalp_mvp.presentation.base.BaseRecyclerAdapter;
import website.catfeeler.gitpalp_mvp.utils.ImageUtils;

/**
 * Created by CAT_Caterpiller on 19.03.2017.
 */

public class RepoRecyclerAdapter extends BaseRecyclerAdapter<Repository> {

    private ImageUtils imageUtils;

    public RepoRecyclerAdapter(ImageUtils imageUtils) {
        super(false);
        this.imageUtils = imageUtils;
        fillDelegatesManger(true);
    }

    @Override
    protected void initDelegatesManager(@NonNull AdapterDelegatesManager<Repository> delegatesManager) {
        delegatesManager.addDelegate(new RepoAdapterDelegate(imageUtils));
    }
}
