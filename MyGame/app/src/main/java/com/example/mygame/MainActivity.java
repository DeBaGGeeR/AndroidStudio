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

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> questions = new ArrayList<String>(
            Arrays.asList("What is it?",
                    "What do you see?",
                    "What this object is?"));
    String url ="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSs2xxR4_8e8p3WnlUcV-asBmXQn3nvs8kwbIb7XJw402x7zhwBfw";
    private  String[]  syllables = {"ba","nanana","nana"};
    private  String[]  answers = {"banana"};
    private int randomNumber;
    private int index;
    private Button button;
    private Button button2;
    private Button button3;
    private Button submit;
    private Button reset;
    private TextView textView;
    private TextView textView2;
    private TextView textView3;
    private String text;
    ImageView imageView;

    private static int TIME_OUT;

    static {
        TIME_OUT = 2000;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView) findViewById(R.id.imageView);
        loadImageFromUrl(url);
        textView = (TextView) findViewById(R.id.textView);
       // index = randomNumber = randomize(0, 2);
        textView.setText(questions.get(index));
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        submit = (Button) findViewById(R.id.submit);
        reset = (Button) findViewById(R.id.reset);
        reset.setText("Clear");
        submit.setText("OK");
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setText("");
 /*       switch (randomNumber) {
            case 1:
                randomNumber += 2;
            case 2:
                randomNumber += 4;
        }*/
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
                        textView3.setText("     Perfect!!!");
                  new Handler().postDelayed(new Runnable() {
                      @Override
                      public void run() {
                          Intent i = new Intent(MainActivity.this, Level2.class);
                          startActivity(i);
                          finish();
                      }
                  }, TIME_OUT);
        } else {
                        textView3.setText("  Something is\n  wrong!\n  Try it again");
                    }
            }

        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.setText("");
            }
        });
    }


    private void loadImageFromUrl(String url) {
        Picasso.with(this).load(url).placeholder(R.mipmap.ic_launcher).
                error(R.mipmap.ic_launcher).into(imageView,new com.squareup.picasso.Callback(){


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
