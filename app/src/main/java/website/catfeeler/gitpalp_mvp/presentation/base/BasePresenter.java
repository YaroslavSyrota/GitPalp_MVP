package website.catfeeler.gitpalp_mvp.presentation.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by CAT_Caterpiller on 16.03.2017.
 */

public interface BasePresenter<V extends BaseView> {

    void onViewCreated(@Nullable Bundle savedInstanceState);
    void onDestroyView();
    void bindView(V view);
}
