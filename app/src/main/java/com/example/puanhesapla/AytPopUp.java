package com.example.puanhesapla;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class AytPopUp extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.ayt_popup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int height = dm.heightPixels;
        int width = dm.widthPixels;

        getWindow().setLayout((int)(width*.8),(int)(height*.6));
        double sayısal,sözel,esit,diploma;
        Intent i = getIntent();
        sayısal = i.getDoubleExtra("hampuan_sayısal",0);
        sözel =i.getDoubleExtra("hampuan_sözel",0);
        esit = i.getDoubleExtra("hampuan_esit",0);
        diploma = i.getDoubleExtra("diploma_puanı",0);

        TextView sayısal_ham,sözel_ham,esit_ham,sayısal_yerles,sözel_yerles,esit_yerles,sayısal_once,sözel_once,esit_once;

        sayısal_ham = findViewById(R.id.ayt_ham_sayısal);
        sayısal_yerles = findViewById(R.id.ayt_yerlestirme_Sayısal);
        sayısal_once = findViewById(R.id.ayt_dahaonce_sayısal);

        sözel_ham = findViewById(R.id.ayt_ham_sozel);
        sözel_yerles = findViewById(R.id.ayt_yerlestirme_sozel);
        sözel_once = findViewById(R.id.ayt_dahaonce_sözel);

        esit_ham = findViewById(R.id.ayt_ham_esit);
        esit_yerles = findViewById(R.id.ayt_yerlestirme_esit);
        esit_once = findViewById(R.id.ayt_dahaonce_esit);

        sayısal_ham.setText(Double.toString(sayısal));
        sözel_ham.setText(Double.toString(sözel));
        esit_ham.setText(Double.toString(esit));

        sayısal_yerles.setText(Double.toString(sayısal+(diploma*0.6)));
        sözel_yerles.setText(Double.toString(sözel+(diploma*0.6)));
        esit_yerles.setText(Double.toString(esit+(diploma*0.6)));

        sayısal_once.setText(Double.toString(sayısal+((diploma*0.6)/2)));
        sözel_once.setText(Double.toString(sözel+((diploma*0.6)/2)));
        esit_once.setText(Double.toString(esit+((diploma*0.6)/2)));









    }
}
