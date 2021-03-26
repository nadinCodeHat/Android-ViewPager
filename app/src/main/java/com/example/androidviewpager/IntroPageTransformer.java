package com.example.androidviewpager;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import androidx.viewpager.widget.ViewPager;

public class IntroPageTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {
        int pagePosition = (int) page.getTag();
        int pageWidth = page.getWidth();
        int pageHeight = page.getHeight();
        float pageWidthTimesPosition = pageWidth * position;
        float pageHeightTimesPosition = pageHeight * position;
        float absPosition = Math.abs(position);

        Animation rotate = new RotateAnimation(0f, 360f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(1000);
        rotate.setInterpolator(new LinearInterpolator());
        rotate.setRepeatCount(0);
        rotate.setFillAfter(false);
        rotate.setFillEnabled(true);

        if (position <= -1.0f || position >= 1.0f) {
        } else if (position == 0.0f) {
        } else {
            View title = page.findViewById(R.id.title);
            if (title != null) {
                title.setAlpha(1.0f - absPosition);
                title.startAnimation(rotate);
            }
            View description = page.findViewById(R.id.description);
            if (description != null) {
                description.setAlpha(1.0f - absPosition);
                description.startAnimation(rotate);
            }
            View computer = page.findViewById(R.id.computer);
            if (computer != null) {
                RotateAnimation animation = new RotateAnimation(0, 360, -pageWidthTimesPosition/2f, -pageHeightTimesPosition/2f);
                animation.setRepeatCount(0);
                animation.setInterpolator(new LinearInterpolator());
                animation.setDuration(1000L);
                computer.startAnimation(animation);
            }
        }
    }
}