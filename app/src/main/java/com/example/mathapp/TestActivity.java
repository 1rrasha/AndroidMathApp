package com.example.mathapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
//Rasha Mansour-1210773
public class TestActivity extends AppCompatActivity {

    TextView textViewTestDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        textViewTestDescription = findViewById(R.id.textViewTestDescription);
        GridLayout gridLayout = findViewById(R.id.gridLayout);

        for (int i = 1; i <= 10; i++) {
            Button button = new Button(this);
            button.setText(String.valueOf(i));
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = GridLayout.LayoutParams.WRAP_CONTENT;
            params.height = GridLayout.LayoutParams.WRAP_CONTENT;
            params.setMargins(10, 10, 10, 10);
            button.setLayoutParams(params);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int selectedNumber = Integer.parseInt(((Button) v).getText().toString());
                    Intent intent = new Intent(TestActivity.this, MultiplicationTestActivity.class);
                    intent.putExtra("selectedNumber", selectedNumber);
                    startActivity(intent);
                }
            });
            gridLayout.addView(button);
        }

    }
    }

