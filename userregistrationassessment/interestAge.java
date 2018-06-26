package com.example.ac_ma.userregistrationassessment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class interestAge extends AppCompatActivity {

    public static int interest;
    public static String minAge, maxAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest_age);
    }

    public void raceReligion(View view) {
        RadioGroup radiogroup = findViewById(R.id.interested);
        interest = radiogroup.getCheckedRadioButtonId();
        TextView editText = (TextView) findViewById(R.id.minAge);
        minAge = editText.getText().toString();
        editText = (TextView) findViewById(R.id.maxAge);
        maxAge = editText.getText().toString();
        Intent intent = new Intent(this, raceReligion.class);
        startActivity(intent);
    }

    public static String getInterest() {
        if (interest == 0)
            return "Male";
        else if (interest == 1)
            return "Female";
        else
            return "Both";
    }

    public static String getMinAge() {
        return minAge;
    }

    public static String getMaxAge() {
        return maxAge;
    }
}
