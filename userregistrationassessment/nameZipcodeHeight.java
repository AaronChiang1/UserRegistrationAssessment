package com.example.ac_ma.userregistrationassessment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class nameZipcodeHeight extends AppCompatActivity {

    public static String name;
    public static String zipcode;
    public static String height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_zipcode_height);
    }

    public void genderDOB(View view) {
        TextView editText = (TextView) findViewById(R.id.name);
        name = editText.getText().toString();
        editText = (TextView) findViewById(R.id.zipcode);
        zipcode = editText.getText().toString();
        editText = (TextView) findViewById(R.id.height);
        height = editText.getText().toString();
        Intent intent = new Intent(this, genderDOB.class);
        startActivity(intent);
    }

    public static String getName() {
        return name;
    }

    public static String getZipcode() {
        return zipcode;
    }

    public static String getHeight() {
        return height;
    }
}
