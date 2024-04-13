package com.example.mathapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
//Rasha Mansour-1210773
public class WelcomeActivity extends AppCompatActivity {

    Button buttonMultiply, buttonAdd, buttonSubtract;
    TextView textViewWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Retrieve first and last name from the previous activity
        String firstName = getIntent().getStringExtra("firstName");
        String lastName = getIntent().getStringExtra("lastName");

        textViewWelcome = findViewById(R.id.textViewWelcome);
        textViewWelcome.setText("Hi " + firstName + " " + lastName);
        // Set the welcome message in big, bold, and chunky font

        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSubtract = findViewById(R.id.buttonSubtract);

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, MultiplicationOperationActivity.class);
                startActivity(intent);
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, AdditionTestActivity.class);
                startActivity(intent);
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WelcomeActivity.this, SubtractionTestActivity.class);
                startActivity(intent);
            }
        });
    }
}
