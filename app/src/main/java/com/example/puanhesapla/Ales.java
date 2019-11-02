package com.example.puanhesapla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ales extends AppCompatActivity {

    EditText edit_turk_dogru,edit_turk_yanlis,edit_mat_dogru,edit_mat_yanlis,edit_basari;
    TextView text_say_sonuc,text_soz_sonuc,text_esit_sonuc;
    Button btn_hesapla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ales);

        edit_turk_dogru = (EditText)findViewById(R.id.edit_turk_dogru);
        edit_turk_yanlis = (EditText)findViewById(R.id.edit_turk_yanlis);
        edit_mat_dogru = (EditText)findViewById(R.id.edit_mat_dogru);
        edit_mat_yanlis = (EditText)findViewById(R.id.edit_mat_yanlis);

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
                    if(mat_dogru<=50 && mat_dogru>=0 && mat_yanlis<=50 && mat_yanlis>=0
                            && (mat_dogru+mat_yanlis)<=50.0 && turk_dogru<=50 && turk_dogru>=0 && turk_yanlis<=50 && turk_yanlis>=0
                            && turk_dogru+turk_yanlis<=50){
                        double mat_net = mat_dogru-(mat_yanlis/4.0);
                        double turk_net = turk_dogru-(turk_yanlis/4.0);

                        text_say_sonuc.setText("Sayısal Puan : "+SayPuanHesapla(turk_net,mat_net));
                        text_soz_sonuc.setText("Sözel Puan : "+SozPuanHesapla(turk_net,mat_net));
                        text_esit_sonuc.setText("Eşit Ağırlık Puan : "+EsitPuanHesapla(turk_net,mat_net));


                    }else{
                        Toast.makeText(Ales.this, "Hatali Giriş ..!", Toast.LENGTH_SHORT).show();
                    }

                }catch (Exception e){
                    Toast.makeText(Ales.this, "Hatalı Giriş ..!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
    public String SayPuanHesapla(double turk_net,double mat_net){
        double sonuc = 40+(turk_net*0.3)+(mat_net*0.9);
        return Double.toString(sonuc);
    }
    public String SozPuanHesapla(double turk_net,double mat_net){
        double sonuc = 40+(turk_net*0.9)+(mat_net*0.3);
        return Double.toString(sonuc);
    }
    public String EsitPuanHesapla(double turk_net,double mat_net){
        double sonuc = 40+(turk_net*0.6)+(mat_net*0.6);
        return Double.toString(sonuc);
    }
}