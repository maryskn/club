package com.example.myapplication.view.Main;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.example.myapplication.R;
import com.example.myapplication.model.remote.dto.LoginResponseModel;
import com.example.myapplication.view.MyViewModel;
import com.example.myapplication.view.account.AccountActivity;

public class Voroodfragment extends Fragment implements SignIn {
    private EditText name, pass;
    private Button voorood, Accept;
    private TextView forget;
    private CheckBox checkBox;
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.vorood_fragment, container, false);
        final MyViewModel myviewmodel = ViewModelProviders.of(this).get(MyViewModel.class);
        myviewmodel.signIn = Voroodfragment.this;
        Accept = view.findViewById(R.id.accept);
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
                myviewmodel.getLoginResponseModelLiveData().observe(getActivity(), new Observer<LoginResponseModel>() {
                    @Override
                    public void onChanged(LoginResponseModel responseModel) {
                        if (responseModel != null)
                            if (responseModel.getResult().equals("OK")) {
                                Intent account = new Intent(getActivity(), AccountActivity.class);
                                startActivity(account);

                            } else {
                                Toast.makeText(getActivity(), "اطلاعات صحیح نمی باشد", Toast.LENGTH_LONG).show();
                                Log.w("TAG", "result:: fsfsf");
                            }


                        //Toast.makeText(getActivity(), responseModel.getResult(), Toast.LENGTH_LONG).show();
                    }
                });


            }
        });


        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.forget_pass_dialog_layout);
                Accept = dialog.findViewById(R.id.accept);
                Accept.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();


            }
        });


        return view;
    }

    @Override
    public void onSuccess(String s) {
        //TODO define Intent
        Intent account = new Intent(getActivity(), AccountActivity.class);
        startActivity(account);
        //Navigation.findNavController(view).navigate(R.id.action_voroodfragment_to_acountFragment);
        Toast.makeText(getActivity(), s, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onError(String s) {
        Toast.makeText(getActivity(), s, Toast.LENGTH_LONG).show();

    }
}
