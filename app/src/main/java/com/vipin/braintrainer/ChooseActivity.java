package com.vipin.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseActivity extends AppCompatActivity {

    public void chooseOption(View view)
    {
        String tag=view.getTag().toString();
        Intent intent;
        if(tag.equals("0"))
        {
            intent=new Intent(ChooseActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        else if(tag.equals("1"))
        {
            intent=new Intent(ChooseActivity.this,SubtractActivity.class);
            startActivity(intent);
            finish();
        }

        else if(tag.equals("2"))
        {
            intent=new Intent(ChooseActivity.this,MultiplicationActivity.class);
            startActivity(intent);
            finish();
        }
       /* else if(tag.equals("3"))
        {
            intent=new Intent(ChooseActivity.this,DivisionActivity.class);
            startActivity(intent);
            finish();
        }
        */
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

    }
}
