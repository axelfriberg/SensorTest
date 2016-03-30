package com.axelfriberg.sensortest;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class AccelerometerActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private TextView mXcoord;
    private TextView mYcoord;
    private TextView mZcoord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mXcoord = (TextView) findViewById(R.id.xCoord);
        mYcoord = (TextView) findViewById(R.id.yCoord);
        mZcoord = (TextView) findViewById(R.id.zCoord);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public AccelerometerActivity() {

    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener( this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener( this);
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[2];

        mXcoord.setText("X: " + x);
        mYcoord.setText("Y: " + y);
        mZcoord.setText("Z: " + z);
    }

}
