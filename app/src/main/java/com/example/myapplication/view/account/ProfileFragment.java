package com.example.myapplication.view.account;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class ProfileFragment extends Fragment {
    Button changeName,changePass,acceptname,acceptpass;

    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = getLayoutInflater().inflate(R.layout.profilefragment, container, false);
        changeName = view.findViewById(R.id.CHANGENAME);
        changePass = view.findViewById(R.id.CHANGEPASS);
        changeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.change_name_dialog_layout);
                acceptname=dialog.findViewById(R.id.ACCEPTNAME);
                acceptname.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog2=new Dialog(getActivity());
                dialog2.setContentView(R.layout.change_pass_dialog_layout);
                acceptpass=dialog2.findViewById(R.id.ACCEPTPASS);
                acceptpass.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog2.dismiss();
                    }
                });
                dialog2.show();
            }
        });

        return view;
    }


    }


