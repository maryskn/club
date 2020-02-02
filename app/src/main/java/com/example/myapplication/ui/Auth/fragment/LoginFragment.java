package com.example.myapplication.ui.Auth.fragment;

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

import com.example.myapplication.Constants;
import com.example.myapplication.R;
import com.example.myapplication.ui.Auth.SignIn;
import com.example.myapplication.ui.Main.MainActivity;
import com.example.myapplication.ui.MyViewModel;
import com.example.myapplication.utils.Util;
import com.wang.avi.AVLoadingIndicatorView;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Response;

public class LoginFragment extends Fragment implements SignIn {
    private EditText name, pass;
    private Button voorood, Accept;
    private TextView forget;
    private CheckBox checkBox;
    private AVLoadingIndicatorView progressBar;
    private MyViewModel myviewmodel;
    View view;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.login_fragment, container, false);
        myviewmodel = ViewModelProviders.of(this).get(MyViewModel.class);
        myviewmodel.signIn = LoginFragment.this;
        progressBar = view.findViewById(R.id.progressBar);
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

                progressBar.setVisibility(View.VISIBLE);
                String userName = name.getText().toString();
                String password = pass.getText().toString();
                Intent account = new Intent(getActivity(), MainActivity.class);
                startActivity(account);
                getActivity().finish();

                //myviewmodel.login(userName, password);

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
        /*myviewmodel.getLoginResponseModelLiveData().observe(getActivity(), new Observer<Response<ResponseBody>>() {
            @Override
            public void onChanged(Response<ResponseBody> response) {
                progressBar.setVisibility(View.GONE);
                if (response == null)
                    return;

                if (response.code() == Constants.RES200) {

                    myviewmodel.saveToken(response.headers().get("token"));

                    Intent account = new Intent(getActivity(), MainActivity.class);
                    startActivity(account);
                    getActivity().finish();

                } else {
                    try {

                        JSONObject jsonObject = new JSONObject(response.errorBody().string());
                        final String s = jsonObject.getString("customMsg");

                        Log.w(Constants.TAG, s);

                        Util.showToast(getActivity(), s);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                }
            }

        }); */

    }

    @Override
    public void onError(String s) {
       /* Toast.makeText(getActivity(), s, Toast.LENGTH_LONG).show();
        progressBar.setVisibility(View.GONE); */
    }
}
