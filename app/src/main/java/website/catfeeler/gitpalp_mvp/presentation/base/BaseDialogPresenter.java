package website.catfeeler.gitpalp_mvp.presentation.base;

/**
 * Created by CAT_Caterpiller on 18.03.2017.
 */

public abstract class BaseDialogPresenter<V extends BaseDialogContract.View>
        implements BaseDialogContract.Presenter<V> {

    protected V view;

    @Override
    public void bindView(V view) {
        this.view = view;
    }

    @Override
    public void closeDialog() {
        view.closeDialog();
    }

    @Override
    public void onDestroy() {
        view = null;
    }
}
