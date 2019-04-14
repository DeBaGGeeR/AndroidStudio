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

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> questions = new ArrayList<String>(
            Arrays.asList("Capital city of France?",
                    "Your Father's wife?",
                    "Person who sings ?"));
    private  String[]  syllables = {"pa","dir","ris","ther","rom","mo","her","sin","ger"};
    private  String[]  answers = {"paris","singer","paris"};
    private int randomNumber;
    private int index;
    private Button button;
    private Button button2;
    private Button button3;
    private Button submit;
    private TextView textView;
    private TextView textView2;
    private TextView textView3;
    private String text;
    private static int TIME_OUT;

    static {
        TIME_OUT = 4000;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        index = randomNumber = randomize(0, 2);
        textView.setText(questions.get(index));
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button8);
        button3 = (Button) findViewById(R.id.button3);
        submit = (Button) findViewById(R.id.submit);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        switch (randomNumber) {
            case 1:
                randomNumber += 2;
            case 2:
                randomNumber += 4;
        }
        button.setText(syllables[randomNumber]);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = (String) textView2.getText();
                text += button.getText();
                textView2.setText(text);
            }
        });
        button2.setText(syllables[randomNumber + 1]);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = (String) textView2.getText();
                text += button2.getText();
                textView2.setText(text);
            }
        });
        button3.setText(syllables[randomNumber + 2]);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = (String) textView2.getText();
                text += button3.getText();
                textView2.setText(text);
            }
        });


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              if (Arrays.asList(answers).contains(text)) {
                        textView3.setText("great");
                  new Handler().postDelayed(new Runnable() {
                      @Override
                      public void run() {
                          Intent i = new Intent(MainActivity.this, Level2.class);
                          startActivity(i);
                          finish();
                      }
                  }, TIME_OUT);
        } else {
                        textView3.setText("try it again");
                    }             }

        });
    }
    public int randomize(int min, int max){
        return (new Random()).nextInt((max - min) + 1) + min;

    }

}
