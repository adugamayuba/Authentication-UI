package com.zamani.zamani;

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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class pinVerificatoin extends AppCompatActivity {
    private ProgressDialog progress;
   // progress=new ProgressDialog(this);
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    //   DatabaseReference d = com.google.firebase.database.DatabaseReference.goOnline();
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_verificatoin);



        Button vpin = findViewById(R.id.loginpin);

        vpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                verifypin();
            }
        });
    }

    public void verifypin(){


        final ProgressDialog progress;
        progress=new ProgressDialog(this);
        progress.setMessage("please wait... while we log you in");
        //progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(true);
        progress.setProgress(0);
        progress.show();


        EditText verpin = findViewById(R.id.loginpincollected);
        final  String    finalpin = verpin.getText().toString();




        mDatabase = FirebaseDatabase.getInstance().getReference();
        //  String key = mDatabase.child("user").push().getKey();



        DocumentReference user = db.collection("PIN").document("PIN");
        user.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot docname = task.getResult();
                    docname.get(finalpin);

                    String testpin = docname.get(finalpin).toString();






                    if(testpin.equals(finalpin)){

                        Intent  h = new Intent();

                        h.setClass(pinVerificatoin.this , ChannelActivity.class);
                        startActivity(h);
                        progress.cancel();
                    }else{
                        Toast.makeText(pinVerificatoin.this, "Authentication failed. YOU ARE HAVE NO ACTIVE SUBSCRIBTION AVAILABLE",
                                Toast.LENGTH_SHORT).show();
                        progress.cancel();

                    }


//                    StringBuilder fieldsNAME = new StringBuilder("");
//                    fieldsNAME.append("").append(docname.get(finalpin));
//                    TextView textDisplayname = findViewById(R.id.textView5);
//                    textDisplayname.setText(fieldsNAME.toString());
                    // String amprise = textDisplay.getText().toString();


                }
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {


                        progress.cancel();
                    }
                });




    }

}
