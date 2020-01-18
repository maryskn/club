package com.example.myapplication.view.Main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.view.MyViewModel;

public class Verificationfragment extends Fragment implements Verification{
    EditText phonenum , username , password , againpassword;
    Button sendmessage;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.verification_fragment,container,false);
        final MyViewModel myviewmodel = ViewModelProviders.of(this).get(MyViewModel.class);
        myviewmodel.verification = Verificationfragment.this;
        phonenum=view.findViewById(R.id.phone);
        username=view.findViewById(R.id.name);
        password=view.findViewById(R.id.pass1);
        againpassword=view.findViewById(R.id.pass2);
        sendmessage=view.findViewById(R.id.sendmessage);
        sendmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = phonenum.getText().toString();
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String againpass = againpassword.getText().toString();

                myviewmodel.sendMessage(phone, user,pass,againpass);

            }
        });
        return view;
    }

    @Override
    public void onSuccess(String s) {
        Toast.makeText(getActivity(), s, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onError(String s) {
        Toast.makeText(getActivity(), s, Toast.LENGTH_LONG).show();

    }
}