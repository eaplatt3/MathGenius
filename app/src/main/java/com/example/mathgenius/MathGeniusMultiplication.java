package com.example.mathgenius;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MathGeniusMultiplication extends AppCompatActivity {
    @BindView(R.id.submitBtn)
    Button submitBtn;
    @BindView(R.id.returnBtn)
    Button returnBtn;
    @BindView(R.id.exitBtn)
    Button exitBtn;
    @BindView(R.id.editText)
    EditText editText;

    TextView problemArea1;
    TextView problemArea2;
    TextView equalsLine;
    TextView correctDisplay;
    TextView trysDisplay;
    Random randomNum;
    int num1;
    int num2;
    int answer;
    int result;
    int ctn = 3;
    String firstNum;
    String secondNum;
    String num;
    Intent startNewActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_genius_multiplication);
        ButterKnife.bind(this);

        randomNum = new Random();
        problemArea1 = new TextView(this);
        problemArea2 = new TextView(this);
        equalsLine = new TextView(this);
        correctDisplay = new TextView(this);
        trysDisplay = new TextView(this);


        problemArea1 = findViewById(R.id.problemArea1);
        problemArea2 = findViewById(R.id.problemArea2);
        equalsLine = findViewById(R.id.equalsLine);
        correctDisplay = findViewById(R.id.correctDisplay);
        trysDisplay = findViewById(R.id.trysDisplay);

        //Assigning Random Numbers From 1 - 100
        num1 = randomNum.nextInt(100 - 1) + 1;
        num2 = randomNum.nextInt(20 - 1) + 1;

        answer = num1 * num2;

        firstNum = String.valueOf(num1);
        secondNum = String.valueOf(num2);

        //Sorts Numbers To Display Biggest on Top
        if(num1 >= num2){
            problemArea1.setText("\u00A0" + "\u00A0" + firstNum);
            problemArea2.setText("x" + "\t\t\t\t\t\t" + secondNum);
            equalsLine.setText("___");
        }

        if(num2 >= num1){
            problemArea1.setText("\u00A0" + "\u00A0" + secondNum);
            problemArea2.setText("x" + firstNum);
            equalsLine.setText("___");
        }

        //Submit Button Function
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = editText.getText().toString().trim();
                result = Integer.parseInt(num);

                startNewActivity = new Intent(v.getContext(), MathGeniusMultiplication.class);

                //Checks For Correct Answer
                if(result == answer && ctn != 0){
                    correctDisplay.setText("Correct");
                    correctDisplay.setTextColor(Color.GREEN);
                    correctDisplay.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);

                    //Holds the Page for 2 secs & Restarts Page
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(startNewActivity);
                        }
                    }, 2000);

                }

                if(result != answer && ctn != 0){
                    correctDisplay.setText("Incorrect");
                    correctDisplay.setTextColor(Color.RED);
                    correctDisplay.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
                    ctn--;
                    trysDisplay.setText("\tTrys Left" + "\n" + "\t\t\t\t" + ctn);
                    trysDisplay.setTextColor(Color.BLACK);

                }

                if(result != answer && ctn == 0){
                    correctDisplay.setText("Incorrect Answer is: " + answer);
                    correctDisplay.setTextColor(Color.RED);
                    correctDisplay.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
                    ctn = 0;

                    //Holds the Page for 4 secs & Restarts Page
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(startNewActivity);
                        }
                    }, 4000);
                }
            }
        });

        //Function Returns to Selection Page
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startNewActivity = new Intent(v.getContext(), MathGeniusMathSelection.class);
                startActivity(startNewActivity);
            }
        });

        //Function Exits App
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startNewActivity = new Intent(v.getContext(), MainActivity.class);
                startActivity(startNewActivity);
                finish();
            }
        });

    }
}
