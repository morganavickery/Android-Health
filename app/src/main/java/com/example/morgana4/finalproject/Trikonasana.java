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

public class Trikonasana extends AppCompatActivity implements SensorEventListener {

    Button yogaIntent;
    Button distanceIntent;
    private SensorManager sm;
    private Sensor acc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trikonasana);

        yogaIntent = (Button) findViewById(R.id.yogaButton);
        distanceIntent = (Button) findViewById(R.id.distanceButton);

        sm = YogaActivity.sm;
        acc = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, acc, SensorManager.SENSOR_DELAY_NORMAL);

        if (sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            acc = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sm.registerListener(this, acc, 1000000);
        }
    }

    public void startTracker(View v){
        //start timer and tracking sensor data
    }

    public void swapHome(View v){
        Log.v("TAG", "swapped to yoga intent");
        Intent i = new Intent(this, YogaActivity.class);
        startActivity(i);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(this, acc, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float xVal = sensorEvent.values[0];
        float yVal = sensorEvent.values[1];
        float zVal = sensorEvent.values[2];
        double value = Math.sqrt((xVal*xVal)+(yVal*yVal)+(zVal*zVal));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}