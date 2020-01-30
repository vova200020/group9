package com.example.parkingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AccSetUp extends AppCompatActivity {

    private Button button;
    private TextView first;
    private TextView surname;
    private TextView add1;
    private TextView add2;
    private TextView town;
    private TextView post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acc_set_up);

        button = (Button) findViewById(R.id.confirm1);
        button.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick (View v){
                openPaySetUp();
            }
        });

        first=(TextView) findViewById(R.id.editText);
        surname=(TextView) findViewById(R.id.editText2);
        add1=(TextView) findViewById(R.id.editText7);
        add2=(TextView) findViewById(R.id.editText8);
        town=(TextView) findViewById(R.id.editText9);
        post=(TextView) findViewById(R.id.editText6);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                first.setText("");
            }
        });
        surname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                surname.setText("");
            }
        });
        add1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add1.setText("");
            }
        });
        add2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add2.setText("");
            }
        });
        town.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                town.setText("");
            }
        });
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                post.setText("");
            }
        });


    }
    public void openPaySetUp() {
        Intent intent = new Intent(this, PaySetUp.class);
        startActivity(intent);
    }
}

