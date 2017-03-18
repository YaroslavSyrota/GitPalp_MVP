package website.catfeeler.gitpalp_mvp.presentation.base;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;

import java.util.List;

/**
 * Created by CAT_Caterpiller on 18.03.2017.
 */

public abstract class BaseAdapterDelegate<T, H extends BaseViewHolder> extends AdapterDelegate<T> {

    @Override
    protected boolean isForViewType(@NonNull T items, int position) {
        return true;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return getHolder(LayoutInflater.from(parent.getContext()).inflate(getHolderLayoutRes(), parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull T items, int position, @NonNull RecyclerView.ViewHolder holder, @NonNull List<Object> payloads) {
        ((BaseViewHolder) holder).updateItem(items);
    }

    protected abstract @LayoutRes
    int getHolderLayoutRes();
    protected abstract H getHolder(@NonNull final View inflatedView);
}

