package com.example.comutapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Getvehicleonrent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getvehicleonrent);

        // By default, show the CarFragment when the activity is created
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new fragment_get_car())
                .commit();
    }

    public void onCarIconClicked(View view) {
        // Replace the current fragment with CarFragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new fragment_get_car())
                .commit();
    }

    public void onBikeIconClicked(View view) {
        // Replace the current fragment with BikeFragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new fragment_get_bike())
                .commit();
    }

    // Click listener methods for the bottom navigation bar icons
    public void onHomeClicked(View view) {
        // Perform actions when the home button is clicked
        Toast.makeText(this, "Home button clicked", Toast.LENGTH_SHORT).show();
        // Add your logic to navigate to the home screen or perform any other action
    }

    public void onHistoryClicked(View view) {
        // Perform actions when the history button is clicked
        Toast.makeText(this, "History button clicked", Toast.LENGTH_SHORT).show();
        // Add your logic to navigate to the history screen or perform any other action
    }

    public void onSettingsClicked(View view) {
        // Perform actions when the settings button is clicked
        Toast.makeText(this, "Settings button clicked", Toast.LENGTH_SHORT).show();
        // Add your logic to navigate to the settings screen or perform any other action
    }

    public void onProfileClicked(View view) {
        // Perform actions when the profile button is clicked
        Toast.makeText(this, "Profile button clicked", Toast.LENGTH_SHORT).show();
        // Add your logic to navigate to the profile screen or perform any other action
    }
}
