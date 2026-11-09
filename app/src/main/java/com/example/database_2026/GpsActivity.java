package com.example.database_2026;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class GpsActivity extends AppCompatActivity implements LocationListener {
    private LocationManager lm;
    private LocationListener locListenD;
    public TextView tvLatitude;
    public TextView tvLongitude;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // find the TextViews
        tvLatitude = (TextView) findViewById(R.id.tvLatitude);
        tvLongitude = (TextView) findViewById(R.id.tvLongitude);
// get handle for LocationManager
        LocationManager lm = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            return;
        }
        Location loc = lm.getLastKnownLocation("gps");

        tvLatitude.setText("Latitude: "+Double.toString(loc.getLatitude()));
        tvLongitude.setText("Longitude: "+Double.toString(loc.getLongitude()));

    }

    @Override
    public void onLocationChanged(@NonNull Location location) {
        tvLatitude.setText("Latitude: "+Double.toString(location.getLatitude()));
        tvLongitude.setText("Longitude: "+Double.toString(location.getLongitude()));
    }

}
