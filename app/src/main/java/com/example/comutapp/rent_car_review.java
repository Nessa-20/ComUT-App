package com.example.comutapp;// FragmentReviewCar.java
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;

public class rent_car_review extends Fragment {

    // Define views
    private View rootView;
    private Button btnConfirm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_rent_car_review, container, false);

        // Initialize views
        btnConfirm = rootView.findViewById(R.id.btnConfirm);

        // Set click listener for confirm button
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle confirm button click (e.g., submit data)
            }
        });

        // Populate the review screen with entered details and uploaded documents
        populateReviewScreen();

        return rootView;
    }

    // Method to populate review screen with entered details and uploaded documents
    private void populateReviewScreen() {
        // Retrieve entered details and uploaded document paths/names from previous fragment
        // Display them in appropriate views on the review screen
    }
}
