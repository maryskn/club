package com.example.myapplication.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;
import com.example.myapplication.view.main.Main.AccountActivity;
import com.example.myapplication.view.main.Main.SignIn;

public class Voroodfragment extends Fragment implements SignIn {
    private EditText name, pass;
    private Button voorood;
    private TextView forget;
    private CheckBox checkBox;

    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.vorood_fragment, container, false);
        final MyViewModel myviewmodel = ViewModelProviders.of(this).get(MyViewModel.class);
        myviewmodel.signIn = Voroodfragment.this;

        name = view.findViewById(R.id.name);
        pass = view.findViewById(R.id.pass);
        checkBox = view.findViewById(R.id.checkbox);
        voorood = view.findViewById(R.id.vorood);
        forget = view.findViewById(R.id.forget);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });


        voorood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = name.getText().toString();
                String password = pass.getText().toString();

                myviewmodel.login(userName, password);

            }
        });

        return view;
    }

    @Override
    public void onSuccess(String s) {
        //TODO define Intent
        Intent account=new Intent(getActivity(), AccountActivity.class);
        startActivity(account);
        //Navigation.findNavController(view).navigate(R.id.action_voroodfragment_to_acountFragment);
        Toast.makeText(getActivity(), s, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onError(String s) {
        Toast.makeText(getActivity(), s, Toast.LENGTH_LONG).show();

    }
}
