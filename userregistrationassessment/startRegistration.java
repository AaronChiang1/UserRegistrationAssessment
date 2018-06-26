package com.example.ac_ma.userregistrationassessment;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class startRegistration extends Activity {

    public static String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_registration);
    }

    /** Called when the user taps the Start Button */
    public void createPassword(View view) {
        // Do something in response to button
        TextView editText = (TextView) findViewById(R.id.emailField);
        email = editText.getText().toString();
        Intent intent = new Intent(this, createPassword.class);
        startActivity(intent);

    }

    public static String getEmail() {
        return email;
    }
}