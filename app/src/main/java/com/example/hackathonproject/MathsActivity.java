package com.example.hackathonproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MathsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maths);
    }

    public void intermpc(View view) {
        startActivity(new Intent(this,MpcAactivity.class));
    }

    public void intermec(View view) {
        startActivity(new Intent(this,MpcAactivity.class));

    }
}
