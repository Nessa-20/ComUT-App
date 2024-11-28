package com.example.comutapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());

        View rootView = binding.getRoot();
        if (rootView != null) {
            setContentView(rootView);
        } else {
            finish();
            return;
        }

        databaseHelper = new DatabaseHelper(this);

        binding.loginButton.setOnClickListener(view -> {
            String email = binding.loginEmail.getText().toString();
            String password = binding.loginPassword.getText().toString();

            if (email.isEmpty() || password.isEmpty()) {

                Toast.makeText(LoginActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(LoginActivity.this,OTPVerificationActivity.class);
                startActivity(intent);
                Boolean checkCredentials = databaseHelper.checkEmailPassword(email, password);

                if (checkCredentials) {
//                    Toast.makeText(LoginActivity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                    // Start OTPVerificationActivity after successful login


                    new Handler().postDelayed(() -> {
//                        Intent intent = new Intent(LoginActivity.this, OTPVerificationActivity.class);
//                        startActivity(intent);
                        finish();

                    },1000);
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.signupRedirectText.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
            startActivity(intent);
        });
    }
}

