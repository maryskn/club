package com.example.myapplication.ui.Main.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.R;
import com.example.myapplication.ui.Main.adapter.ImageAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class OtherscardFragment extends Fragment {
    ViewPager viewPager;
    FloatingActionButton add,del;
    Button accept;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.otherscard_fragment,container,false);
        viewPager=view.findViewById(R.id.imageview);
        ImageAdapter adapter=new ImageAdapter(getActivity());
        viewPager.setAdapter(adapter);
        add=view.findViewById(R.id.addcard);
        del=view.findViewById(R.id.delcard);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.add_card_dialog);
                accept=dialog.findViewById(R.id.button2);
                accept.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertDialog=new AlertDialog.Builder(getActivity());
                alertDialog.setMessage("از حذف کارت مطمئن هستید ؟").setPositiveButton("بله", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }

                });
                alertDialog.setNegativeButton("خیر", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();
            }
        });
        return view;
    }
}
