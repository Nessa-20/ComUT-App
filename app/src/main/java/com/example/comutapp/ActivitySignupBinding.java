package com.example.comutapp;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import java.text.BreakIterator;


public class ActivitySignupBinding {
    public View signupButton;
    public EditText signupEmail;
    public EditText signupPassword;
    public EditText signupConfirm;
    public View loginRedirectText;
    public BreakIterator signupMobileNumber;
    private View rootView;
    private ActivitySignupBinding(View rootView) {
        this.rootView = rootView;
        // Initialize views
        signupButton = rootView.findViewById(R.id.signup_button);
        signupPassword = rootView.findViewById(R.id.signup_password);
        signupEmail = rootView.findViewById(R.id.signup_email);
        loginRedirectText = rootView.findViewById(R.id.loginRedirectText);
        signupConfirm = rootView.findViewById(R.id.signup_confirm);
    }

    public static ActivitySignupBinding inflate(LayoutInflater layoutInflater) {
        View rootView = layoutInflater.inflate(R.layout.activity_singup, null);
        return new ActivitySignupBinding(rootView);
    }

    public View getRoot() {
        return rootView;
    }
}
