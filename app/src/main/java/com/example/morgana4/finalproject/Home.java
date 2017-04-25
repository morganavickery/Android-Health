package com.example.morgana4.finalproject;

import android.content.Context;
import android.content.Intent;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    Button yogaIntent;
    Button distanceIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        yogaIntent = (Button) findViewById(R.id.yogaButton);
        distanceIntent = (Button) findViewById(R.id.distanceButton);

    }

    public void swapYoga(View v){
        Log.v("TAG", "swapped to yoga intent");
        Intent i = new Intent(this, YogaActivity.class);
        startActivity(i);
    }

    public void swapDistance(View v){
        Log.v("TAG", "swapped to distance intent");
    }
}
