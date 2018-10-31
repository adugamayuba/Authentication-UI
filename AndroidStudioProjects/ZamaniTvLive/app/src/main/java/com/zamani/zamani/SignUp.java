package com.zamani.zamani;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import com.zamani.zamani.data.model.Post;
import com.zamani.zamani.data.remote.APIService;
import com.zamani.zamani.data.remote.ApiUtils;

import java.util.HashMap;
import java.util.Map;



public class SignUp extends AppCompatActivity {
    private static final String TAG = "SignUp";
    private APIService mAPIService;

    private FirebaseAuth mAuth;

    private ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final RequestQueue queue = Volley.newRequestQueue(this);

        progress=new ProgressDialog(this);

        Button submitBtn = (Button) findViewById(R.id.btnsignup);
//        mResponseTv = (TextView) findViewById(R.id.tv_response);




        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {






                progress.setMessage("Signing Up Please wait...");
                //progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progress.setIndeterminate(true);
                progress.setProgress(0);
                progress.show();


                final EditText UserEmail = (EditText) findViewById(R.id.signupemail);
                final EditText UserPassword = (EditText) findViewById(R.id.signuppassword);
                final EditText Userfullname = (EditText) findViewById(R.id.fullname);

                final String fullname = Userfullname.getText().toString().trim();
                final  String  email = UserEmail.getText().toString().trim();
                final String password = UserPassword.getText().toString().trim();


                mAuth = FirebaseAuth.getInstance();




                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();

                                    Intent i = new Intent();
                                    i.setClass(SignUp.this, login.class);
                                    startActivity(i);
                                    finish();

                                } else {

                                    progress.cancel();
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(SignUp.this, "Registration failed" +
                                                    "Invalid Fields",
                                            Toast.LENGTH_SHORT).show();



                                }

                                // ...
                            }
                        });

//                String  url = "https://zamanitv-staging.herokuapp.com/api/v1/entrance/signup";
//                StringRequest postRequest = new StringRequest(Request.Method.POST, url,
//
//                        new Response.Listener<String>() {
//                            public void onResponse(String response) {
//                                // response
//                                Log.d("Response", response);
//                                Toast.makeText(SignUp.this, "SignUp successful", Toast.LENGTH_LONG).show();
//                                progress.cancel();
//                                Intent bact = new Intent();
//                                bact.setClass(SignUp.this, login.class);
//                                startActivity(bact);
//                                finish();
//                            }
//                        },
//                        new Response.ErrorListener() {
//
//
//                            public void onErrorResponse(VolleyError error) {
//                                // error
//                                progress.cancel();
//                                Toast.makeText(SignUp.this, "Signup Failed", Toast.LENGTH_LONG).show();
//
//
//                            }
//                        }
//                ) {
//                    @Override
//                    protected Map<String, String> getParams()
//                    {
//                        Map<String, String>  params = new HashMap<String, String>();
//                        params.put("emailAddress", Email);
//                        params.put("password", Password);
//
//                        params.put("fullName", fullname);
//
//                        return params;
//                    }
//                };
//                queue.add(postRequest);




            }

        });
    }







}