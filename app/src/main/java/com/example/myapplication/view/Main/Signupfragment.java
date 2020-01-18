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
import androidx.navigation.Navigation;

import com.example.myapplication.R;
import com.example.myapplication.view.MyViewModel;

public class Signupfragment extends Fragment implements Verification{
    EditText nationalcode , customernum , email , referenceCode;
    Button accept;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.signup_fragment,container,false);
        accept=view.findViewById(R.id.accept);
        final MyViewModel myviewmodel = ViewModelProviders.of(this).get(MyViewModel.class);
        myviewmodel.verification = Signupfragment.this;
        nationalcode=view.findViewById(R.id.id);
        customernum=view.findViewById(R.id.idcustomer);
        email=view.findViewById(R.id.email);
        referenceCode=view.findViewById(R.id.reference);

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String national = nationalcode.getText().toString();
                String customer = customernum.getText().toString();
                String email1 = email.getText().toString();
                String reference = referenceCode.getText().toString();

                myviewmodel.signUp(national,customer,email1,reference);
            }
        });
        return view;
    }

    @Override
    public void onSuccess(String s) {
        Navigation.findNavController(view).navigate(R.id.action_signupfragment_to_verificationfragment);


    }

    @Override
    public void onError(String s) {
        Toast.makeText(getActivity(), s, Toast.LENGTH_LONG).show();

    }
}
