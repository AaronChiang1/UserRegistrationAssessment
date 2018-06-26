package com.example.ac_ma.userregistrationassessment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class createPassword extends AppCompatActivity {

    public static String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);

    }

    public void nameZipcodeHeight (View view) {
        TextView editText = (TextView) findViewById(R.id.passwordField);
        password = editText.getText().toString();
        Intent intent = new Intent(this, nameZipcodeHeight.class);
        startActivity(intent);
    }

    public static String getPassword() {
        return password;
    }
}
