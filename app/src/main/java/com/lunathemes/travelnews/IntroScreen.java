package com.lunathemes.travelnews;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class IntroScreen extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_screen_layout);
        ImageView welcomeimage= (ImageView) findViewById(R.id.splash_IV);
        welcomeimage.setImageResource(R.drawable.splash_intro);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent mainintent= new Intent (IntroScreen.this, MainActivity.class);
                startActivity(mainintent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}