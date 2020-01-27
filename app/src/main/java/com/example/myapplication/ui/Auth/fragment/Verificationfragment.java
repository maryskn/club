package com.example.myapplication.ui.Auth.fragment;

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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.myapplication.R;
import com.example.myapplication.model.remote.dto.LoginResponseModel;
import com.example.myapplication.ui.Auth.Verification;
import com.example.myapplication.ui.MyViewModel;

public class Verificationfragment extends Fragment implements Verification {
    EditText phonenum , username , password , againpassword;
    Button sendmessage;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view=inflater.inflate(R.layout.verification_fragment,container,false);
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

                myviewmodel.Register(phone,user,pass,againpass);
                myviewmodel.getRegisterResponseModelLiveData().observe(getActivity(), new Observer<LoginResponseModel>() {
                    @Override
                    public void onChanged(LoginResponseModel loginResponseModel) {
                        if (loginResponseModel != null)
                            if(loginResponseModel.getResult().equals("OK")) {
                                Navigation.findNavController(view).navigate(R.id.action_verificationfragment_to_voroodfragment);

                            } else {
                                Toast.makeText(getActivity(),"اطلاعات معتبر نمی باشد",Toast.LENGTH_SHORT).show();

                            }

                        //Toast.makeText(getActivity(), loginResponseModel.getResult(), Toast.LENGTH_LONG).show();
                    }
                });


            }
        });
        return view;
    }

    @Override
    public void onSuccess(String s) {
        Navigation.findNavController(view).navigate(R.id.action_verificationfragment_to_secondVerificationFragment);
        Toast.makeText(getActivity(),s, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onError(String s) {
        Toast.makeText(getActivity(),s, Toast.LENGTH_LONG).show();

    }
}
