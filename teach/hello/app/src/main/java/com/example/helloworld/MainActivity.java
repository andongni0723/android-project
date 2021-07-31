package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v("data","ontest");
        Log.d(TAG,"ontest");
        Log.i(TAG,"ontest");
        Log.w(TAG,"ontest");
        Log.e(TAG,"ontest");
    }
}