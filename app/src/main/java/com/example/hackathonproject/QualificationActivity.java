package com.example.hackathonproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class QualificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qualification);
    }

    public void submpc(View view) {
        startActivity(new Intent(this,MpcAactivity.class));
    }

    public void subbipc(View view) {
        startActivity(new Intent(this,BipcActivity.class));
    }

    public void submec(View view) {
        startActivity(new Intent(this,MecActivity.class));
    }

    public void subcec(View view) {
        startActivity(new Intent(this,CecActivity.class));
    }

    public void hec(View view) {
        startActivity(new Intent(this,HecActivity.class));
    }
}
