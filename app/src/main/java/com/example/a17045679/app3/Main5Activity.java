package com.example.a17045679.app3;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {

    //Register the receiver
    BroadcastReceiver br = new ReceiverSMS();

    TextView enterno;
    Button sms;


    public static final String USER_PREF = "USER_PREF" ;
    public static final String KEY_NUM = "KEY_NUM";
    SharedPreferences ss;



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        checkPermission();


        //Title Name
        getSupportActionBar().setTitle("Emergency");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        enterno = findViewById(R.id.editTextEnterNo);
        sms = findViewById(R.id.buttonSMS);

        ss = getSharedPreferences(USER_PREF, Context.MODE_PRIVATE);




         //sms Button
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Main5Activity.this);

                String number = sharedPreferences.getString("storedNumber", "");


                if (enterno.length() == 0) {
                    if(number.length() != 8) {
                        Toast.makeText(Main5Activity.this, "Number must be be 8-digits", Toast.LENGTH_SHORT).show();
                    }
                    else if (number.length()==8){
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(number, null, "Emergency", null, null);
                        Toast.makeText(Main5Activity.this, "Message Sent to " + number, Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    String num = enterno.getText().toString();

                    if (num.length() == 8) {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(num, null, "Emergency", null, null);
                        Toast.makeText(Main5Activity.this, "Message Sent to " + num, Toast.LENGTH_SHORT).show();
                        savePhoneNumber(num);
                    }
                    else{
                        Toast.makeText(Main5Activity.this, "Number must be be 8-digits", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });


        //Register the receiver
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction("android.provider.Telephony.SMS_RECEIVED");
        this.registerReceiver(br, filter);

        }

        //Unregister the receiver
        @Override
        protected void onDestroy() {
            super.onDestroy();
            this.unregisterReceiver(br);
        }

        //check for Permission
        private void checkPermission() {
            int permissionSendSMS = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
            int permissionRecvSMS = ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS);
            if (permissionSendSMS != PackageManager.PERMISSION_GRANTED && permissionRecvSMS != PackageManager.PERMISSION_GRANTED) {
                String[] permissionNeeded = new String[]{Manifest.permission.SEND_SMS, Manifest.permission.RECEIVE_SMS};
                ActivityCompat.requestPermissions(this, permissionNeeded, 1);
            }
        }


        private void savePhoneNumber(String value) {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("storedNumber", value);
            editor.commit();
    }


}










