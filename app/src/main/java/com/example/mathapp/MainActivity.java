package com.example.mathapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
//Rasha Mansour-1210773
public class MainActivity extends AppCompatActivity {

    EditText editTextFirstName, editTextLastName;
    CheckBox checkBoxThirdGrade;
    Button buttonGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextFirstName = findViewById(R.id.editTextFirstName);
        editTextLastName = findViewById(R.id.editTextLastName);
        checkBoxThirdGrade = findViewById(R.id.checkBoxThirdGrade);
        buttonGo = findViewById(R.id.buttonGo);

        buttonGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = editTextFirstName.getText().toString().trim();
                String lastName = editTextLastName.getText().toString().trim();
                boolean thirdGrade = checkBoxThirdGrade.isChecked();

                if (firstName.isEmpty() && lastName.isEmpty() && !thirdGrade) {
                    Toast.makeText(MainActivity.this, "Please enter your name or check the third grade option", Toast.LENGTH_SHORT).show();
                } else {
                    // Pass first name, last name, and third grade status to WelcomeActivity
                    Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                    intent.putExtra("firstName", firstName);
                    intent.putExtra("lastName", lastName);
                    intent.putExtra("thirdGrade", thirdGrade);
                    startActivity(intent);
                }
            }
        });

    }
}
