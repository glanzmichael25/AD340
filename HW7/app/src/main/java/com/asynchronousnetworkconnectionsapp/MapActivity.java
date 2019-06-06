package com.asynchronousnetworkconnectionsapp;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    //declares variables
    final static String TAG = "MAP";
    private FusedLocationProviderClient mLocationClient;
    private boolean mLocationPermissionGranted = false;
    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        //gets references to map fragment
        mLocationClient = LocationServices.getFusedLocationProviderClient(this);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    //gets location permission
    private void getLocationPermission() {
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mLocationPermissionGranted=true;
        } else {
            ActivityCompat.requestPermissions(this, new String[]{ Manifest.permission.ACCESS_FINE_LOCATION }, 1);
        }
    }



    //gets results of permission
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){
        mLocationPermissionGranted = false;
        switch(requestCode) {
            case 1: {
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    mLocationPermissionGranted=true;
                    getLocation();
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    private void getLocation() {

        if(mLocationPermissionGranted){
            Task location = mLocationClient.getLastLocation();

            location.addOnCompleteListener(new OnCompleteListener<Location>() {

                @Override
                public void onComplete(@NonNull Task<Location> task) {
                    Location actualLoction = task.getResult();
                    if (actualLoction != null) {
                        String latLong = String.format("Lat: %f, Long: %f",
                                actualLoction.getLatitude(),
                                actualLoction.getLongitude());

                        mMap.setMyLocationEnabled(true);
                        mMap.getUiSettings().setMyLocationButtonEnabled(true);

                        //Update the map
                        LatLng here = new LatLng(actualLoction.getLatitude(),
                                actualLoction.getLongitude());
                        mMap.addMarker(new MarkerOptions().position(here).title("Current location"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(here, 10));
                        mMap.animateCamera(CameraUpdateFactory.zoomTo(10));

                    }else{
                        Log.e(TAG, "Location is null..");
                    }
                }
            });
            location.addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.e(TAG, e.getLocalizedMessage());
                }
            });
        }
    }
    //sets up map location
    @Override
    public void onMapReady(GoogleMap googleMap) {


        mMap = googleMap;

        getLocationPermission();

        getLocation();


    }
}
