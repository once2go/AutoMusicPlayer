package once2go.com.musicplayer.utill;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/**
 * Created by once2go on 28.02.16.
 * src from https://github.com/slidenerd/materialtest/blob/master/app/src/main/java/materialtest/vivz/slidenerd/anim/AnimationUtils.java
 */
public class AnimationUtils {

    private static int counter = 0;

    public static void animateSunblind(RecyclerView.ViewHolder holder, boolean goesDown) {
        int holderHeight = holder.itemView.getHeight();
        holder.itemView.setPivotY(goesDown == true ? 0 : holderHeight);
        holder.itemView.setPivotX(holder.itemView.getHeight());
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(holder.itemView, "translationY", goesDown == true ? 200 : -200, 0);
        ObjectAnimator animatorRotation = ObjectAnimator.ofFloat(holder.itemView, "rotationX", goesDown == true ? -90f : 90, 0f);
        ObjectAnimator animatorScaleX = ObjectAnimator.ofFloat(holder.itemView, "scaleX", 0.1f, 1f);
        animatorSet.playTogether(animatorTranslateY, animatorRotation, animatorScaleX);
        animatorSet.setInterpolator(new DecelerateInterpolator(1.1f));
        animatorSet.setDuration(700);
        animatorSet.start();
    }

    /**
     * Courtesy: Vladimir Topalovic
     *
     * @param holder
     * @param goesDown
     */
    public static void animateScatter(RecyclerView.ViewHolder holder, boolean goesDown) {
        counter = ++counter % 4;
        int holderHeight = holder.itemView.getHeight();
        int holderWidth = holder.itemView.getWidth();
        View holderItemView = holder.itemView;
        holderItemView.setPivotY(goesDown == true ? 0 : holderHeight);
        holderItemView.setPivotX(holderWidth / 2);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator animatorTranslateY = ObjectAnimator.ofFloat(holderItemView, "translationY", goesDown == true ? 300 : -300, 0);
        ObjectAnimator animatorTranslateX = ObjectAnimator.ofFloat(holderItemView, "translationX", counter == 1 || counter == 3 ? holderWidth : -holderWidth, 0);
        ObjectAnimator animatorScaleX = ObjectAnimator.ofFloat(holderItemView, "scaleX", counter == 1 || counter == 2 ? 0 : 2, 1f);
        ObjectAnimator animatorScaleY = ObjectAnimator.ofFloat(holderItemView, "scaleY", counter == 1 || counter == 2 ? 0 : 2, 1f);
        ObjectAnimator animatorAlpha = ObjectAnimator.ofFloat(holderItemView, "alpha", 0f, 1f);
        animatorAlpha.setInterpolator(new AccelerateInterpolator(1.5f));
        animatorSet.playTogether(animatorAlpha, animatorScaleX, animatorScaleY, animatorTranslateX, animatorTranslateY);
        animatorSet.setDuration(2000).setInterpolator(new DecelerateInterpolator(1.1f));
        animatorSet.start();
    }
}
