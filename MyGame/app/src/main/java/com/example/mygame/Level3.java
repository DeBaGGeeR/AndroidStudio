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


public class Level3 extends AppCompatActivity {
    private ArrayList<String> questions = new ArrayList<String>(
            Arrays.asList("Capital city of France?",
                    "Your Father's wife?",
                    "Person who sings ?"));
    private  String[]  syllables = {"pa","dir","ris","ther","rom","mo","her","sin","ger"};
    private  String[]  answers = {"paris","singer","paris"};
    private int randomNumber;
    private int index;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button submit3;
    private TextView textView7;
    private TextView textView8;
    private TextView textView9;
    private String text;
    private static int TIME_OUT;

    static {
        TIME_OUT = 4000;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);
        textView7 = (TextView) findViewById(R.id.textView7);
        index = randomNumber = randomize(0, 2);
        textView7.setText(questions.get(index));
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        submit3 = (Button) findViewById(R.id.submit3);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView9 = (TextView) findViewById(R.id.textView9);
        switch (randomNumber) {
            case 1:
                randomNumber += 2;
            case 2:
                randomNumber += 4;
        }
        button7.setText(syllables[randomNumber]);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = (String) textView8.getText();
                text += button7.getText();
                textView8.setText(text);
            }
        });
        button8.setText(syllables[randomNumber + 1]);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = (String) textView8.getText();
                text += button8.getText();
                textView8.setText(text);
            }
        });
        button9.setText(syllables[randomNumber + 2]);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = (String) textView8.getText();
                text += button9.getText();
                textView8.setText(text);
            }
        });


        submit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Arrays.asList(answers).contains(text)) {
                    textView9.setText("great");
                  /*  new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent i = new Intent( Level3.this, Level2.class);
                            startActivity(i);
                            finish();
                        }
                    }, TIME_OUT);*/
                } else {
                    textView9.setText("try it again");
                }             }

        });
    }
    public int randomize(int min, int max){
        return (new Random()).nextInt((max - min) + 1) + min;


    }
}
