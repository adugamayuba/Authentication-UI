package com.zamani.zamani;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class me extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);

        ImageButton back = findViewById(R.id.imageButton);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myprofile = new Intent();

                myprofile.setClass(me.this, ChannelActivity.class);

                startActivity(myprofile);
                finish();
            }
        });

//
//        TextView back_button = findViewById(R.id.myacccount);
//// Register the onClick listener with the implementation above
//        back_button.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent bact = new Intent();
//                bact.setClass(me.this, MyAccount.class);
//                startActivity(bact);
//                finish();
//
//            }
//        });
    }
}