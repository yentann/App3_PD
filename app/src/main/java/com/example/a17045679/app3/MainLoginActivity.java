package com.example.a17045679.app3;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainLoginActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainlogin);

        username = findViewById(R.id.editTextUsername);
        password = findViewById(R.id.editTextPassword);
        login = findViewById(R.id.buttonLogin);



        //Login Button
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((username.getText().toString().equals("test")) && (password.getText().toString().equals("password"))) {
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(MainLoginActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(MainLoginActivity.this, "Username or Password is Wrong", Toast.LENGTH_LONG).show();
                }



            }
        });

    }
        // Side Menu (Log Out)
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_sms, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here.
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(MainLoginActivity.this);

            String number = sharedPreferences.getString("storedNumber", "");

            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(number, null, "Emergency", null, null);
            Toast.makeText(MainLoginActivity.this, "Message Sent to " + number, Toast.LENGTH_SHORT).show();

            return super.onOptionsItemSelected(item);
        }

}




