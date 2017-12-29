package com.example.android.coffeequiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean[] hasGoodAnswer = {false, false, false, false, false, false};

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
        //odpowiedziałeś poprawnie na x pytań
        //źle odpowiedziałeś na pytania nr
        String feedback;
        String feedback1, feedback2, feedback3, feedback4, feedback5, feedback6;

        feedback1 = checkFirstAnswer();
        feedback2 = checkSecondAnswer();
        feedback3 = checkThridAnswer();
        feedback4 = checkFourthAnswer();
        feedback5 = checkFifthAnswer();
        feedback6 = checkSixthAnswer();

        feedback = feedback1;
        feedback = feedback + feedback2;
        feedback = feedback + feedback3;
//        feedback = feedback + feedback4;
//        feedback = feedback + feedback5;
//        feedback = feedback + feedback6;

        showMessage(goodAnswers() + "\n" + feedback);
    }

    /**
     * activated after pressing the share button
     *
     * @param view view
     */
    public void onSharePress(View view) {
        shareMessage(getString(R.string.question_placeholder));
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
        //sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        sendIntent.putExtra(Intent.EXTRA_TEXT, message);

        // Verify that the intent will resolve to an activity
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendIntent);
        }
    }

    private int goodAnswers() {
        int counter = 0;
        if (hasGoodAnswer[0]) counter++;
        if (hasGoodAnswer[1]) counter++;
        if (hasGoodAnswer[2]) counter++;
        if (hasGoodAnswer[3]) counter++;
        if (hasGoodAnswer[4]) counter++;
        if (hasGoodAnswer[5]) counter++;
        return counter;
    }

    /**
     * check first answer and set value in hasGoodAnswer
     *
     * @return descriptive rating
     */
    private String checkFirstAnswer() {
        hasGoodAnswer[0] = false;
        RadioButton radio = findViewById(R.id.q1a1);
        if (radio.isChecked()) {
            hasGoodAnswer[0] = true;
            return "";
        }
        return (getString(R.string.question_1_answer) + "\n");
    }

    /**
     * check first answer and set value in hasGoodAnswer
     *
     * @return descriptive rating
     */
    private String checkSecondAnswer() {
        hasGoodAnswer[1] = false;
        CheckBox checkBox1 = findViewById(R.id.q2a1);
        CheckBox checkBox2 = findViewById(R.id.q2a2);
        CheckBox checkBox3 = findViewById(R.id.q2a3);
        if (checkBox1.isChecked() & checkBox2.isChecked() & !checkBox3.isChecked()) {
            hasGoodAnswer[1] = true;
            return "";
        }

        return (getString(R.string.question_2_answer)+"\n");
    }

    /**
     * check first answer and set value in hasGoodAnswer
     *
     * @return descriptive rating
     */
    private String checkThridAnswer() {
        hasGoodAnswer[2] = false;
        RadioButton radio = findViewById(R.id.q3a1);
        if (radio.isChecked()) {
            hasGoodAnswer[2] = true;
            return "";
        }
        return (getString(R.string.question_3_answer) + "\n");
    }

    /**
     * check first answer and set value in hasGoodAnswer
     *
     * @return descriptive rating
     */
    private String checkFourthAnswer() {
        hasGoodAnswer[3] = false;
        return getString(R.string.question_placeholder);
    }

    /**
     * check first answer and set value in hasGoodAnswer
     *
     * @return descriptive rating
     */
    private String checkFifthAnswer() {
        hasGoodAnswer[4] = false;
        return getString(R.string.question_placeholder);
    }

    /**
     * check first answer and set value in hasGoodAnswer[2]
     *
     * @return descriptive rating
     */
    private String checkSixthAnswer() {
        hasGoodAnswer[5] = false;
        return getString(R.string.question_placeholder);
    }
}
