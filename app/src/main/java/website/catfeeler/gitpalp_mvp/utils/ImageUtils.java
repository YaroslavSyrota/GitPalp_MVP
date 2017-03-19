package website.catfeeler.gitpalp_mvp.utils;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import website.catfeeler.gitpalp_mvp.R;
import website.catfeeler.gitpalp_mvp.presentation.custom.CircleBorderTransform;

/**
 * Created by CAT_Caterpiller on 19.03.2017.
 */

public class ImageUtils {

    //TODO need default image if url is empty
    public void setImage(ImageView imageView, String imageUri) {
        final Context context = imageView.getContext();

        if (!TextUtils.isEmpty(imageUri)) {
            BitmapPool pool = Glide.get(context).getBitmapPool();
            DrawableRequestBuilder glideBuilder = Glide.with(context)
                    .load(imageUri)
                    .diskCacheStrategy(DiskCacheStrategy.ALL);

            glideBuilder.into(imageView);
        }
    }

    public void setCircleImageWithBorder (ImageView imageView, String imageUri) {
        final Context context = imageView.getContext();

        if (!imageUri.isEmpty()) {
            BitmapPool pool = Glide.get(context).getBitmapPool();
            DrawableRequestBuilder glideBuilder = Glide.with(context)
                    .load(imageUri)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .bitmapTransform(new CircleBorderTransform(pool, ContextCompat.getColor(context, R.color.base_white)));

            glideBuilder.into(imageView);
        }
        else imageView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_avatar));
    }

    public void setImageWithTransformation (ImageView imageView, String imageUri, Transformation transformation) {
        final Context context = imageView.getContext();
        Glide.with(context)
                .load(imageUri)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .bitmapTransform(transformation)
                .into(new GlideDrawableImageViewTarget(imageView));
    }
}
