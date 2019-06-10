package com.example.hackathonproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.zip.Inflater;

public class MailFragment extends Fragment {

    private EditText to1,subject1,message1;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mail,null);
        //return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        to1=(EditText)view.findViewById(R.id.toemail);
        subject1=(EditText)view.findViewById(R.id.subject);
        message1=(EditText)view.findViewById(R.id.message);
        button=(Button)view.findViewById(R.id.send);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mailit();
            }
        });

    }

    private void mailit()
    {
        Intent it=new Intent(Intent.ACTION_SEND);
        it.putExtra(Intent.EXTRA_EMAIL,new String[]{to1.getText().toString()});
        it.putExtra(Intent.EXTRA_SUBJECT,subject1.getText().toString());

        it.putExtra(Intent.EXTRA_TEXT,message1.getText());
        it.setType("message/rfc822");

        startActivity(Intent.createChooser(it,"Choose Mail App"));
    }
}
