package com.example.comutapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class OTPVerificationActivity extends AppCompatActivity {
    private EditText editTextPhoneNumber, editTextOTP;
    private Button buttonSendOTP, buttonVerifyOTP, buttonRentOutVehicle, buttonGetVehicleOnRent;
    private TextView textViewWelcomeMessage;
    private String generatedOTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpverification);
        // Initialize views
        editTextPhoneNumber = findViewById(R.id.editTextPhoneNumber);
        editTextOTP = findViewById(R.id.editTextOTP);
        buttonSendOTP = findViewById(R.id.buttonSendOTP);
        buttonVerifyOTP = findViewById(R.id.buttonVerifyOTP);
        textViewWelcomeMessage = findViewById(R.id.textViewWelcomeMessage);
        buttonRentOutVehicle = findViewById(R.id.buttonRentOutVehicle);
        buttonGetVehicleOnRent = findViewById(R.id.buttonGetVehicleOnRent);

        // Set click listener for Send OTP button
        buttonSendOTP.setOnClickListener(v -> {
            // Generate and send OTP
            String phoneNumber = editTextPhoneNumber.getText().toString().trim();
            if (phoneNumber.isEmpty()) {
                Toast.makeText(OTPVerificationActivity.this, "Please enter phone number", Toast.LENGTH_SHORT).show();
            } else {
                generatedOTP = generateOTP();
                // Here you would send the OTP to the provided phone number via SMS
                // For demo purposes, we'll just display it in a Toast
                Toast.makeText(OTPVerificationActivity.this, "OTP sent to " + phoneNumber + ": " + generatedOTP, Toast.LENGTH_SHORT).show();
                // Show OTP EditText and Verify OTP button
                editTextOTP.setVisibility(View.VISIBLE);
                buttonVerifyOTP.setVisibility(View.VISIBLE);
                // Show options
                showOptions();
            }
        });

        // Set click listener for Verify OTP button
        buttonVerifyOTP.setOnClickListener(v -> {
            // Verify OTP
            String enteredOTP = editTextOTP.getText().toString().trim();
            if (enteredOTP.isEmpty()) {
                Toast.makeText(OTPVerificationActivity.this, "Please enter OTP", Toast.LENGTH_SHORT).show();
            } else if (enteredOTP.equals(generatedOTP)) {
                // OTP verification successful
                showWelcomeMessageAndOptions();
            } else {
                Toast.makeText(OTPVerificationActivity.this, "Invalid OTP", Toast.LENGTH_SHORT).show();
            }
        });

        // Set click listeners for option buttons
        buttonRentOutVehicle.setOnClickListener(v -> {
            // Handle "Rent Out a Vehicle" option
            Toast.makeText(OTPVerificationActivity.this, "Rent Out a Vehicle", Toast.LENGTH_SHORT).show();

            // Navigate to the RentOutVehicleActivity
            Intent intent = new Intent(OTPVerificationActivity.this, RentOutVehicleActivity.class);
            startActivity(intent);

            // Apply motion effect
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });

        buttonGetVehicleOnRent.setOnClickListener(v -> {
            // Handle "Get a Vehicle on Rent" option
            Toast.makeText(OTPVerificationActivity.this, "Get a Vehicle on Rent", Toast.LENGTH_SHORT).show();

            // Navigate to the VehicleRentActivity
            Intent intent = new Intent(OTPVerificationActivity.this, Getvehicleonrent.class);
            startActivity(intent);

            // Apply motion effect
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        });
    }

    // Method to generate a random 4-digit OTP
    private String generateOTP() {
        Random random = new Random();
        int otp = random.nextInt(9000) + 1000; // Generate a 4-digit random number
        return String.valueOf(otp);
    }

    // Method to show welcome message and options
    private void showWelcomeMessageAndOptions() {
        textViewWelcomeMessage.setVisibility(View.VISIBLE);
        editTextPhoneNumber.setVisibility(View.GONE);
        editTextOTP.setVisibility(View.GONE);
        buttonSendOTP.setVisibility(View.GONE);
        buttonVerifyOTP.setVisibility(View.GONE);
        // Show option buttons
        findViewById(R.id.optionsLayout).setVisibility(View.VISIBLE);
    }

    // Method to show options
    private void showOptions() {
        buttonRentOutVehicle.setVisibility(View.VISIBLE);
        buttonGetVehicleOnRent.setVisibility(View.VISIBLE);
    }
}
