package com.example.myapplication.view.account;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class ProfileFragment extends Fragment {
    Button changeName, changePass, acceptname, acceptpass;
    ImageView profile;
    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 100;
    private final static int FROM_PHOTOLIB = 1;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = getLayoutInflater().inflate(R.layout.profilefragment, container, false);

        changeName = view.findViewById(R.id.CHANGENAME);
        changePass = view.findViewById(R.id.CHANGEPASS);
        profile = view.findViewById(R.id.profile);

        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
        }

        changeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.change_name_dialog_layout);
                acceptname = dialog.findViewById(R.id.ACCEPTNAME);
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
                final Dialog dialog2 = new Dialog(getActivity());
                dialog2.setContentView(R.layout.change_pass_dialog_layout);
                acceptpass = dialog2.findViewById(R.id.ACCEPTPASS);
                acceptpass.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog2.dismiss();
                    }
                });
                dialog2.show();
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePhotoInternal();
            }
        });

        return view;
    }


    public void choosePhotoInternal() {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, FROM_PHOTOLIB);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == FROM_PHOTOLIB) {

                Uri uri = data.getData();
                profile.setImageURI(uri);

            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    boolean showRationale = ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE);
                    if (showRationale) {
                        Toast.makeText(getActivity(), "permission_needed", Toast.LENGTH_LONG).show();
                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
                    } else {
                        //
                    }

                }
            }
        }
    }

}


