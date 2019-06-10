package com.example.hackathonproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ShareFragment extends Fragment {
    //this is created to do required activity when this is clicked
//we created a layout file called frafment_share now we override a method

/*Now we are creating this method so that we can link the sharefragment
 java classwith it layout file fragment_share using onCreateView,
* we use layout  inflater to connect*/
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_share,null);
    }

    /*we cn use this method similarly as onCreate method in Activity*/

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //since this is not activity
        //we use view object to call findViewById
        view.findViewById(R.id.sharebutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              shareit();
            }
        });
    }

    private void shareit()
    {
        Intent i=new Intent();
        i.setAction(Intent.ACTION_SEND);
        i.putExtra(Intent.EXTRA_SUBJECT,"android studio pro");
        i.putExtra(Intent.EXTRA_TEXT,"https://play.google.com");

        i.setType("text/plain");
        startActivity(i);
    }
}
