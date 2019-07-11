package com.example.mathgenius;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;



public class MathGeniusMathSelection extends AppCompatActivity {

    //XMl File Objects
    @BindView(R.id.addButton)
    Button addBtn;
    @BindView(R.id.subButton)
    Button subBtn;
    @BindView(R.id.multiButton)
    Button multiBtn;
    @BindView(R.id.divideButton)
    Button divideBtn;
    @BindView(R.id.exitButton)
    Button exitBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_genius_math_selection);
        ButterKnife.bind(this);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startNewActivity = new Intent(v.getContext(), MathGeniusAddition.class);
                startActivity(startNewActivity);
            }
        });

        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startNewActivity = new Intent(v.getContext(), MathGeniusSubtraction.class);
                startActivity(startNewActivity);
            }
        });

        multiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startNewActivity = new Intent(v.getContext(), MathGeniusMultiplication.class);
                startActivity(startNewActivity);
            }
        });

        divideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startNewActivity = new Intent(v.getContext(), MathGeniusDivision.class);
                startActivity(startNewActivity);
            }
        });

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
