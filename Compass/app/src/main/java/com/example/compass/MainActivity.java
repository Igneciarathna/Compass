package com.example.compass;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private TextView textView;
    private ImageView imageView;
    private SensorManager sensorManager;
    private Sensor accelerometer,magnetometer;
    private float[]lastAccelerometer=new float[3];
    private float[]lastMagnetometer=new float[3];
    private float[]rotationMatrix=new float[9];
    private float[]orientation=new float[3];

    boolean isLastAccelerometerArrayCopied=false;
    boolean isLastMagnetometerArrayCopied=false;

    long lastUpdatedTime=0;
    float outerDegree=0f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        textView=findViewById(R.id.TextView);
        imageView=findViewById(R.id.imageView);
        sensorManager=(sensorManager).getSystemService(SENSOR_SERVICE);
        accelerometer=SensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        magnetometer=SensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
    @Override
    protected void onResume() {

        super.onResume();
        sensorManager.registerListener(this, accelerometerSensor,SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(listener this, magnetometerSensor,SensorManager.SENSOR_DELAY_NORMAL);
    }
}