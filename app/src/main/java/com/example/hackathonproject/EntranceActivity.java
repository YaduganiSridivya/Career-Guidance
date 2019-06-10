package com.example.hackathonproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class EntranceActivity extends AppCompatActivity {

   private ImageView mains;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);

        mains=(ImageView)findViewById(R.id.jeemainexam);


        mains.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(EntranceActivity.this,JeemainActivity.class);
                startActivity(i);
            }
        });
    }

    public void iitadvance(View view) {
startActivity(new Intent(this,IitActivity.class));
    }
}
