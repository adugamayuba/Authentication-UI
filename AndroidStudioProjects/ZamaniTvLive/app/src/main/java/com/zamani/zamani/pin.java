package com.zamani.zamani;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class pin extends AppCompatActivity {


    FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);

        Button setingpin;

        setingpin = findViewById(R.id.pin);

        setingpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setpin();

            }
        });


    }



    public void setpin(){
        final ProgressDialog progress;
        progress=new ProgressDialog(this);
        progress.setMessage("please wait... while we set your pin");
        //progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(true);
        progress.setProgress(0);
        progress.show();


        EditText pincollected = findViewById(R.id.pincollected);
        String Stringpin = pincollected.getText().toString();

        final Map<String, Object> pin = new HashMap<>();

        pin.put(Stringpin,Stringpin );

//        mDocRef.put(dataToSave);


        db.collection("PIN").document("PIN")
                .set(pin)

                .addOnSuccessListener(new OnSuccessListener() {
                    @Override
                    public void onSuccess(Object o) {

                        Intent ag = new Intent();
                        ag.setClass(pin.this , pinVerificatoin.class);
                        startActivity(ag);
                        progress.cancel();

                    }

                }).addOnFailureListener(new OnFailureListener(){
            @Override
            public void onFailure(@NonNull Exception e){
progress.cancel();
                Log.w("pin", "Error adding document", e);
            }
        });
    }
}
