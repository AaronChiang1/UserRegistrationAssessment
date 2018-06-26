package com.example.ac_ma.userregistrationassessment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }

    /**
     * Called when the user taps the Start Button
     */
    public void startRegistration(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, startRegistration.class);
        startActivity(intent);

    }
}