package com.example.ac_ma.userregistrationassessment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class genderDOB extends AppCompatActivity {

    public static int gender;
    public static String dob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender_dob);
    }

    public void interestAge(View view) {
        RadioGroup radiogroup = findViewById(R.id.test);
        gender = radiogroup.getCheckedRadioButtonId();
        TextView editText = (TextView) findViewById(R.id.dob);
        dob = editText.getText().toString();
        Intent intent = new Intent(this, interestAge.class);
        startActivity(intent);
    }

    public static String getGender() {
        if (gender == 0)
            return "Male";
        else
            return "Female";
    }

    public static String getDob() {
        return dob;
    }
}
