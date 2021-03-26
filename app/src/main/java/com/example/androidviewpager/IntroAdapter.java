package com.example.androidviewpager;

import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class IntroAdapter extends FragmentPagerAdapter{
    public IntroAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return IntroFragment.newInstance(
                        Color.parseColor("#f54242"), position);
            case 1:
                return IntroFragment.newInstance(
                        Color.parseColor("#42f56f"), position);
            case 2:
                return IntroFragment.newInstance(
                        Color.parseColor("#4257f5"), position);
            default:
                return IntroFragment.newInstance(
                        Color.parseColor("#c542f5"), position);
        }
    }
    @Override
    public int getCount() {
        return 4;
    }
}
