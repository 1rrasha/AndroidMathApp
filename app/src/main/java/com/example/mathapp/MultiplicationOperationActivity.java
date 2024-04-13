package com.example.mathapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
//Rasha Mansour-1210773
public class MultiplicationOperationActivity extends AppCompatActivity {

    Button buttonTestYourself;
    Button buttonTable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplication_operation);

         buttonTestYourself = findViewById(R.id.buttonTestYourself);
        buttonTestYourself.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MultiplicationOperationActivity.this, TestActivity.class);
                startActivity(intent);
            }
        });

         buttonTable = findViewById(R.id.buttonTable);
        buttonTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MultiplicationOperationActivity.this, MultiplicationTableActivity.class);
                startActivity(intent);
            }
        });

    }
}
