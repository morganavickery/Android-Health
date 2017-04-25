package com.example.morgana4.finalproject;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class YogaActivity extends AppCompatActivity implements SensorEventListener {

    public static SensorManager sm;
    private Sensor acc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yoga);

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        acc = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, acc, SensorManager.SENSOR_DELAY_NORMAL);

        if (sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null){
            acc = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sm.registerListener(this, acc, 1000000);
        }

    }

    public void swapVrik(View v){
        Log.v("TAG", "swapped to yoga intent");
        Intent i = new Intent(this, Vriksasana.class);
        startActivity(i);
    }

    public void swapTrik(View v){
        Log.v("TAG", "swapped to yoga intent");
        Intent i = new Intent(this, Trikonasana.class);
        startActivity(i);
    }

    public void swapVirab(View v){
        Log.v("TAG", "swapped to yoga intent");
        Intent i = new Intent(this, Virabhadrasana.class);
        startActivity(i);
    }

    public void swapHome(View v){
        Log.v("TAG", "swapped to yoga intent");
        Intent i = new Intent(this, Home.class);
        startActivity(i);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        //none
    }

    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(this, acc, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    //none
    }
}
