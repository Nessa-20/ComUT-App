package com.example.comutapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RentOutVehicleActivity extends AppCompatActivity {

    private static final String TAG = "RentOutVehicleActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rentoutvehicle);
        Log.d(TAG, "onCreate: ");

        // By default, show the CarFragment when the activity is created
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new Fragment_rent_car())
                .commit();
    }

    public void onCarIconClicked(View view) {
        // Replace the current fragment with CarFragment
        Log.d(TAG, "onCarIconClicked: ");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new Fragment_rent_car())
                .commit();
    }

    public void onBikeIconClicked(View view) {
        // Replace the current fragment with BikeFragment
        Log.d(TAG, "onBikeIconClicked: ");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new Fragment_rent_bike())
                .commit();
    }

    // Click listener methods for the bottom navigation bar icons
    public void onHomeClicked(View view) {
        // Perform actions when the home button is clicked
        Log.d(TAG, "onHomeClicked: ");
        Toast.makeText(this, "Home button clicked", Toast.LENGTH_SHORT).show();
        // Add your logic to navigate to the home screen or perform any other action
    }

    public void onHistoryClicked(View view) {
        // Perform actions when the history button is clicked
        Log.d(TAG, "onHistoryClicked: ");
        Toast.makeText(this, "History button clicked", Toast.LENGTH_SHORT).show();
        // Add your logic to navigate to the history screen or perform any other action
    }

    public void onSettingsClicked(View view) {
        // Perform actions when the settings button is clicked
        Log.d(TAG, "onSettingsClicked: ");
        Toast.makeText(this, "Settings button clicked", Toast.LENGTH_SHORT).show();
        // Add your logic to navigate to the settings screen or perform any other action
    }

    public void onProfileClicked(View view) {
        // Perform actions when the profile button is clicked
        Log.d(TAG, "onProfileClicked: ");
        Toast.makeText(this, "Profile button clicked", Toast.LENGTH_SHORT).show();
        // Add your logic to navigate to the profile screen or perform any other action
    }
}
