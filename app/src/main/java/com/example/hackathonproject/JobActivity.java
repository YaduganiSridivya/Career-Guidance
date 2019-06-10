package com.example.hackathonproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class JobActivity extends AppCompatActivity {

    private RadioGroup proflist;
    private Button sub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job);
        proflist = (RadioGroup) findViewById(R.id.proflist);
       sub = (Button) findViewById(R.id.sub);


        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sel = proflist.getCheckedRadioButtonId();

                switch (sel)
                {
                    case R.id.eng:Intent i=new Intent(JobActivity.this,EngineeringActivity.class);
                    startActivity(i);break;
                    case R.id.doctor:Intent i1=new Intent(JobActivity.this,DoctorActivity.class);
                        startActivity(i1);break;
                    case R.id.teacher:break;
                    case R.id.pharma:break;
                }
            }
        });

    }
}
