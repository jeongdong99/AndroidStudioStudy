package com.example.task3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("#########","OnCreate called!!!");
    }
    @Override
    protected void onStart() {
        super.onStart();
        // The activity is about to become visible.
        Log.e("#########"," OnStart called!!!");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
// The activity is between stopped and started.
        Log.e("#########"," OnRestart called!!!");
    }
    @Override
    protected void onResume() {
        super.onResume();
// The activity has become visible
// it is now "resumed"
        Log.e("#########","onResume called!!!");
    }
    @Override
    protected void onPause() {
        super.onPause();
// Another activity is taking focus
// this activity is about to be "paused"
        Log.e("#########"," onPause called!!!");
    }
    @Override
    protected void onStop() {
        super.onStop();
// The activity is no longer visible
// it is now "stopped"
        Log.e("#########"," onStop called!!!");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
// The activity is about to be destroyed.
        Log.e("#########"," onDestroy called!!!");
    }
}