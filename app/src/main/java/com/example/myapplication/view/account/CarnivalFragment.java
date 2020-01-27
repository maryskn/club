package com.example.myapplication.view.account;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.example.myapplication.R;
import com.example.myapplication.view.ViewPagercarnivalAdapter;

public class CarnivalFragment extends Fragment {
    TableLayout tableLayout;
    ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.carnival_fragment, container, false);
        tableLayout = view.findViewById(R.id.Tabcarnival);
        viewPager = view.findViewById(R.id.Pagercarnival);
        ViewPagercarnivalAdapter adapter = new ViewPagercarnivalAdapter(getActivity().getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tableLayout.setup;
        return view;
    }
}
