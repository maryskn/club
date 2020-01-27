package com.example.myapplication.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplication.view.account.AnsarcardFragment;
import com.example.myapplication.view.account.OtherscardFragment;

public class ViewPagercarnivalAdapter extends FragmentPagerAdapter {
    public ViewPagercarnivalAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public ViewPagercarnivalAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new AnsarcardFragment();
            case 1: return new OtherscardFragment();
            default: return new AnsarcardFragment();

        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){

            case 0: return "همه ی جشنواره ها";
            case 1: return "جشنواره های شرکت کرده";
            default: return "";
        }
    }
}
