package com.zamani.zamani;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Button log = findViewById(R.id.button);
        Button reg = findViewById(R.id.button2);


        log.setOnClickListener(new View.OnClickListener() {

            //            @Override
            public void onClick(View v) {
                mylogin();
            }
        });


        reg.setOnClickListener(new View.OnClickListener() {

            //            @Override
            public void onClick(View v) {
                mysignup();
            }
        });



    }


    public void mylogin(){
        Intent i = new Intent();
        i.setClass(welcome.this, login.class);
        startActivity(i);
        finish();
    }



    public void mysignup(){
        Intent hi = new Intent();
        hi.setClass(welcome.this, SignUp.class);
        startActivity(hi);
        finish();
    }
}