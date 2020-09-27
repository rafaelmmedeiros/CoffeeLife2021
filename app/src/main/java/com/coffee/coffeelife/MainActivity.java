package com.coffee.coffeelife;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;


public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 1000;

    private Handler handler;
    private ProgressBar progress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        progress = (ProgressBar) findViewById(R.id.loading_bar);
        handler = new Handler();

        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                for (int i = 1; i <= 100; i++) {
                    final int value = i;
                    try {
                        //define 1/10 segundo como o tempo para a barra
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            //define o valor para a barra
                            progress.setProgress(value);
                        }
                    });
                }
                Intent dashBoardIntent = new Intent(MainActivity.this, DashboardActivity.class);
                startActivity(dashBoardIntent);
                finish();
            }
        };

        new Thread(runnable).start();

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent dashBoardIntent = new Intent(MainActivity.this, DashboardActivity.class);
//                startActivity(dashBoardIntent);
//                finish();
//            }
//        }, SPLASH_TIME_OUT);
    }


}