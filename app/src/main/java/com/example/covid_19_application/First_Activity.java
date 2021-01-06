package com.example.covid_19_application;


import android.content.Intent;


import android.content.pm.ApplicationInfo;
import android.graphics.Typeface;
import android.net.Uri;


import android.os.Bundle;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class First_Activity extends AppCompatActivity {


    TextView tv, tvsv;
    Button buttonSur;
    Button buttonOpenHelpLine;
    PopupMenu openMenu;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);

        tv = (TextView) findViewById(R.id.tv_Covid_Title);
        buttonSur = (Button) findViewById(R.id.buttonsurvay);
        buttonOpenHelpLine = (Button) findViewById(R.id.buttonOpenMenu);
        tvsv = (TextView) findViewById(R.id.textViewScroll_View);


        Typeface myFont = Typeface.createFromAsset(getAssets(), "fonts/OpenSans-SemiboldItalic.ttf");
        tv.setTypeface(myFont);
        Typeface myFont2 = Typeface.createFromAsset(getAssets(), "fonts/OpenSans-ExtraBoldItalic.ttf");
        buttonOpenHelpLine.setTypeface(myFont2);
        Typeface myFont3 = Typeface.createFromAsset(getAssets(), "fonts/OpenSans-Bold.ttf");
        tvsv.setTypeface(myFont3);



    }


    public void goSurvay(View view) {
        if (view.getId() == R.id.buttonsurvay) {

            Intent i = new Intent(First_Activity.this, Survey.class);
            startActivity(i);

        }

    }


    public void openMenu(View view) {

        if (view.getId() == R.id.buttonOpenMenu) {

            openMenu = new PopupMenu(First_Activity.this, buttonOpenHelpLine);
            openMenu.getMenuInflater().inflate(R.menu.covid_19_menu, openMenu.getMenu());

            openMenu.show();
            openMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {

                    switch (item.getItemId()) {

                        case R.id.Maharashtra_hl:

                            String tel = "020-26127394";
                            Intent call_0 = new Intent(Intent.ACTION_DIAL);
                            String uri = "tel:" + tel.trim();
                            call_0.setData(Uri.parse(uri));
                            startActivity(call_0);


                            break;
                        case R.id.Delhi_hl:
                            String tel_0 = "011-22307145";
                            Intent call_1 = new Intent(Intent.ACTION_DIAL);
                            String uri_1 = "tel:" + tel_0.trim();
                            call_1.setData(Uri.parse(uri_1));
                            startActivity(call_1);


                            break;
                        case R.id.Rajasthan_hl:
                            String tel_2 = "0141-2225624";
                            Intent call_2 = new Intent(Intent.ACTION_DIAL);
                            String uri_2 = "tel:" + tel_2.trim();
                            call_2.setData(Uri.parse(uri_2));
                            startActivity(call_2);


                            break;
                        case R.id.Kerala_hl:
                            String tel_3 = "0471-2552056";
                            Intent call_3 = new Intent(Intent.ACTION_DIAL);
                            String uri_3 = "tel:" + tel_3.trim();
                            call_3.setData(Uri.parse(uri_3));
                            startActivity(call_3);


                            break;
                        case R.id.Karnataka_hl:
                            String tel_4 = "104";
                            Intent call_4 = new Intent(Intent.ACTION_DIAL);
                            String uri_4 = "tel:" + tel_4.trim();
                            call_4.setData(Uri.parse(uri_4));
                            startActivity(call_4);

                            break;
                        case R.id.Arunachal_Pradesh_hl:
                            String tel_5 = "9436055743";
                            Intent call_5 = new Intent(Intent.ACTION_DIAL);
                            String uri_5 = "tel:" + tel_5.trim();
                            call_5.setData(Uri.parse(uri_5));
                            startActivity(call_5);

                            break;

                        case R.id.Andhra_Pradesh_hl:
                            String tel_6 = "0866-2410978";
                            Intent call_6 = new Intent(Intent.ACTION_DIAL);
                            String uri_6 = "tel:" + tel_6.trim();
                            call_6.setData(Uri.parse(uri_6));
                            startActivity(call_6);

                            break;
                        case R.id.Tamilnadu_hl:
                            String tel_7 = "044-29510500";
                            Intent call_7 = new Intent(Intent.ACTION_DIAL);
                            String uri_7 = "tel:" + tel_7.trim();
                            call_7.setData(Uri.parse(uri_7));
                            startActivity(call_7);

                            break;
                        case R.id.UttarPradesh_hl:
                            String tel_8 = "18001805145";
                            Intent call_8 = new Intent(Intent.ACTION_DIAL);
                            String uri_8 = "tel:" + tel_8.trim();
                            call_8.setData(Uri.parse(uri_8));
                            startActivity(call_8);

                            break;

                        case R.id.WestBengal_hl:
                            String tel_9 = "1800313444222";
                            Intent call_9 = new Intent(Intent.ACTION_DIAL);
                            String uri_9 = "tel:" + tel_9.trim();
                            call_9.setData(Uri.parse(uri_9));
                            startActivity(call_9);

                            break;


                        case R.id.Close_Menu:
                            openMenu.dismiss();
                            break;


                    }

                    return true;
                }

            });


        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sample_menu, menu);

        return true;


    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {


            case R.id.contact:
                Intent contact_us = new Intent("com.example.covid_19_application.CONTACT_US");
                startActivity(contact_us);

                break;

            case R.id.LiveUpdates:
                String GovWeb = "https://www.mygov.in/covid-19";
                Uri obj = Uri.parse(GovWeb);
                Intent openBrowser = new Intent(Intent.ACTION_VIEW, obj);
                Intent.createChooser(openBrowser, "Browse With");
                startActivity(openBrowser);

                break;

            case R.id.Exit:
                First_Activity.this.finish();
                System.exit(0);
                break;

        }

        return true;
    }



}
