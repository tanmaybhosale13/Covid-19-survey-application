package com.example.covid_19_application;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View ;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Contact_Us extends AppCompatActivity implements View.OnClickListener {

    EditText name, phoneNo, SubjectData, message;
    Button SendData;
    String getFullName, getphoneNo, getSubject, getMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_us);
        InitializedVariables();
        loadSavedPreferences();
        ActionBar ab =getSupportActionBar();
        ab.setSubtitle("Contact Us");





    }



    public void InitializedVariables() {
        name = (EditText) findViewById(R.id.editTextName);
        phoneNo = (EditText) findViewById(R.id.editTextPhoneNo);
        SubjectData = (EditText) findViewById(R.id.editTextSubject);
        message = (EditText) findViewById(R.id.editTextMessage);
        SendData = (Button) findViewById(R.id.buttonSendContact_US);
        SendData.setOnClickListener(this);


    }

    public void getDataFromEditText() {
        getFullName = name.getText().toString();
        getphoneNo = phoneNo.getText().toString();
        getSubject = SubjectData.getText().toString();
        getMessage = message.getText().toString();

    }


    @Override
    public void onClick(View v) {
        getDataFromEditText();

        if(getFullName.isEmpty() && getphoneNo.isEmpty() && getSubject.isEmpty() && getMessage.isEmpty()){
            Toast.makeText(this,"Please Fill the form",Toast.LENGTH_LONG).show();
        }


        String[] EmailAdd = {"tanmay.v.bhosale@gmail.com"};
        if (v.getId() == R.id.buttonSendContact_US) {

            Intent obj = new Intent(Intent.ACTION_SEND);
            obj.putExtra(Intent.EXTRA_EMAIL, EmailAdd);
            obj.putExtra(Intent.EXTRA_SUBJECT, getSubject);
            obj.putExtra(Intent.EXTRA_TEXT, getMessage+"\n My Name  is " + getFullName+"\n my current phone number is "+getphoneNo);
            obj.setType("plain/text");
            startActivity(obj);

        }



    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name",getFullName);
        outState.putString("phone",getphoneNo);
        outState.putString("subject",getSubject);
        outState.putString("message",getMessage);


    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle RestoredData) {
        super.onRestoreInstanceState(RestoredData);
        RestoredData.get("name");
        RestoredData.get("phone");
        RestoredData.get("subject");
        RestoredData.get("message");




    }
   public void loadSavedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);

        name.setText(sharedPreferences.getString("name_B",""));
        phoneNo.setText(sharedPreferences.getString("phone_B",""));
        SubjectData.setText(sharedPreferences.getString("subject_B",""));
        message.setText(sharedPreferences.getString("message_B",""));
    }
    public void savePreferences(String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }
    public void saveData(){
        savePreferences("name_B", name.getText().toString());
        savePreferences("phone_B", phoneNo.getText().toString());
        savePreferences("subject_B",SubjectData.getText().toString());
        savePreferences("message_B", message.getText().toString());
    }
    @Override
    public void onBackPressed(){
        saveData();
        super.onBackPressed();
    }
}

