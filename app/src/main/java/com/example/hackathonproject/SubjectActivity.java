package com.example.hackathonproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class SubjectActivity extends AppCompatActivity {

private CheckBox t1,t2,t3,t4,t5,t6,t7,t8;
private Button sub;
private int total=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);
        start();

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(t1.isChecked()) {total = 1; }
                if(t2.isChecked()) {total = 2; }
                if(t3.isChecked()) {total = 3; }
                if(t4.isChecked()) {total = 4; }
                if(t5.isChecked()) {total = 5; }
                if(t6.isChecked()) {total = 6; }//bipc
                if(t7.isChecked()) {total = 7; }//cec
                if(t8.isChecked()){total=31;}
                //TWO SUBJECT SELECTED
                if(t1.isChecked())
                {
                    if (t2.isChecked() || t3.isChecked()) {
                        total = 8;//mpc
                    }
                    if (t4.isChecked()||t5.isChecked() ) {
                        total = 9;//mec
                    }
                    if(t6.isChecked()||t5.isChecked()||t7.isChecked())
                    {
                        total=50;
                    }

                }

                if(t2.isChecked()) {//economics
                    if (t1.isChecked() || t3.isChecked()) {
                        total = 8;//mpc
                    }
                    if ( t6.isChecked()) {
                        total = 6;
                    }
                    if(t4.isChecked()||t5.isChecked()||t7.isChecked())
                    {
                        total=50;
                    }
                }

                if(t3.isChecked()) {
                    if (t1.isChecked() || t2.isChecked()) {
                        total = 8;//mpc
                    }
                    if ( t6.isChecked()) {
                        total = 6;
                    }
                    if(t4.isChecked()||t5.isChecked()||t7.isChecked())
                    {
                        total=50;
                    }
                }
                if(t4.isChecked())
                {
                    if (t1.isChecked() || t5.isChecked()) {
                        total = 9;//mec
                    }
                    if (t7.isChecked() ) {
                        total = 7;//cec
                    }
                    if(t2.isChecked()||t3.isChecked()||t6.isChecked())
                    {
                        total=50;
                    }


                }

                switch(total)
                {
                    case 1:
                        Intent i=new Intent(SubjectActivity.this,MathsActivity.class);
                        startActivity(i);break;

                    case 2:
                        Intent i2=new Intent(SubjectActivity.this,PhysicsActivity.class);
                        startActivity(i2);break;

                    case 3:
                        Intent i3=new Intent(SubjectActivity.this,ChemistryActivity.class);
                        startActivity(i3);break;
                    case 4:
                        Intent i4=new Intent(SubjectActivity.this,EconomicsActivity.class);
                        startActivity(i4);break;

                    case 5:
                    Intent i5=new Intent(SubjectActivity.this,ChemistryActivity.class);
                    startActivity(i5);break;

                    case 6:
                        Intent i6=new Intent(SubjectActivity.this,BipcActivity.class);
                        startActivity(i6);break;
                    case 7:
                        Intent i7=new Intent(SubjectActivity.this,CecActivity.class);
                        startActivity(i7);break;


                    case 8:
                        Intent ii=new Intent(SubjectActivity.this,MpcAactivity.class);
                        startActivity(ii);break;
                    case 9:
                        Intent i1=new Intent(SubjectActivity.this,MecActivity.class);
                        startActivity(i1);break;
                    case 31:
                    Intent i31=new Intent(SubjectActivity.this,BipcActivity.class);
                    startActivity(i31);break;
                    case 50:
                        Toast toast=Toast.makeText(getApplicationContext(),"this combination doesnot exist\nplease select subjects independently",Toast.LENGTH_SHORT);
                        toast.setMargin(50,50);
                        toast.show();break;
                }
            }
        });

    }

    private void start()
    {
        t1=(CheckBox)findViewById(R.id.maths);
        t2=(CheckBox)findViewById(R.id.physics);
        t3=(CheckBox)findViewById(R.id.chemistry);
        t4=(CheckBox)findViewById(R.id.economics);
        t5=(CheckBox)findViewById(R.id.commerce);
        t6=(CheckBox)findViewById(R.id.biology);
        t7=(CheckBox)findViewById(R.id.civics);
        t8=(CheckBox)findViewById(R.id.history);
        sub = (Button)findViewById(R.id.submitbutton);
    }
}
