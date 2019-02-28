package com.example.dokiw.sensortest;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import java.util.List;

public class AccelerometerActivity extends AppCompatActivity {

    private ImageView colorZone;
    private SensorManager sManager;
    private List<Sensor> sensors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accelerometer);

        colorZone = findViewById(R.id.colorTest);

        sManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensors = sManager.getSensorList(Sensor.TYPE_ALL);
    }

    public void goBack(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
