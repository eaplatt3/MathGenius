package com.example.mathgenius;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MathGeniusAddition extends AppCompatActivity {

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
    Random randomNum;
    int num1;
    int num2;
    int answer;
    int result;
    String firstNum;
    String secondNum;
    String num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_genius_addition);
        ButterKnife.bind(this);

        randomNum = new Random();
        problemArea1 = new TextView(this);
        problemArea2 = new TextView(this);
        equalsLine = new TextView(this);
        correctDisplay = new TextView(this);

        problemArea1 = findViewById(R.id.problemArea1);
        problemArea2 = findViewById(R.id.problemArea2);
        equalsLine = findViewById(R.id.equalsLine);
        correctDisplay = findViewById(R.id.correctDisplay);

        num1 = randomNum.nextInt(100 - 1) + 1;
        num2 = randomNum.nextInt(100 - 1) + 1;

        answer = num1 + num2;

        firstNum = String.valueOf(num1);
        secondNum = String.valueOf(num2);

        Log.e("Number Test",  firstNum);

        if(num1 >= num2){
            problemArea1.setText("\u00A0" + "\u00A0" + firstNum);
            problemArea2.setText("+" + secondNum);
            equalsLine.setText("___");
        }

        if(num2 >= num1){
            problemArea1.setText("\u00A0" + "\u00A0" + secondNum);
            problemArea2.setText("+" + firstNum);
            equalsLine.setText("___");
        }




        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num = editText.getText().toString().trim();
                result = Integer.parseInt(num);

                if(result == answer){
                    correctDisplay.setText("Correct");
                    correctDisplay.setTextColor(Color.GREEN);
                }

                if(result != answer){
                    correctDisplay.setText("Incorrect");
                    correctDisplay.setTextColor(Color.RED);
                }
            }
        });






    }
}
