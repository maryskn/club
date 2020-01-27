package com.example.myapplication.ui.Main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.MyApplication;
import com.example.myapplication.R;
import com.example.myapplication.ui.Main.adapter.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class ManagecardFragment extends Fragment {
    TabLayout tabs;
    ViewPager pager;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.managecardfragment, container, false);
        tabs = view.findViewById(R.id.tabs);
        pager = view.findViewById(R.id.Pager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        pager.setAdapter(adapter);
        tabs.setupWithViewPager(pager);
setCustomFont();
        return view;
    }
    public void setCustomFont() {

        ViewGroup vg = (ViewGroup) tabs.getChildAt(0);
        int tabsCount = vg.getChildCount();

        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);

            int tabChildsCount = vgTab.getChildCount();

            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(MyApplication.getMyApplication().getNormalTypeface());
                }
            }
        }
    }


}
