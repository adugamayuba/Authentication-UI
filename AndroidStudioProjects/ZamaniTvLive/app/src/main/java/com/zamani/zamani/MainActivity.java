package com.zamani.zamani;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    private FirebaseUser user;
    private static int TIME_OUT = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loani();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                user = FirebaseAuth.getInstance().getCurrentUser();
                if(user != null){
                    //if user is not authenticated show authentication screen

                    Intent id = new Intent(MainActivity.this, pinVerificatoin.class);
                    startActivity(id);
                    finish();

                }else{

                    Intent i = new Intent(MainActivity.this, welcome.class);
                    startActivity(i);
                    finish();

                }


            }
        },TIME_OUT);
    }



    public void loani(){


        ImageView icon = (ImageView)findViewById(R.id.imageView);
//        animator  = AnimationUtils.loadAnimation(getApplicationContext(),
//                R.anim.fade);
//        header.startAnimation(animator);



        Animation animation;
        animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade);
        icon.startAnimation(animation);



        //   Ani();



    }
}



