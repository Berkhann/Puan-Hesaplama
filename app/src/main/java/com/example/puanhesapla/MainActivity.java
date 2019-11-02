package com.example.puanhesapla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView btn_yds,btn_dgs,btn_ales;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text_ayt,text_tyt;

        text_ayt = findViewById(R.id.text_ayt);
        text_ayt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Ayt.class);
                startActivity(i);
            }
        });

        text_tyt = findViewById(R.id.text_tyt);
        text_tyt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Tyt.class);
                startActivity(i);
            }
        });


        btn_yds = findViewById(R.id.text_yds);
        btn_dgs = findViewById(R.id.text_dgs);
        btn_ales = findViewById(R.id.text_ales);
        btn_yds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,Yds.class);
                startActivity(in);
            }
        });
        btn_dgs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,Dgs.class);
                startActivity(in);
            }
        });
        btn_ales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,Ales.class);
                startActivity(in);
            }
        });





    }
}
