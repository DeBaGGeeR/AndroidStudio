package com.example.mygame;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Level2 extends AppCompatActivity {
    private ArrayList<String> questions = new ArrayList<String>(
            Arrays.asList("Capital city of France?",
                    "Your Father's wife?",
                    "Person who sings ?"));
    private  String[]  syllables = {"pa","dir","ris","ther","rom","mo","her","sin","ger"};
    private  String[]  answers = {"paris","singer","paris"};
    private int randomNumber;
    private int index;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button submit2;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private String text;
    private static int TIME_OUT;

    static {
        TIME_OUT = 4000;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);
        textView4 = (TextView) findViewById(R.id.textView4);
        index = randomNumber = randomize(0, 2);
        textView4.setText(questions.get(index));
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        submit2 = (Button) findViewById(R.id.submit2);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        switch (randomNumber) {
            case 1:
                randomNumber += 2;
            case 2:
                randomNumber += 4;
        }
        button4.setText(syllables[randomNumber]);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = (String) textView5.getText();
                text += button4.getText();
                textView5.setText(text);
            }
        });
        button5.setText(syllables[randomNumber + 1]);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = (String) textView5.getText();
                text += button5.getText();
                textView5.setText(text);
            }
        });
        button6.setText(syllables[randomNumber + 2]);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = (String) textView5.getText();
                text += button6.getText();
                textView5.setText(text);
            }
        });


        submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Arrays.asList(answers).contains(text)) {
                    textView6.setText("great");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent i = new Intent( Level2.this, Final.class);
                            startActivity(i);
                            finish();
                        }
                    }, TIME_OUT);
                } else {
                    textView6.setText("try it again");
                }             }

        });
    }
    public int randomize(int min, int max){
        return (new Random()).nextInt((max - min) + 1) + min;


    }
}
