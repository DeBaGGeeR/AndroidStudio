
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


public class Level3 extends AppCompatActivity {
    private ArrayList<String> questions = new ArrayList<String>(
            Arrays.asList("What is it?",
                    "What do you see?",
                    "What this object is?"));
    String url ="https://vignette.wikia.nocookie.net/penguinsofmadagascar/images/a/a2/Gloria_001.png";
    private  String[]  syllables = {"pot","pat","hip","mus","po","mo","a"};
    private  String[]  answers = {"hippopotamus"};
    private int randomNumber;
    private int index;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button button10;
    private Button button11;
    private Button button12;
    private Button button13;
    private Button reset3;
    private Button submit3;
    private TextView textView17;
    private TextView textView8;
    private TextView textView9;
    private String text;
    ImageView imageView3;
    private static int TIME_OUT;

    static {
        TIME_OUT = 1000;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level3);

        imageView3=(ImageView) findViewById(R.id.imageView3);
        loadImageFromUrl(url);

        textView17 = (TextView) findViewById(R.id.textView17);
        index = randomNumber = randomize(0, 2);
        textView17.setText(questions.get(index));
        button7 = (Button) findViewById(R.id.button7);
        button8 =(Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        button11 = (Button) findViewById(R.id.button11);
        button12 = (Button) findViewById(R.id.button12);
        button13 = (Button) findViewById(R.id.button13);
        reset3 = (Button) findViewById(R.id.reset3);
        submit3 = (Button) findViewById(R.id.submit3);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView9 = (TextView) findViewById(R.id.textView9);
      /*  switch (randomNumber) {
            case 1:
                randomNumber += 2;
            case 2:
                randomNumber += 4;
        }*/
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


      button10.setText(syllables[randomNumber + 3]);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = (String) textView8.getText();
                text += button10.getText();
                textView8.setText(text);
            }
        });
        button11.setText(syllables[randomNumber + 4]);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = (String) textView8.getText();
                text += button11.getText();
                textView8.setText(text);
            }
        });
        button12.setText(syllables[randomNumber + 5]);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = (String) textView8.getText();
                text += button12.getText();
                textView8.setText(text);
            }
        });
        button13.setText(syllables[randomNumber + 6]);
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = (String) textView8.getText();
                text += button13.getText();
                textView8.setText(text);
            }
        });



        reset3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView8.setText("");
            }
        });
        submit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Arrays.asList(answers).contains(text)) {
                    textView9.setText("  Excellent!!!");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent i = new Intent( Level3.this, Final.class);
                            startActivity(i);
                            finish();
                        }
                    }, TIME_OUT);
                } else {
                    textView9.setText("Ops Mistake!\n Try it again");
                }             }

        });
    }

    private void loadImageFromUrl(String url) {
        Picasso.with(this).load(url).placeholder(R.mipmap.ic_launcher).
                error(R.mipmap.ic_launcher).into(imageView3,new com.squareup.picasso.Callback(){


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

