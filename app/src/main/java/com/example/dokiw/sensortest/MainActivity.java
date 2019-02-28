package com.example.dokiw.sensortest;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ListView lilist;
    private SensorManager sManager;
    private List<Sensor> sensors;
    private List<String> sensorName;
    private List<String> sensorType;
    private String[] sensorList = {Sensor.STRING_TYPE_ACCELEROMETER, Sensor.STRING_TYPE_ACCELEROMETER_UNCALIBRATED, Sensor.STRING_TYPE_GRAVITY, Sensor.STRING_TYPE_GYROSCOPE, Sensor.STRING_TYPE_GYROSCOPE_UNCALIBRATED, Sensor.STRING_TYPE_LIGHT, Sensor.STRING_TYPE_LINEAR_ACCELERATION, Sensor.STRING_TYPE_MAGNETIC_FIELD, Sensor.STRING_TYPE_MAGNETIC_FIELD_UNCALIBRATED, Sensor.STRING_TYPE_ORIENTATION, Sensor.STRING_TYPE_PRESSURE, Sensor.STRING_TYPE_PROXIMITY, Sensor.STRING_TYPE_RELATIVE_HUMIDITY, Sensor.STRING_TYPE_ROTATION_VECTOR, Sensor.STRING_TYPE_AMBIENT_TEMPERATURE};
    private List<String> sUnavailable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lilist = findViewById(R.id.laListe);

        sManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensors = sManager.getSensorList(Sensor.TYPE_ALL);
        sensorName = new ArrayList<String>();
        sensorType = new ArrayList<String>();

        for (Sensor sensor:sensors) {
            sensorName.add(sensor.getName());
            sensorType.add(sensor.getStringType());
        }

        lilist.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, sensorName));
    }

    public void checkSensors(View view){
        sUnavailable = new LinkedList<String>(Arrays.asList(sensorList));
        for(int i=0; i < sensorType.size();i++){
            for(int j=0; j < sUnavailable.size();j++){
                if(sUnavailable.get(j).equals(sensorType.get(i))){
                    sUnavailable.remove(j);
                    break;
                }
            }
        }
        lilist.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sUnavailable));
    }

    public void toAcceleroTest(View view){
        Intent iAccelTest = new Intent(this, AccelerometerActivity.class);
        startActivity(iAccelTest);
    }

}
