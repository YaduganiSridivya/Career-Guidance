package com.example.hackathonproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EconomicsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_economics);
    }

    public void intercec(View view) {
        startActivity(new Intent(this,CecActivity.class));
    }

    public void internec(View view) {
        startActivity(new Intent(this,HecActivity.class));
    }
}
