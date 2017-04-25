package com.example.morgana4.finalproject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import java.util.ArrayList;

public class Virabhadrasana extends AppCompatActivity implements SensorEventListener {

    Button yogaIntent;
    Button distanceIntent;
    private SensorManager sm;
    private Sensor acc;
    Chronometer simpleChronometer;
    ArrayList<Double> valueList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virabhadrasana);

    yogaIntent = (Button) findViewById(R.id.yogaButton);
    distanceIntent = (Button) findViewById(R.id.distanceButton);

    sm = YogaActivity.sm;
    acc = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        if (sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
        acc = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, acc, sm.SENSOR_DELAY_NORMAL);

    }

    simpleChronometer = (Chronometer) findViewById(R.id.simpleChronometer); // initiate a chronometer
        simpleChronometer.setBase(SystemClock.elapsedRealtime() + (30000));

    valueList = new ArrayList<Double>();
}

    public void startTracker(View v){
        //start timer and tracking sensor data
        simpleChronometer.start();
        simpleChronometer.setBackgroundColor(Color.GREEN);
        simpleChronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {

            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if(chronometer.getText().toString().equalsIgnoreCase("00:00")) {
                    simpleChronometer.stop();
                    simpleChronometer.setBackgroundColor(Color.RED);
                    //give info from sensor
                }
            }
        });
    }

    protected void onResume() {
        super.onResume();
        sm.registerListener(this, acc, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        sm.unregisterListener(this);
    }


    public void swapHome(View v){
        Log.v("TAG", "swapped to yoga intent");
        Intent i = new Intent(this, YogaActivity.class);
        startActivity(i);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float xVal = sensorEvent.values[0];
        float yVal = sensorEvent.values[1];
        float zVal = sensorEvent.values[2];
        double value = Math.sqrt((xVal*xVal)+(yVal*yVal)+(zVal*zVal));
        valueList.add(value);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    public void onChronometerTick(Chronometer chronometer) {

    }
}
