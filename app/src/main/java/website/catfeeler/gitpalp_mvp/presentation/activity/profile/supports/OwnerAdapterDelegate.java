package website.catfeeler.gitpalp_mvp.presentation.activity.profile.supports;

import android.support.annotation.NonNull;
import android.view.View;

import website.catfeeler.gitpalp_mvp.R;
import website.catfeeler.gitpalp_mvp.data.model.UserRepository;
import website.catfeeler.gitpalp_mvp.presentation.base.BaseAdapterDelegate;

/**
 * Created by CAT_Caterpiller on 19.03.2017.
 */

public class OwnerAdapterDelegate extends BaseAdapterDelegate<UserRepository, OwnerViewHolder> {

    @Override
    protected int getHolderLayoutRes() {
        return R.layout.holder_owner_repo;
    }

    @Override
    protected OwnerViewHolder getHolder(@NonNull View inflatedView) {
        return new OwnerViewHolder(inflatedView);
    }
}
