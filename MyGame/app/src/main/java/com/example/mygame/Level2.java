
package com.example.mygame;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Level2 extends AppCompatActivity {
    private ArrayList<String> questions = new ArrayList<String>(
            Arrays.asList("What is it?",
                    "What do you see?",
                    "What this object is?"));
    String url ="http://www.stickpng.com/assets/images/580b585b2edbce24c47b2cf5.png";
    private  String[]  syllables = {"cop","ther","heli","ter","cpop"};
    private  String[]  answers = {"helicopter"};
    private int randomNumber1;
    private int index1;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button17;
    private Button button18;
    private Button reset2;
    private Button submit2;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private String text1;
    ImageView imageView2;
    private static int TIME_OUT;

    static {
        TIME_OUT = 2000;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level2);

        imageView2=(ImageView) findViewById(R.id.imageView2);
        loadImageFromUrl(url);

        textView4 = (TextView) findViewById(R.id.textView4);
        index1 = randomNumber1 = randomize(0, 2);
        textView4.setText(questions.get(index1));
        button4 = (Button) findViewById(R.id.button4);
        button5 =(Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button17 = (Button) findViewById(R.id.button17);
        button18 = (Button) findViewById(R.id.button18);
        reset2 = (Button) findViewById(R.id.reset2);
        submit2 = (Button) findViewById(R.id.submit2);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        switch (randomNumber1) {
            case 1:
                randomNumber1 += 2;
            case 2:
                randomNumber1 += 4;
        }
        button4.setText(syllables[randomNumber1]);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1 = (String) textView5.getText();
                text1 += button4.getText();
                textView5.setText(text1);
            }
        });
        button5.setText(syllables[randomNumber1 + 1]);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1 = (String) textView5.getText();
                text1 += button5.getText();
                textView5.setText(text1);
            }
        });
        button6.setText(syllables[randomNumber1 + 2]);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1 = (String) textView5.getText();
                text1 += button6.getText();
                textView5.setText(text1);
            }
        });

        button17.setText(syllables[randomNumber1 + 3]);
        button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1 = (String) textView5.getText();
                text1 += button17.getText();
                textView5.setText(text1);
            }
        });

        button18.setText(syllables[randomNumber1 + 4]);
        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1 = (String) textView5.getText();
                text1 += button18.getText();
                textView5.setText(text1);
            }
        });
        reset2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView5.setText("");
            }
        });
        submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Arrays.asList(answers).contains(text1)) {
                    textView6.setText("Wonderful!!!");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent i = new Intent( Level2.this, Level3.class);
                            startActivity(i);
                            finish();
                        }
                    }, TIME_OUT);
                } else {
                    textView6.setText("Incorrect!\nTry again");
                }             }

        });
    }

    private void loadImageFromUrl(String url) {
        Picasso.with(this).load(url).placeholder(R.mipmap.ic_launcher).
                error(R.mipmap.ic_launcher).into(imageView2,new com.squareup.picasso.Callback(){


            @Override
            public void onSuccess() {

            }

            @Override
            public void onError() {

            }
        });
    }

    public int randomize(int min, int max){
        return (new Random()).nextInt((max - min) + 1) + min;

    }

}
