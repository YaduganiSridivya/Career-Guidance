package com.example.hackathonproject;

import android.app.ProgressDialog;
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
import com.google.firebase.database.DatabaseReference;

public class RegistrationActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private Button login,signup,forgot;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    DatabaseReference userIdRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        start();

        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        FirebaseUser user=firebaseAuth.getCurrentUser();

        if(user!=null)
        {
            finish();//destroy this and let move to other activity
            Intent i2=new Intent(this,ImagesliderActivity.class);
            startActivity(i2);
        }

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2=new Intent(RegistrationActivity.this,SignupActivity.class);
                startActivity(i2);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(email.getText().toString(),password.getText().toString());
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3=new Intent(RegistrationActivity.this,PasswordActivity.class);
                startActivity(i3);
            }
        });

    }//end of oncreate



    private void start() {
    email=(EditText)findViewById(R.id.loginemail);
    password=(EditText)findViewById(R.id.loginpassword);
    login=(Button) findViewById(R.id.loginbutton1);
    forgot=(Button) findViewById(R.id.forgotpassword);
    signup=(Button) findViewById(R.id.signup);
}
    private void validate(String useremail,String userpassword )
    {
        progressDialog.setMessage("Passion is fuel of success");
        firebaseAuth.signInWithEmailAndPassword(useremail, userpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    progressDialog.dismiss();
                    //Intent i2=new Intent(RegistrationActivity.this,ImagesliderActivity.class);
                    //startActivity(i2);
                    checkEmailVerification();
                    ///Toast.makeText(RegistrationActivity.this,"Welcome to the Carrer path finding app",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(RegistrationActivity.this,"Invalid email or password",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void checkEmailVerification()
    {
        FirebaseUser firebaseUser=firebaseAuth.getInstance().getCurrentUser();
        Boolean emailflag=firebaseUser.isEmailVerified();

        startActivity(new Intent(this,ImagesliderActivity.class));

       /*if(emailflag)
        {
            finish();
            startActivity(new Intent(RegistrationActivity.this,ImagesliderActivity.class));
        }
        else
        {
            Toast.makeText(this,"verify ur email",Toast.LENGTH_SHORT).show();
            //firebaseAuth.signOut();
        }*/
    }
}
