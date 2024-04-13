package com.example.mathapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//Rasha Mansour-1210773
public class SubtractionTestActivity extends AppCompatActivity {

    TextView textViewQuestion;
    RadioGroup radioGroupOptions;
    Button buttonSubmit;

    int totalQuestions = 10; // Total number of questions in the test
    List<Question> questions; // List to store the questions
    int questionCount = 0; // Keep track of the current question number
    int score = 0;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtraction_test);

        textViewQuestion = findViewById(R.id.textViewQuestion);
        radioGroupOptions = findViewById(R.id.radioGroupOptions);
        buttonSubmit = findViewById(R.id.buttonSubmit);

        sharedPreferences = getSharedPreferences("scores", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        // Initialize questions
        questions = generateQuestions();

        displayQuestion(); // Display the first question

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedOptionId = radioGroupOptions.getCheckedRadioButtonId();
                if (selectedOptionId != -1) {
                    RadioButton selectedRadioButton = findViewById(selectedOptionId);
                    String selectedOption = selectedRadioButton.getText().toString();
                    Question currentQuestion = questions.get(questionCount);
                    if (currentQuestion.getCorrectAnswer().equals(selectedOption)) {
                        score++;
                        Toast.makeText(SubtractionTestActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SubtractionTestActivity.this, "Incorrect!", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(SubtractionTestActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Method to generate subtraction questions
    private List<Question> generateQuestions() {
        List<Question> questions = new ArrayList<>();
        // Generate 10 random subtraction questions
        for (int i = 0; i < totalQuestions; i++) {
            int num1 = (int) (Math.random() * 100);
            int num2 = (int) (Math.random() * 100);
            int correctAnswer = num1 - num2;
            List<String> options = generateOptions(correctAnswer);
            Question question = new Question("Question " + (i + 1) + ": " + num1 + " - " + num2 + " = ?", options, String.valueOf(correctAnswer));
            questions.add(question);
        }
        return questions;
    }

    // Method to generate options for the multiple-choice question
    private List<String> generateOptions(int correctAnswer) {
        List<String> options = new ArrayList<>();
        options.add(String.valueOf(correctAnswer));
        // Generate three incorrect options
        while (options.size() < 4) {
            int incorrectAnswer = correctAnswer + (int) (Math.random() * 20) - 10; // Generate numbers close to the correct answer
            if (incorrectAnswer != correctAnswer) {
                options.add(String.valueOf(incorrectAnswer));
            }
        }
        Collections.shuffle(options);
        return options;
    }

    // Method to display the next question
    private void displayQuestion() {
        Question currentQuestion = questions.get(questionCount);
        textViewQuestion.setText(currentQuestion.getQuestion());
        radioGroupOptions.removeAllViews();
        for (String option : currentQuestion.getOptions()) {
            RadioButton radioButton = new RadioButton(this);
            radioButton.setText(option);
            radioGroupOptions.addView(radioButton);
        }
    }

    // Method to save the score
    private void saveScore(int score) {
        int currentScore = sharedPreferences.getInt("score", 0);
        editor.putInt("score", currentScore + score);
        editor.apply();
    }

    // Method to show the final score and navigate back to the previous activity
    private void showFinalScore() {
        Toast.makeText(SubtractionTestActivity.this, "Final Score: " + score, Toast.LENGTH_SHORT).show();
        // Reset question count and score for the next test
        questionCount = 0;
        score = 0;

        // Create an intent to navigate back to the previous activity
        Intent intent = new Intent(SubtractionTestActivity.this, WelcomeActivity.class);
        startActivity(intent);
        finish(); // Finish the current activity
    }

}
