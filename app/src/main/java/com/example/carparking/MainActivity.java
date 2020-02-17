package com.example.carparking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothA2dp;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText emailE;
    EditText passwordE;
    String email;
    String password;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         emailE = findViewById(R.id.Email);
         passwordE = findViewById(R.id.Password);
         firebaseAuth= FirebaseAuth.getInstance();
         FirebaseUser user =firebaseAuth.getCurrentUser();


         //goes to second activity if user is logged in
//         if (user !=null){
//             finish();
//             startActivity(new Intent(MainActivity.this,logged.class));
//         }

        }
        public void SignUp (View view){


         email= emailE.getText().toString().trim();
         password = passwordE.getText().toString().trim();

         if (email.matches("")||password.matches("")){
             Toast.makeText(MainActivity.this, " You have to enter your details", Toast.LENGTH_SHORT).show();
             return;
         }
         else{

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, " You have been sucesfully signed up", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,logged.class));
                }

                else  {
                    Toast.makeText(MainActivity.this, "Sign Up failed", Toast.LENGTH_SHORT).show();
                }
            }
        });}

        }
        public void LogIn (View view){

            email= emailE.getText().toString().trim();
            password = passwordE.getText().toString().trim();

            if (email.matches("")||password.matches("")){
                Toast.makeText(MainActivity.this, " You have to enter your details", Toast.LENGTH_SHORT).show();
                return;
            }

            else{
            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        FirebaseUser user = firebaseAuth.getCurrentUser();
                        Toast.makeText(MainActivity.this, " You have been sucesfully Loged in", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, logged.class));
                    } else if (task.isSuccessful()!=true){
                        Toast.makeText(MainActivity.this, " Log In failed", Toast.LENGTH_SHORT).show();
                    }

                }

            });}

            //firebaseAuth.signOut();
        }


    public void ForgotPassword (View view) {
        email= emailE.getText().toString().trim();
        firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(MainActivity.this, " Sent", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this, " You have to enter the email in the field above", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
    }









