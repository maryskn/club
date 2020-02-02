package com.example.myapplication.ui.Main.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class InviteFragment extends Fragment {
    private Button Invite;
    TextView link;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = getLayoutInflater().inflate(R.layout.invite_fragment, container, false);
        Invite = view.findViewById(R.id.invitebutton);
        link=view.findViewById(R.id.linktext);
        String linkview="https://ansarclub.com/download";
        link.setText(linkview);
        Linkify.addLinks(link,Linkify.ALL);
        Invite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, "دعوت از دوستان");
                startActivity(shareIntent);
            }
        });
        return view;

    }
}
