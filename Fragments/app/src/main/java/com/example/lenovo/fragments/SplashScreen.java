package com.example.lenovo.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Lenovo on 09-06-2016.
 */
public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text);
        Thread timer=new Thread() {
            public void run(){
               try{
                   sleep(4000);
               }
               catch (InterruptedException e){
                   e.printStackTrace();
               }
                finally {
                   Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                   startActivity(intent);
               }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
