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
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.HashMap;
import java.util.Map;


public class login extends AppCompatActivity {
    private static final String TAG = "login";
    Button but;
    EditText text1, text2;
    private FirebaseAuth mAuth;


    private ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        TextView signup = findViewById(R.id.text5);
// Register the onClick listener with the implementation above
        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent signup = new Intent();
                signup.setClass(login.this, SignUp.class);
                startActivity(signup);
                finish();

            }
        });




        ImageButton back_button = findViewById(R.id.backButton);
// Register the onClick listener with the implementation above
        back_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent bact = new Intent();
                bact.setClass(login.this, welcome.class);
                startActivity(bact);
                finish();

            }
        });
      //  final    RequestQueue queue = Volley.newRequestQueue(this);
        progress=new ProgressDialog(this);
        Button login_button = findViewById(R.id.button3);
// Register the onClick listener with the implementation above
        login_button.setOnClickListener(new View.OnClickListener() {


            public void onClick(View v) {




                progress.setMessage("please wait... while we log you in");
                //progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progress.setIndeterminate(true);
                progress.setProgress(0);
                progress.show();



                        EditText UserEmail = (EditText) findViewById(R.id.loginemail);
                        EditText UserPassword = (EditText) findViewById(R.id.loginpassword);



                        String email = UserEmail.getText().toString();
                        String password = UserPassword.getText().toString();
                mAuth = FirebaseAuth.getInstance();
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();

                                    Intent i = new Intent();
                                    i.setClass(login.this, SubscribtionPayment.class);
                                    startActivity(i);
                                    finish();

                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.d(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(login.this, "Authentication failed. ",
                                            Toast.LENGTH_SHORT).show();
                                    progress.cancel();

                                }


                                // ...
                            }
                        });
//                String url = "https://zamanitv-staging.herokuapp.com/api/v1/entrance/login";
//                StringRequest putRequest = new StringRequest(Request.Method.PUT, url,
//                        new Response.Listener<String>() {
//                            @Override
//                            public void onResponse(String response) {
//                                // response
//                                Log.d("Response", response);
//                                Toast.makeText(login.this, "Login success", Toast.LENGTH_LONG).show();
//                                progress.cancel();
//                                Intent bact = new Intent();
//                                bact.setClass(login.this, ChannelActivity.class);
//                                startActivity(bact);
//                                finish();
//                            }
//                        },
//                        new Response.ErrorListener() {
//                            @Override
//                            public void onErrorResponse(VolleyError error) {
//                                // error
//                                progress.cancel();
//                                Toast.makeText(login.this, "Login Failed", Toast.LENGTH_LONG).show();
//
//                            }
//                        }
//                ) {
//
//                    @Override
//                    protected Map<String, String> getParams() {
//
//
//                        EditText UserEmail = (EditText) findViewById(R.id.loginemail);
//                        EditText UserPassword = (EditText) findViewById(R.id.loginpassword);
//
//
//
//                        String  Email = UserEmail.getText().toString().trim();
//                        String Password = UserPassword.getText().toString().trim();
//
//
//                        Map<String, String> params = new HashMap<String, String>();
//                        params.put("emailAddress", Email);
//                        params.put("password", Password);
//
//                        return params;
//                    }
//
//                };
//
//                queue.add(putRequest);




            }
        });


    }







}