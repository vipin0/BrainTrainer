package com.vipin.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class DivisionActivity extends AppCompatActivity {


    private TextView timer,question,score,answer;
    private Button button0,button1,button2,button3,tryAgain;

    private ArrayList<Double> answers =new ArrayList<>();

    private int locationOfCorrect;

    private int correct=0;
    private int total=0;

    double myRandom(double min, double max) {
        Random r = new Random();
        return (r.nextInt((int)((max-min)*10+1))+min*10) / 10.0;
    }

    public  void playAgain(final View view)
    {
        correct=0;
        total=0;
        timer.setText("30s");
        score.setText("0/0");
        answer.setText("");
        tryAgain.setVisibility(view.INVISIBLE);

        button0.setClickable(true);
        button1.setClickable(true);
        button2.setClickable(true);
        button3.setClickable(true);

        generate();
        new CountDownTimer(30100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(String.valueOf(millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                button0.setClickable(false);
                button1.setClickable(false);
                button2.setClickable(false);
                button3.setClickable(false);
                tryAgain.setVisibility(view.VISIBLE);
                timer.setText("0s");
                answer.setText("Your score: " + Integer.toString(correct) + "/" + Integer.toString(total));
            }
        }.start();

    }

    public  void generate()
    {
        Random random=new Random();
        int a,b;
        a=random.nextInt(30);
        b=random.nextInt(30);
        answers.clear();
        question.setText(Integer.toString(a)+" / "+Integer.toString(b));

        locationOfCorrect=random.nextInt(4);

        double inCorrectAnswer=0;

        for(int i=0;i<4;i++)
        {
            if(i==locationOfCorrect)
            {
                while (b==0)
                {
                    b=random.nextInt(30);
                }
                answers.add(((double)a/b*10)/10);
            }
            else{

                inCorrectAnswer =  myRandom(0.0,31.0);

                boolean present=false;

                while (inCorrectAnswer == a/b || present==true)
                {
                    inCorrectAnswer =random.nextInt(61);
                    if(answers!=null && answers.size()>0) {
                        for (int j = 0; j < answers.size(); j++) {
                            if (answers.get(i) == inCorrectAnswer) ;
                            {
                                present = true;
                                break;
                            }
                        }
                    }
                }
                answers.add(inCorrectAnswer);
            }
        }
        button0.setText(Double.toString(answers.get(0)));
        button1.setText(Double.toString(answers.get(1)));
        button2.setText(Double.toString(answers.get(2)));
        button3.setText(Double.toString(answers.get(3)));




    }

    public  void chooseAnswer(View view)
    {
        if(view.getTag().toString().equals(Integer.toString(locationOfCorrect)))
        {
            answer.setText("Correct !");
            correct++;
        }
        else{
            answer.setText("Incorrect !");
        }
        total++;

        score.setText(Integer.toString(correct)+"/"+Integer.toString(total));

        generate();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_division);


        timer = findViewById(R.id.timer);
        question=findViewById(R.id.questionView);
        score = findViewById(R.id.score);
        answer=findViewById(R.id.answer);
        button0=findViewById(R.id.button0);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        tryAgain=findViewById(R.id.tryAgain);

        //generate();

        playAgain(findViewById(R.id.tryAgain));



    }
}
