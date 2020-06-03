package com.example.activity_lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private String TAG = "tag";
    private boolean isLoggedIn = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate");

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
        checkLoginStatus();
        videoStatus(true);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
        isLoggedIn = false;
        videoStatus(false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onCreate");
        videoStatus(true);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    private void checkLoginStatus()
    {
        if (isLoggedIn){
            Log.d(TAG,"Logged In");
        }else
            Log.d(TAG,"Logged Out");
    }

    private void videoStatus(boolean isPlaying)
    {
        if (isPlaying){
            Log.d(TAG,"Video Playing");
        }else
            Log.d(TAG,"Video Stopped");
    }
}