package com.example.covid_19_application;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SurveyData extends AppCompatActivity {


    TextView getAnsT1, getAnsT2, getAnsT3, getAnsT4, getAnsT5, getAnsT6;


    TextView tvQue1, tvQue2, tvQue3, tvQue4, tvQue5, tvQue6;
    TextView tvAns1, tvAns2, tvAns3, tvAns4, tvAns5, tvAns6;
    String tvQuetion1, tvQuetion2, tvQuetion3, tvQuetion4, tvQuetion5, tvQuetion6;
    String tvAnswer1, tvAnswer2, tvAnswer3, tvAnswer4, tvAnswer5, tvAnswer6;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surveydata);
        ActionBar actionBar=getActionBar();
        if(actionBar!=null) {
            actionBar.setTitle("Survey Data ");
        }
        gettingReferences();

        getAnsT1 = (TextView) findViewById(R.id.tvAns1);
        getAnsT2 = (TextView) findViewById(R.id.tvAns2);
        getAnsT3 = (TextView) findViewById(R.id.tvAns3);
        getAnsT4 = (TextView) findViewById(R.id.tvAns4);
        getAnsT5 = (TextView) findViewById(R.id.tvAns5);
        getAnsT6 = (TextView) findViewById(R.id.tvAns6);


        Bundle bundle = getIntent().getExtras();

        getAnsT1.setText(bundle.getCharSequence("Answer1"));
        getAnsT2.setText(bundle.getCharSequence("Answer2"));
        getAnsT3.setText(bundle.getCharSequence("Answer3"));
        getAnsT4.setText(bundle.getCharSequence("Answer4"));
        getAnsT5.setText(bundle.getCharSequence("Answer5"));
        getAnsT6.setText(bundle.getCharSequence("Answer6"));


    }

    public void gettingReferences() {
        tvQue1 = (TextView) findViewById(R.id.tv1);
        tvQue2 = (TextView) findViewById(R.id.tv2);
        tvQue3 = (TextView) findViewById(R.id.tv3);
        tvQue4 = (TextView) findViewById(R.id.tv4);
        tvQue5 = (TextView) findViewById(R.id.tv5);
        tvQue6 = (TextView) findViewById(R.id.tv6);

        tvAns1 = (TextView) findViewById(R.id.tvAns1);
        tvAns2 = (TextView) findViewById(R.id.tvAns2);
        tvAns3 = (TextView) findViewById(R.id.tvAns3);
        tvAns4 = (TextView) findViewById(R.id.tvAns4);
        tvAns5 = (TextView) findViewById(R.id.tvAns5);
        tvAns6 = (TextView) findViewById(R.id.tvAns6);


    }

    public void gettingString() {
        tvQuetion1 = tvQue1.getText().toString();
        tvQuetion2 = tvQue2.getText().toString();
        tvQuetion3 = tvQue3.getText().toString();
        tvQuetion4 = tvQue4.getText().toString();
        tvQuetion5 = tvQue5.getText().toString();
        tvQuetion6 = tvQue6.getText().toString();
        tvAnswer1 = tvAns1.getText().toString();
        tvAnswer2 = tvAns2.getText().toString();
        tvAnswer3 = tvAns3.getText().toString();
        tvAnswer4 = tvAns4.getText().toString();
        tvAnswer5 = tvAns5.getText().toString();
        tvAnswer6 = tvAns6.getText().toString();


    }


    public void sendDataSurvey(View view) {

        gettingString();
        String SurverData = "Que1 : " +  tvQuetion1  + "\n" + tvAnswer1+"\n"
                + "Que2 : " +  tvQuetion2  + "\n" + "Ans: " + tvAnswer1+"\n"
                + "Que3 : " +  tvQuetion3  + "\n" + "Ans: " + tvAnswer1+"\n"
                + "Que4 : " +  tvQuetion4  + "\n" + "Ans: " + tvAnswer1+"\n"
                + "Que5 : " +  tvQuetion5  + "\n" + "Ans: " + tvAnswer1+"\n"
                + "Que6 : " +  tvQuetion6  + "\n" + "Ans: " + tvAnswer1+"\n";

        String[] Recipient = {"tanmay.v.bhosale13@gmail.com"};
        Intent obj = new Intent(Intent.ACTION_SEND);
        obj.putExtra(Intent.EXTRA_EMAIL, Recipient);
        obj.putExtra(Intent.EXTRA_SUBJECT, "Submitted Survey is as follows:");
        obj.putExtra(Intent.EXTRA_TEXT, SurverData);
        obj.setType("plain/text");
        startActivity(Intent.createChooser(obj,"Share Survey Using"));


    }
}



