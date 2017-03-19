package website.catfeeler.gitpalp_mvp.presentation.activity.repositories.supports;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by CAT_Caterpiller on 19.03.2017.
 */

public final class ItemTouchListener implements RecyclerView.OnItemTouchListener {

    private OnItemClickListener mOnItemClickListener;
    private GestureDetectorCompat mGestureDetector;

    public ItemTouchListener(final Context _context, final OnItemClickListener _listener) {
        mOnItemClickListener = _listener;
        mGestureDetector = new GestureDetectorCompat(_context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(final MotionEvent e) {
                return true;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(final RecyclerView rv, final MotionEvent e) {
        final View childView = rv.findChildViewUnder(e.getX(), e.getY());
        if (childView != null && mOnItemClickListener != null && mGestureDetector.onTouchEvent(e)) {
            mOnItemClickListener.onItemClick(childView, rv.getChildAdapterPosition(childView));
        }
        return false;
    }

    @Override
    public void onTouchEvent(final RecyclerView rv, final MotionEvent e) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(final boolean disallowIntercept) {
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}