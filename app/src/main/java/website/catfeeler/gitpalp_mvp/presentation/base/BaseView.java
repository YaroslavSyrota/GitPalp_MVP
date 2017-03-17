package website.catfeeler.gitpalp_mvp.presentation.base;

import android.support.annotation.CheckResult;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;

/**
 * Created by CAT_Caterpiller on 16.03.2017.
 */

public interface BaseView<P> {

    void showToast(String message);
    @CheckResult
    String getStringValue(@StringRes int id);
    @LayoutRes
    int getLayoutRes();
}
