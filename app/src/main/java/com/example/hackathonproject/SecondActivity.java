package com.example.hackathonproject;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView.OnNavigationItemSelectedListener;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class SecondActivity extends AppCompatActivity
        implements OnNavigationItemSelectedListener {


FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Intent ik1=new Intent(this,HomeFragment.class);
        //startActivity(ik1);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id)
        {


            case  R.id.loginactivity: Intent ik=new Intent(this,SignupActivity.class);
                         startActivity(ik);
            break;
        }


        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        Fragment fragment=null;
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            fragment=new AboutFragment();
            // Handle the camera action
        }
        else if (id == R.id.nav_home) {
            fragment=new HomeFragment();

        } else if (id == R.id.nav_rateapp) {
            Intent i=new Intent(Intent.ACTION_VIEW);
            //inner parameter is uri pattern
            //address of the app
            i.setData(Uri.parse("market://details?id=com.tutorial.personal.androidstudiopro"));

            if(!isActivityStarted(i))
            {
                i.setData(Uri.parse("https://play.google.com"));
            }


        }
        else if (id == R.id.nav_manage)
        {
            fragment=new MailFragment();
        }
        else if (id == R.id.nav_share) {
            Intent i=new Intent();
            i.setAction(Intent.ACTION_SEND);
            i.putExtra(Intent.EXTRA_SUBJECT,"android studio pro");
            i.putExtra(Intent.EXTRA_TEXT,"https://play.google.com");

            i.setType("text/plain");
            startActivity(i);

        }




        if(fragment!=null)
        {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction ft=fragmentManager.beginTransaction();
//second is the id of the fragmentlayout in content_second.xml which is a container
            ft.replace(R.id.second,fragment);
            //paremeters are container view and fragment object
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private boolean isActivityStarted(Intent aIntent)
    {
        try {
            startActivity(aIntent);
            return true;
        }
        catch(ActivityNotFoundException e)
        {
            return false;
        }
    }
}
