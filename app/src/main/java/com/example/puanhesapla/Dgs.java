package com.example.puanhesapla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Dgs extends AppCompatActivity {

    EditText edit_turk_dogru,edit_turk_yanlis,edit_mat_dogru,edit_mat_yanlis,edit_basari;
    TextView text_say_sonuc,text_soz_sonuc,text_esit_sonuc;
    Button btn_hesapla;
    CheckBox checkbox_onay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dgs);

        edit_turk_dogru = (EditText)findViewById(R.id.edit_turk_dogru);
        edit_turk_yanlis = (EditText)findViewById(R.id.edit_turk_yanlis);
        edit_mat_dogru = (EditText)findViewById(R.id.edit_mat_dogru);
        edit_mat_yanlis = (EditText)findViewById(R.id.edit_mat_yanlis);
        edit_basari = (EditText)findViewById(R.id.edit_basari);

        checkbox_onay = (CheckBox)findViewById(R.id.checkbox_onay);

        text_say_sonuc = (TextView)findViewById(R.id.text_say_sonuc);
        text_soz_sonuc = (TextView)findViewById(R.id.text_soz_sonuc);
        text_esit_sonuc = (TextView)findViewById(R.id.text_esit_sonuc);

        btn_hesapla = (Button)findViewById(R.id.btn_hesapla);
        btn_hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    double mat_dogru = Double.parseDouble(edit_mat_dogru.getText().toString());
                    double mat_yanlis = Double.parseDouble(edit_mat_yanlis.getText().toString());
                    double turk_dogru = Double.parseDouble(edit_turk_dogru.getText().toString());
                    double turk_yanlis = Double.parseDouble(edit_turk_yanlis.getText().toString());
                    double basari = Double.parseDouble(edit_basari.getText().toString());


                    if(mat_dogru<=60 && mat_dogru>=0 && mat_yanlis<=60 && mat_yanlis>=0
                            && (mat_dogru+mat_yanlis)<=60.0 && turk_dogru<=60 && turk_dogru>=0 && turk_yanlis<=60 && turk_yanlis>=0
                            && turk_dogru+turk_yanlis<=60 && basari<=100 && basari >= 50){
                        double mat_net = mat_dogru-(mat_yanlis/4.0);
                        double turk_net = turk_dogru-(turk_yanlis/4.0);

                        text_say_sonuc.setText("Sayısal Puan : "+SayPuanHesapla(turk_net,mat_net,basari));
                        text_soz_sonuc.setText("Sözel Puan : "+SozPuanHesapla(turk_net,mat_net,basari));
                        text_esit_sonuc.setText("Eşit Ağırlık Puan : "+EsitPuanHesapla(turk_net,mat_net,basari));


                    }else{
                        Toast.makeText(Dgs.this, "Hatali Giriş ..!", Toast.LENGTH_SHORT).show();
                    }

                }catch (Exception e){
                    Toast.makeText(Dgs.this, "Lütfen Değişkenleri Doğru Giriniz ..!", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
    public String SayPuanHesapla(double turk_net,double mat_net,double basari_yuz){
        double sonuc;
        if(checkbox_onay.isChecked()) {
            sonuc = 145.3 + (turk_net * 0.7) + (mat_net * 3.2) + (basari_yuz * 0.8 * 0.45);
        }
        else{
            sonuc = 145.3 + (turk_net * 0.7) + (mat_net * 3.2) + (basari_yuz * 0.8 * 0.6);
        }


        return Double.toString(sonuc);
    }
    public String SozPuanHesapla(double turk_net,double mat_net,double basari_yuz){

        double sonuc;
        if(checkbox_onay.isChecked()) {
            sonuc = 122.3+(turk_net*2.5)+(mat_net*0.5)+(basari_yuz*0.8*0.45);
        }
        else{
            sonuc = 122.3+(turk_net*2.5)+(mat_net*0.5)+(basari_yuz*0.8*0.6);
        }

        return Double.toString(sonuc);
    }
    public String EsitPuanHesapla(double turk_net,double mat_net,double basari_yuz){

        double sonuc;
        if(checkbox_onay.isChecked()) {
            sonuc = 133.8+(turk_net*1.5)+(mat_net*1.9)+(basari_yuz*0.8*0.45);
        }
        else{
            sonuc = 133.8+(turk_net*1.5)+(mat_net*1.9)+(basari_yuz*0.8*0.6);
        }

        return Double.toString(sonuc);
    }
}