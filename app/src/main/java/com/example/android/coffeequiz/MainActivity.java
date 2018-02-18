package com.example.android.coffeequiz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean[] hasGoodAnswer = {false, false, false, false, false, false};
    String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * activated after pressing the check button
     *
     * @param view view
     */
    public void onCheckPress(View view) {

        //check all questions and ignore feedback
        checkAll();
        String message = getString(R.string.hello, name) + "\n";
        message = message + getString(R.string.good_answers, goodAnswers() + "");
        showMessage(message);
    }

    /**
     * Check all questions
     *
     * @return feedback to share
     */
    private String checkAll() {
        String feedback;
        String feedback1;
        String feedback2;
        String feedback3;
        String feedback4;
        String feedback5;

        feedback1 = checkFirstAnswer();
        feedback2 = checkSecondAnswer();
        feedback3 = checkThridAnswer();
        feedback4 = checkFourthAnswer();
        feedback5 = checkFifthAnswer();
        name = checkSixthAnswer();

        feedback = getString(R.string.hello, name) + "\n";
        feedback = feedback + feedback1;
        feedback = feedback + feedback2;
        feedback = feedback + feedback3;
        feedback = feedback + feedback4;
        feedback = feedback + feedback5;

        return feedback;
    }

    /**
     * activated after pressing the share button
     *
     * @param view view
     */
    public void onSharePress(View view) {
        String feedback = checkAll();
        shareMessage(feedback);
    }

    /**
     * Show message as toast
     *
     * @param message message
     */
    public void showMessage(String message) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }

    /**
     * Run intent to post message
     *
     * @param message message to display
     */
    public void shareMessage(String message) {
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setData(Uri.parse("mailto:"));
        sendIntent.setType("text/plain");
        sendIntent.putExtra(Intent.EXTRA_TEXT, message);
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name));

        // Verify that the intent will resolve to an activity
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendIntent);
        }
    }

    /**
     * Counts good answers
     *
     * @return good answers
     */
    private int goodAnswers() {
        int counter = 0;
        if (hasGoodAnswer[0]) counter++;
        if (hasGoodAnswer[1]) counter++;
        if (hasGoodAnswer[2]) counter++;
        if (hasGoodAnswer[3]) counter++;
        if (hasGoodAnswer[4]) counter++;
        return counter;
    }

    /**
     * check first answer and set value in hasGoodAnswer
     *
     * @return descriptive rating
     */
    private String checkFirstAnswer() {
        RadioButton radio = findViewById(R.id.q1a1);
        if (radio.isChecked()) {
            hasGoodAnswer[0] = true;
            return (getString(R.string.question_1_nr) + getString(R.string.good_answer) + "\n");
        } else {
            hasGoodAnswer[0] = false;
            return (getString(R.string.question_1_answer) + "\n");
        }
    }

    /**
     * check first answer and set value in hasGoodAnswer
     *
     * @return descriptive rating
     */
    private String checkSecondAnswer() {
        CheckBox checkBox1 = findViewById(R.id.q2a1);
        CheckBox checkBox2 = findViewById(R.id.q2a2);
        CheckBox checkBox3 = findViewById(R.id.q2a3);
        if (checkBox1.isChecked() & checkBox2.isChecked() & !checkBox3.isChecked()) {
            hasGoodAnswer[1] = true;
            return (getString(R.string.question_2_nr) + getString(R.string.good_answer) + "\n");
        } else {
            hasGoodAnswer[1] = false;
            return (getString(R.string.question_2_answer) + "\n");
        }
    }

    /**
     * check first answer and set value in hasGoodAnswer
     *
     * @return descriptive rating
     */
    private String checkThridAnswer() {
        RadioButton radio = findViewById(R.id.q3a1);
        if (radio.isChecked()) {
            hasGoodAnswer[2] = true;
            return (getString(R.string.question_3_nr) + getString(R.string.good_answer) + "\n");
        } else {
            hasGoodAnswer[2] = false;
            return (getString(R.string.question_3_answer) + "\n");
        }
    }

    /**
     * check first answer and set value in hasGoodAnswer
     *
     * @return descriptive rating
     */
    private String checkFourthAnswer() {
        RadioButton radio = findViewById(R.id.q4a1);
        if (radio.isChecked()) {
            hasGoodAnswer[3] = true;
            return (getString(R.string.question_4_nr) + getString(R.string.good_answer) + "\n");
        } else {
            hasGoodAnswer[3] = false;
            return (getString(R.string.question_4_answer) + "\n");
        }
    }

    /**
     * check first answer and set value in hasGoodAnswer
     *
     * @return descriptive rating
     */
    private String checkFifthAnswer() {
        EditText editText = findViewById(R.id.year);
        String yearString = editText.getText().toString();
        if (yearString.equals("1884")) {
            hasGoodAnswer[4] = true;
            return (getString(R.string.question_5_nr) + getString(R.string.good_answer) + "\n");
        } else {
            hasGoodAnswer[4] = false;
            return (getString(R.string.question_5_answer) + "\n");
        }
    }

    /**
     * check first answer and set value in hasGoodAnswer[2]
     *
     * @return descriptive rating
     */
    private String checkSixthAnswer() {
        EditText editText = findViewById(R.id.name);
        return editText.getText().toString();
    }
}
