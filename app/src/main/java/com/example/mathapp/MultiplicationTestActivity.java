package com.example.mathapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//Rasha Mansour-1210773
public class MultiplicationTestActivity extends AppCompatActivity {

    TextView textViewQuestion;
    EditText editTextAnswer;
    Button buttonSubmit;

    int selectedNumber;
    int totalQuestions = 10; // Total number of questions in the test
    List<Integer> questionOrder; // List to store the order of questions
    int questionCount = 0; // Keep track of the current question number
    int score = 0;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplication_test);

        textViewQuestion = findViewById(R.id.textViewQuestion);
        editTextAnswer = findViewById(R.id.editTextAnswer);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        sharedPreferences = getSharedPreferences("scores", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        // Retrieve selected number from intent
        selectedNumber = getIntent().getIntExtra("selectedNumber", 1);

        // Initialize question order and shuffle it
        questionOrder = new ArrayList<>();
        for (int i = 0; i < totalQuestions; i++) {
            questionOrder.add(i);
        }
        Collections.shuffle(questionOrder);

        displayQuestion(); // Display the first question

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userAnswer = editTextAnswer.getText().toString().trim();
                if (!userAnswer.isEmpty()) {
                    int answer = Integer.parseInt(userAnswer);
                    int correctAnswer = selectedNumber * (questionOrder.get(questionCount) + 1);
                    if (answer == correctAnswer) {
                        score++;
                        Toast.makeText(MultiplicationTestActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MultiplicationTestActivity.this, "Incorrect!", Toast.LENGTH_SHORT).show();
                    }
                    // Proceed to the next question or finish the test
                    questionCount++;
                    if (questionCount < totalQuestions) {
                        displayQuestion();
                    } else {
                        // Finish the test and show the score
                        saveScore(score);
                        showFinalScore();
                    }
                } else {
                    Toast.makeText(MultiplicationTestActivity.this, "Please enter an answer", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Method to display the next question
    private void displayQuestion() {
        // Get the index of the next question from the shuffled order
        int nextQuestionIndex = questionOrder.get(questionCount);
        // Set the question text
        textViewQuestion.setText("Question " + (questionCount + 1) + ": What is " + selectedNumber + " x " + (nextQuestionIndex + 1) + "?");
        editTextAnswer.setText(""); // Clear the previous answer
    }

    // Method to save the score
    private void saveScore(int score) {
        int currentScore = sharedPreferences.getInt("score", 0);
        editor.putInt("score", currentScore + score);
        editor.apply();
    }

    // Method to show the final score
    private void showFinalScore() {
        Toast.makeText(MultiplicationTestActivity.this, "Final Score: " + score, Toast.LENGTH_SHORT).show();
        // Reset question count and score for the next test
        questionCount = 0;
        score = 0;

        // Create an intent to navigate back to the previous activity
        Intent intent = new Intent(MultiplicationTestActivity.this, MultiplicationOperationActivity.class);
        startActivity(intent);
        finish(); // Finish the current activity
    }

}
