package com.example.carparking;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignWithPhone extends AppCompatActivity {

    EditText Phone;
    String phoneNumber;
    Button button1;
    Button Send;
    EditText Code;
    TextView Codeview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_with_phone);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Logging with phone number ");
        Phone= findViewById(R.id.Phonetextedit);
        phoneNumber=Phone.getText().toString();

    }

    public void SignInPhone (View view) {
        phoneNumber=Phone.getText().toString();
    if (phoneNumber.matches("")) {
        Toast.makeText(SignWithPhone.this, " You have to enter your Phone", Toast.LENGTH_SHORT).show();
    }
    else{
        button1 = findViewById(R.id.button);
        button1.setVisibility(View.INVISIBLE);
        Send= findViewById(R.id.button2);
        Send.setVisibility(View.VISIBLE);
        Codeview= findViewById(R.id.Text);
        Codeview.setVisibility(View.VISIBLE);
        Code = findViewById(R.id.code);
        Code.setVisibility(View.VISIBLE);
    }
    }
    public void Verify (View view) {
        Toast.makeText(SignWithPhone.this, " Logged in ", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(SignWithPhone.this,logged.class));
    }
}
