package com.example.hackathonproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupActivity extends AppCompatActivity {

    String email,password;
    private EditText userpassword,useremail;
    private Button login,signup;

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setupUI();

        firebaseAuth=FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate())
                {
                    String user_email=useremail.getText().toString().trim();
                    String user_password=userpassword.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task)
                        {
                            if(task.isComplete())
                            {
                                sendEmailVerification();
Toast.makeText(SignupActivity.this,"successful",Toast.LENGTH_SHORT).show();
                                Intent i=new Intent(SignupActivity.this,RegistrationActivity.class);
                                startActivity(i);
                            }
                            else
                                Toast.makeText(SignupActivity.this," Not Successfully Registered",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(SignupActivity.this,RegistrationActivity.class);
                startActivity(i1);
            }
        });
    }

    private void setupUI()
    {
        useremail=(EditText)findViewById(R.id.signupemail);
       userpassword=(EditText)findViewById(R.id.signuppassword);
       login=(Button)findViewById(R.id.logininsignup);
       signup=(Button)findViewById(R.id.signupbutton);
    }

    private Boolean validate()
    {
        Boolean result=false;

       email=useremail.getText().toString();
       password=userpassword.getText().toString();

       if(email.isEmpty() || password.isEmpty())
       {
           Toast.makeText(this,"Please enter all details",Toast.LENGTH_SHORT).show() ;
       }
       else
       {
           result=true;
       }


       return result;
    }


    private void sendEmailVerification()
    {
        final FirebaseUser firebaseuser=firebaseAuth.getCurrentUser();

        if(firebaseuser!=null)
        {
            firebaseuser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful())
                    {
                     Toast.makeText(SignupActivity.this,"RegistrationActivity.class",Toast.LENGTH_SHORT).show();
                     startActivity(new Intent(SignupActivity.this,RegistrationActivity.class));
                }
                }
            });
        }
    }
}
