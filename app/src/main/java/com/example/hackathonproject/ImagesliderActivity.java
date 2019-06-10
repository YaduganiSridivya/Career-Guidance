package com.example.hackathonproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import android.content.Intent;

import com.google.firebase.auth.FirebaseAuth;

public class ImagesliderActivity extends AppCompatActivity {
private TextView t;
private FirebaseAuth firebaseAuth;
    int[] nameList={R.drawable.first,R.drawable.firstcareer,R.drawable.careericon,R.drawable.career2,R.drawable.career3,R.drawable.qualification,R.drawable.career,R.drawable.careerpath,R.drawable.career2,R.drawable.career3,R.drawable.career4};

    private int index=0;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.imageslider,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch(item.getItemId())
       {
           case R.id.logout1:firebaseAuth.signOut();
           finish();
           startActivity(new Intent(this,RegistrationActivity.class));
           break;
       }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageslider);
        firebaseAuth=FirebaseAuth.getInstance();
        final ImageSwitcher imageSwitcher=findViewById(R.id.imageswitcher);

        if(imageSwitcher!=null)
        {
            imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
                @Override
                public View makeView() {
                    ImageView imageView=new ImageView(getApplicationContext());

                    imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

        imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));

        return imageView;
                }
            });

            imageSwitcher.setImageResource(nameList[index]);

            Animation in= AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
            imageSwitcher.setInAnimation(in);

            Animation out= AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
            imageSwitcher.setInAnimation(out);

        }

        Button b=findViewById(R.id.buttonswitcher);

        if(b!=null)
        {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    index=(++index<nameList.length)?index:0;

                    if(imageSwitcher!=null)
                        imageSwitcher.setImageResource(nameList[index]);
                }
            });
        }

        t=(TextView)findViewById(R.id.query);
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(ImagesliderActivity.this,SecondActivity.class);
                startActivity(i1);
            }
        });


    }
}
