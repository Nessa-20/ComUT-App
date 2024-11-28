

package com.example.comutapp;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class ActivityLoginBinding {
    public View loginButton;
    public EditText loginEmail;
    public View signupRedirectText;
    public EditText loginPassword;
    private View rootView;

    // Private constructor to prevent direct instantiation
    private ActivityLoginBinding(View rootView) {
        this.rootView = rootView;
        // Initialize views
        loginButton = rootView.findViewById(R.id.loginbutton);
        loginEmail = rootView.findViewById(R.id.login_email);
        signupRedirectText = rootView.findViewById(R.id.signupRedirecText);
        loginPassword = rootView.findViewById(R.id.login_password);
    }

    // Static method to inflate layout and create binding
    public static ActivityLoginBinding inflate(LayoutInflater layoutInflater) {
        View rootView = layoutInflater.inflate(R.layout.activity_login, null);
        return new ActivityLoginBinding(rootView);
    }

    // Method to get the root view
    public View getRoot() {
        return rootView;
    }
}
