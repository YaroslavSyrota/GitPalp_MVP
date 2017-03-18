package website.catfeeler.gitpalp_mvp.presentation.dialog;

import android.content.Context;
import android.widget.TextView;

import website.catfeeler.gitpalp_mvp.R;
import website.catfeeler.gitpalp_mvp.presentation.base.BaseDialog;

/**
 * Created by CAT_Caterpiller on 18.03.2017.
 */

public class ErrorDialog extends BaseDialog<ErrorDialogPresenter> {

    private TextView tvMessage;
    private TextView buttonOk;

    private ErrorDialog(Context context, String message) {
        super(context);
        setCancelable(false);
        findUI();
        tvMessage.setText(message);
    }

    @Override
    public ErrorDialogPresenter createPresenter() {
        return new ErrorDialogPresenter();
    }

    @Override
    public void findUI() {
        tvMessage   = (TextView) findViewById(R.id.tvMessageDialog);
        buttonOk    = (TextView) findViewById(R.id.btnOkDialog);
        buttonOk.setOnClickListener(view -> presenter.closeDialog());
    }

    @Override
    public int getLayoutRes() {
        return R.layout.dialog_message;
    }

    public static ErrorDialog create(Context context, String message) {
        return new ErrorDialog(context, message);
    }
}
