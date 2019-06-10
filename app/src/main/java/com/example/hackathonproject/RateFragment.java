package com.example.hackathonproject;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class RateFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rate,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button rate=(Button)view.findViewById(R.id.ratebutton);
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickRateThisApp(v);
            }
        });
    }

    private boolean isActivityStarted(Intent aIntent)
    {
        try {
            startActivity(aIntent);
            return true;
        }
        catch(ActivityNotFoundException e)
        {
            return false;
        }
    }


    public void onClickRateThisApp(View v)
    {
        Intent i=new Intent(Intent.ACTION_VIEW);
        //inner parameter is uri pattern
        //address of the app
        i.setData(Uri.parse("market://details?id=com.tutorial.personal.androidstudiopro"));

        if(!isActivityStarted(i))
        {
            i.setData(Uri.parse("https://play.google.com"));
        }
    }
}
