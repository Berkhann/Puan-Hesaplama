package com.example.puanhesapla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Tyt extends AppCompatActivity {

    EditText edit_turkce__dogru,edit_sosyal_dogru,edit_mat_dogru,edit_fen_dogru;
    EditText edit_turkce_yanlis,edit_sosyal_yanlis,edit_mat_yanlis,edit_fen_yanlis;
    EditText diploma_puanı;
    TextView text_hampuan,text_yerlestirme,text_dahaonce;
    double turkce_net,sosyal_net,mat_net,fen_net,dip_puan;
    double hampuan,yerlestirilme,dahaonce;
    Button hesapla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayt);

        edit_turkce__dogru = findViewById(R.id.edit_turkce_dogru);
        edit_turkce_yanlis = findViewById(R.id.edit_turkce_yanlis);

        edit_sosyal_dogru = findViewById(R.id.edit_sosyal_dogru);
        edit_sosyal_yanlis = findViewById(R.id.edit_sosyal_yanlis);

        edit_mat_dogru = findViewById(R.id.edit_mat_dogru);
        edit_mat_yanlis = findViewById(R.id.edit_mat_yanlis);

        edit_fen_dogru = findViewById(R.id.edit_fen_dogru);
        edit_fen_yanlis = findViewById(R.id.edit_fen_yanlis);

        diploma_puanı = findViewById(R.id.edit_diploma_puan);

        /////////////////////////////////////////////////////////////////////////////////////////////////

        text_hampuan = findViewById(R.id.text_hampuan);
        text_dahaonce = findViewById(R.id.text_dahaonce);
        text_yerlestirme=findViewById(R.id.text_yerlestirme);

        hesapla = findViewById(R.id.btn_ayt);

        hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        text_hampuan.setText("");
                        text_dahaonce.setText("");
                        text_yerlestirme.setText("");

                    try {
                        turkce_net = net_hesapla(Double.parseDouble(edit_turkce__dogru.getText().toString()), Double.parseDouble(edit_turkce_yanlis.getText().toString()));
                        sosyal_net = net_hesapla(Double.parseDouble(edit_sosyal_dogru.getText().toString()), Double.parseDouble(edit_sosyal_yanlis.getText().toString()));
                        mat_net = net_hesapla(Double.parseDouble(edit_mat_dogru.getText().toString()), Double.parseDouble(edit_mat_yanlis.getText().toString()));
                        fen_net = net_hesapla(Double.parseDouble(edit_fen_dogru.getText().toString()), Double.parseDouble(edit_fen_yanlis.getText().toString()));
                        dip_puan = Double.parseDouble(diploma_puanı.getText().toString());


                        if (Double.parseDouble(edit_turkce__dogru.getText().toString()) > 40 || Double.parseDouble(edit_turkce__dogru.getText().toString()) > 40 ||
                                Double.parseDouble(edit_sosyal_dogru.getText().toString()) > 20 || Double.parseDouble(edit_sosyal_yanlis.getText().toString()) > 20 ||
                                Double.parseDouble(edit_mat_dogru.getText().toString()) > 40 || Double.parseDouble(edit_mat_yanlis.getText().toString()) > 40 ||
                                Double.parseDouble(edit_fen_dogru.getText().toString()) > 20 || Double.parseDouble(edit_fen_yanlis.getText().toString()) > 20 ||
                                Double.parseDouble(edit_turkce__dogru.getText().toString()) < 0 || Double.parseDouble(edit_turkce__dogru.getText().toString()) < 0 ||
                                Double.parseDouble(edit_sosyal_dogru.getText().toString()) < 0 || Double.parseDouble(edit_sosyal_yanlis.getText().toString()) < 0 ||
                                Double.parseDouble(edit_mat_dogru.getText().toString()) < 0 || Double.parseDouble(edit_mat_yanlis.getText().toString()) < 0 ||
                                Double.parseDouble(edit_fen_dogru.getText().toString()) < 0 || Double.parseDouble(edit_fen_yanlis.getText().toString()) < 0 ||
                                Double.parseDouble(edit_turkce__dogru.getText().toString()) + Double.parseDouble(edit_turkce_yanlis.getText().toString()) >40 ||
                                Double.parseDouble(edit_sosyal_dogru.getText().toString()) + Double.parseDouble(edit_sosyal_yanlis.getText().toString()) > 20 ||
                                Double.parseDouble(edit_mat_dogru.getText().toString()) + Double.parseDouble(edit_mat_yanlis.getText().toString()) > 40 ||
                                Double.parseDouble(edit_fen_dogru.getText().toString()) + Double.parseDouble(edit_fen_yanlis.getText().toString()) > 20
                        ) {
                            Toast.makeText(Tyt.this, "DOĞRU VE YANLIŞ SAYISINI KONTROL EDİNİZ.", Toast.LENGTH_SHORT).show();
                        } else if (dip_puan > 100) {
                            Toast.makeText(Tyt.this, "DİPLOMA PUANI 0-100 ARASINDA OLMALIDIR.", Toast.LENGTH_SHORT).show();
                        }
                        else {

                            hampuan = ((100) + (turkce_net * 3.3) + (sosyal_net * 3.4) + (mat_net * 3.3) + (fen_net * 3.4));

                            if (dip_puan != 0) {
                                if (dip_puan > 0 && dip_puan <= 4) {
                                    dip_puan = dip_puan * 25;
                                }
                                yerlestirilme = (hampuan) + (dip_puan * 0.6);
                                dahaonce = (hampuan) + ((dip_puan * 0.6) / 2);
                                text_dahaonce.setText(Double.toString(dahaonce));
                                text_yerlestirme.setText(Double.toString(yerlestirilme));
                            }

                            text_hampuan.setText(Double.toString(hampuan));

                        }
                    } catch (Exception E) {
                        Toast.makeText(Tyt.this, "BOŞ ALAN BIRAKMAYINIZ.", Toast.LENGTH_SHORT).show();
                    }


                }


        });





    }


    public double net_hesapla(double dogru,double yanlis)
    {
        double net;

        yanlis = yanlis/4.0;

        net = dogru - yanlis;

        return net;
    }
}
