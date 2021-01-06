package com.example.covid_19_application;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import android.view.View;


import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Survey extends AppCompatActivity {

    TextView title;
    RadioGroup rg1, rg2, rg3, rg4, rg5, rg6;

    Intent i;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.survey);
        setRadioGroup();
        ActionBar ab = getSupportActionBar();


        ab.setTitle("Survey");
        title = (TextView) findViewById(R.id.textViewTitle);
        Typeface myfont = Typeface.createFromAsset(getAssets(), "fonts/OpenSans-Italic.ttf");
        title.setTypeface(myfont);


    }

    public void setRadioGroup() {
        rg1 = (RadioGroup) findViewById(R.id.rgQuestio_1);
        rg2 = (RadioGroup) findViewById(R.id.rgQuestio_2);
        rg3 = (RadioGroup) findViewById(R.id.rgQuestio_3);
        rg4 = (RadioGroup) findViewById(R.id.rgQuestio_4);
        rg5 = (RadioGroup) findViewById(R.id.rgQuestio_5);
        rg6 = (RadioGroup) findViewById(R.id.rgQuestio_6);


    }


    public void setUnCheckedAll(View view) {

        if (view.getId() == R.id.buttonReset) {

            rg1.clearCheck();
            rg2.clearCheck();
            rg3.clearCheck();
            rg4.clearCheck();
            rg5.clearCheck();
            rg6.clearCheck();


        }


    }


    @SuppressLint("SetTextI18n")
    public void SendData(View view) {


        i = new Intent(Survey.this, SurveyData.class);
     try {
         Bundle b = new Bundle();
         int id1 = rg1.getCheckedRadioButtonId();
         RadioButton Rb1_2 = (RadioButton) findViewById(id1);
         b.putString("Answer1", Rb1_2.getText().toString());
         i.putExtras(b);


         int id2 = rg2.getCheckedRadioButtonId();
         RadioButton Rb3_4 = (RadioButton) findViewById(id2);
         b.putString("Answer2", Rb3_4.getText().toString());
         i.putExtras(b);


         int id3 = rg3.getCheckedRadioButtonId();
         RadioButton Rb5_6 = (RadioButton) findViewById(id3);
         b.putString("Answer3", Rb5_6.getText().toString());
         i.putExtras(b);


         int id4 = rg4.getCheckedRadioButtonId();
         RadioButton Rb7_8 = (RadioButton) findViewById(id4);
         b.putString("Answer4", Rb7_8.getText().toString());
         i.putExtras(b);


         int id5 = rg5.getCheckedRadioButtonId();
         RadioButton Rb9_10 = (RadioButton) findViewById(id5);
         b.putString("Answer5", Rb9_10.getText().toString());
         i.putExtras(b);


         int id6 = rg6.getCheckedRadioButtonId();
         RadioButton Rb11_12 = (RadioButton) findViewById(id6);
         b.putString("Answer6", Rb11_12.getText().toString());
         i.putExtras(b);
         startActivity(i);

     }catch (NullPointerException exception){

         Dialog d=new Dialog(this);
         TextView tv=new TextView(this);
         d.setTitle("Select Your Choices");
         tv.setText("Fill the data first !") ;
         d.setContentView(tv);
         d.show();


     }

    }
}
