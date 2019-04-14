package com.example.a17045679.app3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button Emergency;
    Button Hospital;
    Button About;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Title Name
        getSupportActionBar().setTitle("Home");


        Emergency = findViewById(R.id.emergency);
        Hospital = findViewById(R.id.hospital);
        About = findViewById(R.id.about);


        //Hospital Button
        Hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), Main3Activity.class);
                startActivity(intent);
            }
        });

        //About Button
        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), Main4Activity.class);
                startActivity(intent);
            }
        });

        //Emergency Button
        Emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), Main5Activity.class);
                startActivity(intent);
            }
        });

    }


        // Side Menu (Log Out)
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_logout, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here.

            Intent intent = new Intent(getBaseContext(), MainLoginActivity.class);
            Toast.makeText(MainActivity.this, "Logout Successful", Toast.LENGTH_LONG).show();
            startActivity(intent);
            return super.onOptionsItemSelected(item);
        }

}
