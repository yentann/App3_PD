package com.example.a17045679.app3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {

    Button kkurl;
    Button kkhotline;
    Button nuhurl;
    Button nuhhotline;
    Button sghurl;
    Button sghhotline;
    Button ttsurl;
    Button ttshotline;
    Button ktpurl;
    Button ktphotline;
    Button sengkangurl;
    Button sengkanghotline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        kkurl = findViewById(R.id.buttonKKurl);
        kkhotline = findViewById(R.id.buttonKKHotline);
        nuhurl = findViewById(R.id.buttonNUHurl);
        nuhhotline = findViewById(R.id.buttonNUHHotline);
        sghurl = findViewById(R.id.buttonSGHurl);
        sghhotline = findViewById(R.id.buttonSGHhotline);
        ttsurl = findViewById(R.id.buttonTTSurl);
        ttshotline = findViewById(R.id.buttonTTShotline);
        ktpurl = findViewById(R.id.buttonKTPurl);
        ktphotline = findViewById(R.id.buttonKTPhotline);
        sengkangurl = findViewById(R.id.buttonSengkangurl);
        sengkanghotline = findViewById(R.id.buttonSengkanghotline);




        //Title Name
        getSupportActionBar().setTitle("Hospitals");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        kkurl.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.kkh.com.sg/"));
                startActivity(intent);
            }
        });

        kkhotline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 62255554));
                startActivity(intent);
            }
        });


        nuhurl.setOnClickListener( new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.nuh.com.sg/"));
            startActivity(intent);
        }
        });

        nuhhotline.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 67795555));
            startActivity(intent);
        }
        });

        sghurl.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.sgh.com.sg/"));
                startActivity(intent);
            }
        });

        sghhotline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 62223322));
                startActivity(intent);
            }
        });

        ttsurl.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ttsh.com.sg/"));
                startActivity(intent);
            }
        });

        ttshotline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 62566011));
                startActivity(intent);
            }
        });

        ktpurl.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ktph.com.sg/"));
                startActivity(intent);
            }
        });

        ktphotline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 65558000));
                startActivity(intent);
            }
        });

        sengkangurl.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.skh.com.sg/"));
                startActivity(intent);
            }
        });

        sengkanghotline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + 69306000));
                startActivity(intent);
            }
        });
    }

    }
