package website.catfeeler.gitpalp_mvp.presentation.base;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;

/**
 * Created by CAT_Caterpiller on 18.03.2017.
 */

public abstract class BaseDialog<P extends BaseDialogContract.Presenter> extends Dialog
        implements BaseDialogContract.View<P> {

    protected P presenter;

    public BaseDialog(Context context) {
        super(context);
        setCancelable(true);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setContentView(getLayoutRes());
        presenter = createPresenter();
        presenter.bindView(this);
    }

    @Override
    public void closeDialog() {
        this.dismiss();
    }

    @Override
    public void dismiss() {
        super.dismiss();
        presenter.onDestroy();
        presenter = null;
    }
}
