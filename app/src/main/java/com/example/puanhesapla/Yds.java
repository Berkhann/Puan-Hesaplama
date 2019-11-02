package com.example.puanhesapla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Yds extends AppCompatActivity {

    EditText edit_dogru;
    Button btn_hesapla;
    TextView text_sonuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yds);

        edit_dogru = (EditText)findViewById(R.id.edit_dogru);
        text_sonuc = (TextView)findViewById(R.id.text_sonuc);
        btn_hesapla = (Button)findViewById(R.id.btn_hesapla);
        btn_hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double dogru = Double.parseDouble(edit_dogru.getText().toString());
                    if(dogru > 80.0 || dogru<0){
                        Toast.makeText(Yds.this, "Doğru Sayısı 80 ile 0 Arasında Olmalıdır ..!", Toast.LENGTH_SHORT).show();
                    }else {
                        double sonuc = dogru * 1.25;
                        text_sonuc.setText("Puan : " + sonuc);
                    }
                }catch (Exception e){
                    Toast.makeText(Yds.this, "Lütfen Sayı Giriniz..!", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}