package com.example.UAS_AKB_IF5_10120181;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

//Akhdan Rafly
//10120181
//IF-5
public class SplashScreen extends AppCompatActivity {

    Handler h = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, SliderActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
}
// Akhdan Rafly
// 10120181
// IF-5