package com.app1.neil.ca2emoji;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class SplashScreen extends Activity {

    private final int SplashScreenTime = 4000;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.splash_screen);

            new Handler().postDelayed(new Runnable() {
                public void run() {

                        Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                        startActivity(intent);
                        finish(); //destroy activity

                }
                }, SplashScreenTime);


        }

    }
