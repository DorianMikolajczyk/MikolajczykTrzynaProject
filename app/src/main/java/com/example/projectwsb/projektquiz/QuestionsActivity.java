package com.example.projectwsb.projektquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsActivity extends AppCompatActivity {
    TextView tv;
    Button submitbutton, quitbutton;
    RadioGroup radio_g;
    RadioButton rb1,rb2,rb3,rb4;

    String questions[] = {
                            "Kto wynalazł radio?",
                            "Kto zbudował pierwszy silnik wysokoprężny?",
                            "Kto jest wynalazcą systemu telewizyjnego, telewizora oraz telewizji kolorowej?",
                            "Kto wynalazł maszynę parową?",
                            "Jak nazywał się człowiek który wynalazł telefon?",
                            "Ile wynosi 2+2?",
                            "Ile to 13% z 10?",
                            "14 jest jakim procentem z 140?",
                            "Ile to 20% z 12?",
                            "Ile to 27% z 123?"
                         };
    String answers[] =
            {
            "Guglielmo Marconi",
            "Rudolf Diesel",
            "John Logie Baird",
            "James Watt",
            "Alexander Graham Bell",
            "4",
            "1,3",
            "10%",
            "2,4",
            "33,21"
            };
    String opt[] = {
                    "Guglielmo Spaghetti","Guglielmo Marconi","Guglielmo Macaroni","Arnold Schwarzenegger",
                    "Mariusz Pudzianowski","Rudolf Diesel","Carl Benz","Emil Berliner",
                    "John Logie Baird","Joseph Monier","Percy Pilcher","Adam Małysz",
                    "James Watt","James Wat","Watt Jameson","Wat Jameson",
                    "Rasmus Malling-Hansen","Alexander Graham Bell","Standford Fleming","Rodolphe Lindt",
                    "178","1","4","2",
                    "99","233","33","1,3",
                    "10%","100%","12%","14%",
                    "2,4","2,2","3,2","2,6",
                     "8","23","33,21","17"
                   };
    int flag=0;
    public static int marks=0,correct=0,wrong=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        final TextView score = (TextView)findViewById(R.id.textView4);
        TextView textView=(TextView)findViewById(R.id.DispName);
        Intent intent = getIntent();
        String name= intent.getStringExtra("myname");

        if (name.trim().equals(""))
            textView.setText("Cześć użytkowniku");
        else
        textView.setText("Cześć " + name);

        submitbutton=(Button)findViewById(R.id.button3);
        quitbutton=(Button)findViewById(R.id.buttonquit);
        tv=(TextView) findViewById(R.id.tvque);

        radio_g=(RadioGroup)findViewById(R.id.answersgrp);
        rb1=(RadioButton)findViewById(R.id.radioButton);
        rb2=(RadioButton)findViewById(R.id.radioButton2);
        rb3=(RadioButton)findViewById(R.id.radioButton3);
        rb4=(RadioButton)findViewById(R.id.radioButton4);
        tv.setText(questions[flag]);
        rb1.setText(opt[0]);
        rb2.setText(opt[1]);
        rb3.setText(opt[2]);
        rb4.setText(opt[3]);
        submitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int color = mBackgroundColor.getColor();
                //mLayout.setBackgroundColor(color);

                if(radio_g.getCheckedRadioButtonId()==-1)
                {
                    Toast.makeText(getApplicationContext(), "proszę wybrać jedną odpowiedź", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton uans = (RadioButton) findViewById(radio_g.getCheckedRadioButtonId());
                String ansText = uans.getText().toString();
//                Toast.makeText(getApplicationContext(), ansText, Toast.LENGTH_SHORT).show();
                if(ansText.equals(answers[flag])) {
                    correct++;
                    Toast.makeText(getApplicationContext(), "dobrze!", Toast.LENGTH_SHORT).show();
                }
                else {
                    wrong++;
                    Toast.makeText(getApplicationContext(), "źle!", Toast.LENGTH_SHORT).show();
                }

                flag++;

                if (score != null)
                    score.setText(""+correct);

                if(flag<questions.length)
                {
                    tv.setText(questions[flag]);
                    rb1.setText(opt[flag*4]);
                    rb2.setText(opt[flag*4 +1]);
                    rb3.setText(opt[flag*4 +2]);
                    rb4.setText(opt[flag*4 +3]);
                }
                else
                {
                    marks=correct;
                    Intent in = new Intent(getApplicationContext(),ResultActivity.class);
                    startActivity(in);
                }
                radio_g.clearCheck();
            }
        });

        quitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),ResultActivity.class);
                startActivity(intent);
            }
        });
    }

}