package com.example.comutapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class fragment_get_bike extends Fragment {

    private EditText editOwnerName, editDrivingLicense;
    private ImageButton savedetailsButton;
    private Button btnUploadDrivingLicense;
    private String drivingLicensePath, otherIdentityProofPath;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_fragment_get_bike, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Initialize EditText fields
        editOwnerName = view.findViewById(R.id.editOwnerName);
        editDrivingLicense = view.findViewById(R.id.editDrivingLicense);

        // Initialize buttons
        btnUploadDrivingLicense = view.findViewById(R.id.btnUploadDrivingLicense);
        Button btnUploadOtherIdentityProof = view.findViewById(R.id.btnUploadOtherIdentityProof);
        savedetailsButton = view.findViewById(R.id.savedetails);

        // Set click listeners for document upload buttons
        btnUploadDrivingLicense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement document upload functionality here
                // For example, launch file picker or document scanner
                // Once the user selects a document, store its path
                drivingLicensePath = "/path/to/driving/license";
            }
        });

        btnUploadOtherIdentityProof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implement document upload functionality here
                // For example, launch file picker or document scanner
                // Once the user selects a document, store its path
                otherIdentityProofPath = "/path/to/other/identity/proof";
            }
        });

        savedetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get user input from EditText fields
                String ownerName = editOwnerName.getText().toString();
                String drivingLicense = editDrivingLicense.getText().toString();

                // Pass user input and document paths to the next activity using Intent
                Intent intent = new Intent(getActivity(), get_bike.class);
                intent.putExtra("ownerName", ownerName);
                intent.putExtra("drivingLicense", drivingLicense);
                intent.putExtra("drivingLicensePath", drivingLicensePath);
                intent.putExtra("otherIdentityProofPath", otherIdentityProofPath);
                startActivity(intent);
            }
        });
    }
}
