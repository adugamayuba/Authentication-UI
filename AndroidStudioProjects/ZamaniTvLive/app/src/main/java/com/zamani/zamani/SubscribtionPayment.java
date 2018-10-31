package com.zamani.zamani;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import co.paystack.android.Paystack;
import co.paystack.android.PaystackSdk;
import co.paystack.android.Transaction;
import co.paystack.android.model.Card;
import co.paystack.android.model.Charge;

public class SubscribtionPayment extends AppCompatActivity {
    private static final String TAG = "pay_loan";


    public static final String loan_email = "Request Email Address";
    public static final String loan_request_name = "Request Name";
    public static final String NAME_KEY = "NAME";
    public static final String card_number = "Card Number";
    public static final String card_expiryMonth = "Card Expiry Month";
    public static final String card_expiryYear = "Card Expiry Year";
    public static final String card_cvv = "Card Cvv";
    public static final String Ema_il = "Email";

    public static TextView textDisplay;

    private Card card;
    private Charge charge;


    String cardNumber;
    //  int expiryMonth;
    //  int expiryYear;


    String emonthint;
    String expiryYearint;
    String cvv;
    String email;
    String fullname;

    EditText expiry;
    EditText cnumber;
    EditText emonth;
    EditText usercvv;
    EditText useremail;
    EditText name;
    int expiryMonth;
    int expiryYear;
    String uemailinput;
    String m_Text;

    String key;

    private ProgressDialog progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribtion_payment);
        textDisplay = findViewById(R.id.textView12);

TextView sub = findViewById(R.id.alreadysubscribed);

sub.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent subscribe = new Intent();
        subscribe.setClass(SubscribtionPayment.this , pinVerificatoin.class);
        startActivity(subscribe);
    }
});

        AlertDialog.Builder alertDialogBuilder2 = new AlertDialog.Builder(this);
        alertDialogBuilder2.setTitle("SUBSCRIBTION PLAN");
        alertDialogBuilder2.setMessage("YOU WILL BE CHARGED 3500 NAIRA TO BE VALID FOR ONE (1) MONTH");

        alertDialogBuilder2.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {

            }
        });

        AlertDialog alertDialo = alertDialogBuilder2.create();

        alertDialo.show();





















        PaystackSdk.initialize(getApplicationContext());


        //ReadSingleContact();
        //  validateForm();
        Button gloan = findViewById(R.id.button8);
// Register the onClick listener with the implementation above

        gloan.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                combinations();

            }
        });




    }


    public void thankyou() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Thank you");
        alertDialogBuilder.setMessage("PAYMENT SUCCESSFUL");

        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                finish();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();
    }


    public void combinations() {

        validatingcard();


    }



    public void validatingcard() {


        EditText cnumber = findViewById(R.id.card_number);
        final String cardNumber = cnumber.getText().toString();


        EditText expiry = findViewById(R.id.expiryyear);
        String expiryYearint = expiry.getText().toString();

        try{

            expiryYear = Integer.parseInt(expiryYearint);

        }catch(NumberFormatException ex){ // handle your exception

        }



        EditText emonth = findViewById(R.id.expirymonth);
        String emonthint = emonth.getText().toString();


        try{
            expiryMonth = Integer.parseInt(emonthint);
            // final int fexpiryMonth = expiryMonth;

        }catch(NumberFormatException ex){ // handle your exception

        }



        EditText usercvv = findViewById(R.id.cvv);
        final String cvv = usercvv.getText().toString();

        EditText useremail = findViewById(R.id.useremail);
        final String email = useremail.getText().toString();


        EditText name = findViewById(R.id.editText18);
        final String fullname = name.getText().toString();


        if (cardNumber.isEmpty() || expiryYearint.isEmpty() || emonthint.isEmpty() || cvv.isEmpty() || email.isEmpty() || fullname.isEmpty()) {
            boolean valid = true;


            if (TextUtils.isEmpty(cardNumber)) {
                cnumber.setError("Required.");
                valid = false;
            } else {
                cnumber.setError(null);
            }


            if (TextUtils.isEmpty(emonthint)) {
                emonth.setError("Required.");
                valid = false;
            } else {
                emonth.setError(null);
            }


            if (TextUtils.isEmpty(expiryYearint)) {
                expiry.setError("Required.");
                valid = false;
            } else {
                expiry.setError(null);
            }


            if (TextUtils.isEmpty(cvv)) {
                usercvv.setError("Required.");
                valid = false;
            } else {
                usercvv.setError(null);
            }


            if (TextUtils.isEmpty(email)) {
                useremail.setError("Required.");
                valid = false;
            } else {
                useremail.setError(null);

            }
            return;


        } else {





            Card card = new Card(cardNumber, expiryMonth, expiryYear, cvv);
            if (card.isValid()) {
                // charge card
                Toast.makeText(SubscribtionPayment.this, "Card is Valid", Toast.LENGTH_LONG).show();
                // performCharge();
                progress=new ProgressDialog(this);
                progress.setMessage("Payment processing...");
                //progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progress.setIndeterminate(true);
                progress.setProgress(0);
                progress.show();


                final int totalProgressTime = 100;

                charge = new Charge();

                //set the card to charge
                charge.setCard(card);

                //call this method if you set a plan
                //charge.setPlan("PLN_yourplan");

                charge.setEmail(email);//dummy email address
                charge.setPlan("PLN_7mj0rhcoh119ib9");
                String re = textDisplay.getText().toString();


                if(re.equals("N/A")){

                    Toast.makeText(SubscribtionPayment.this, "incorrect amount", Toast.LENGTH_LONG).show();


                }else {

                    int reamount = Integer.parseInt(re);
                    int realamount = reamount * 100;


                    charge.setAmount(realamount); //test amount

                    PaystackSdk.chargeCard(SubscribtionPayment.this, charge, new Paystack.TransactionCallback() {
                        @Override
                        public void onSuccess(Transaction transaction) {
                            // This is called only after transaction is deemed successful.
                            // Retrieve the transaction, and send its reference to your server
                            // for verification.
                            progress.cancel();
                            String paymentReference = transaction.getReference();
                            Toast.makeText(SubscribtionPayment.this, "Transaction Successful! payment reference: "
                                    + paymentReference, Toast.LENGTH_LONG).show();

                            Toast.makeText(SubscribtionPayment.this, "Payment Complete", Toast.LENGTH_LONG).show();

                            Intent bact = new Intent();
                            bact.setClass(SubscribtionPayment.this, pin.class);
                            startActivity(bact);
                            finish();




                        }

                        @Override
                        public void beforeValidate(Transaction transaction) {
                            // This is called only before requesting OTP.
                            // Save reference so you may send to server. If
                            // error occurs with OTP, you should still verify on server.
                        }

                        @Override
                        public void onError(Throwable error, Transaction transaction) {
                            //handle error here
                        }
                    });
                }

            } else {

                Toast.makeText(SubscribtionPayment.this, "Card is not valid", Toast.LENGTH_LONG).show();
            }


        }


    }



}


