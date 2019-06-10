package com.example.hackathonproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChemistryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chemistry);
    }

    public void intermpcche(View view) {
        startActivity(new Intent(this,MpcAactivity.class));
    }

    public void interbipcchemistry(View view) {
        startActivity(new Intent(this,BipcActivity.class));
    }
}
