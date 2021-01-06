package com.example.covid_19_application;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lauch_activity);

        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent i = new Intent("com.example.covid_19_application.FIRSTACTIVITY");
                    startActivity(i);
                }


            }

        };

        thread.start();


    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}














