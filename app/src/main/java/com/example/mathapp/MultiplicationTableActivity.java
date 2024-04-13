package com.example.mathapp;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
//Rasha Mansour-1210773
public class MultiplicationTableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplication_table);

        TableLayout tableLayout = findViewById(R.id.tableLayout);

        // Create multiplication table rows and columns
        for (int i = 1; i <= 10; i++) {
            TableRow tableRow = new TableRow(this);
            for (int j = 1; j <= 10; j++) {
                TextView textView = new TextView(this);
                textView.setText(String.valueOf(i * j));
                textView.setPadding(16, 16, 16, 16);

                // Set text color to black for the cells
                textView.setTextColor(Color.BLACK);

                // Set text style to bold for the first row and first column
                if (i == 1 || j == 1) {
                    textView.setTypeface(null, Typeface.BOLD);
                }

                // Set background color for the boxes
                if (i == 1 && j == 1) {
                    textView.setBackgroundColor(Color.LTGRAY);
                } else if (i == 1 || j == 1) {
                    textView.setBackgroundColor(Color.LTGRAY);
                }

                textView.setGravity(Gravity.CENTER);

                // Add TextView to TableRow
                tableRow.addView(textView);
            }
            tableLayout.addView(tableRow);
        }
    }
}

//import android.graphics.Color;
//        import android.graphics.Typeface;
//        import android.os.Bundle;
//        import android.widget.TableLayout;
//        import android.widget.TableRow;
//        import android.widget.TextView;
//
//        import androidx.appcompat.app.AppCompatActivity;
//
//public class MultiplicationTableActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_multiplication_table);
//
//        TableLayout tableLayout = findViewById(R.id.tableLayout);
//
//        // Create multiplication table rows and columns
//        for (int i = 1; i <= 10; i++) {
//            TableRow tableRow = new TableRow(this);
//            for (int j = 1; j <= 10; j++) {
//                TextView textView = new TextView(this);
//                textView.setText(String.valueOf(i * j));
//                textView.setPadding(16, 16, 16, 16);
//
//                // Set text color to red for the first row and first column
//                if (i == 1 || j == 1) {
//                    textView.setTextColor(Color.YELLOW);
//                } else {
//                    textView.setTextColor(Color.GREEN);
//                }
//
//                // Set text style to bold for the first row and first column
//                if (i == 1 || j == 1) {
//                    textView.setTypeface(null, Typeface.BOLD);
//                }
//
//                tableRow.addView(textView);
//            }
//            tableLayout.addView(tableRow);
//        }
//    }
//}

