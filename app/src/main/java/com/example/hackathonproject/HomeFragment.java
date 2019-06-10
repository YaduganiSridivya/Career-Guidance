package com.example.hackathonproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class HomeFragment extends Fragment
{
    ImageView pre,pro,qua,ent;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pro=(ImageView)view.findViewById(R.id.profession);
        pre=(ImageView)view.findViewById(R.id.preference);
        qua=(ImageView)view.findViewById(R.id.qualification);
        ent=(ImageView)view.findViewById(R.id.entranceexam);


        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ik=new Intent(getActivity(),SubjectActivity.class);

                startActivity(ik);
            }
        });


        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ik1=new Intent(getActivity(),JobActivity.class);
                startActivity(ik1);
            }
        });

        qua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ik2=new Intent(getActivity(),QualificationActivity.class);
                startActivity(ik2);
            }
        });


        ent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ik3=new Intent(getActivity(),EntranceActivity.class);
                startActivity(ik3);
            }
        });
    }

    
}
