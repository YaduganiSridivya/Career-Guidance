package com.example.hackathonproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PhysicsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_physics);
    }

    public void intermpcphysics(View view) {
        startActivity(new Intent(this,MpcAactivity.class));
    }


    public void interbipcphysics(View view) {
        startActivity(new Intent(this,BipcActivity.class));
    }
}
