package com.example.parkingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PaySetUp extends AppCompatActivity {

    private TextView name;
    private TextView number;
    private TextView expire;
    private TextView csv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_set_up);

        name=(TextView) findViewById(R.id.editText3);
        number=(TextView) findViewById(R.id.editText4);
        expire=(TextView) findViewById(R.id.editText5);
        csv=(TextView) findViewById(R.id.editText10);

        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
            }
        });
        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number.setText("");
            }
        });
        expire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expire.setText("");
            }
        });
        csv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                csv.setText("");
            }
        });
    }
}
