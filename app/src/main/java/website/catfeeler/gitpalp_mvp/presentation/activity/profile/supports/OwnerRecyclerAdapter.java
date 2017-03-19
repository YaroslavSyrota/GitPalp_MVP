package website.catfeeler.gitpalp_mvp.presentation.activity.profile.supports;

import android.support.annotation.NonNull;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager;

import website.catfeeler.gitpalp_mvp.data.model.UserRepository;
import website.catfeeler.gitpalp_mvp.presentation.base.BaseRecyclerAdapter;

/**
 * Created by CAT_Caterpiller on 19.03.2017.
 */

public class OwnerRecyclerAdapter extends BaseRecyclerAdapter<UserRepository> {

    @Override
    protected void initDelegatesManager(@NonNull AdapterDelegatesManager<UserRepository> delegatesManager) {
        delegatesManager.addDelegate(new OwnerAdapterDelegate());
    }
}
