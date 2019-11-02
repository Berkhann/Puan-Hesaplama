package com.example.puanhesapla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ayt extends AppCompatActivity {

    EditText edit_turkdili_dogru,edit_turkdili_yanlis,edit_tarih1_dogru,edit_tarih1_yanlis,edit_cografya1_dogru,edit_cografya1_yanlis,edit_tarih2_dogru,edit_tarih2_yanlis,
            edit_cografya2_dogru,edit_cografya2_yanlis, edit_felsefe_dogru,edit_felsefe_yanlis,edit_din_dogru,edit_din_yanlis,edit_mat_dogru,edit_mat_yanlis,edit_kimya_dogru,
            edit_kimya_yanlis,edit_biyoloji_dogru,edit_biyoloji_yanlis,edit_dil_dogru,edit_dil_yanlis,edit_fizik_dogru,edit_fizik_yanlis;

    TextView sayısal_sonuc,sözel_sonuc,esit_sonuc;

    double mat_net,fizik_net,kimya_net,biyoloji_net,cografya1_net,tarih1_net,turkdili_net,cografya2_net,tarih2_net,felsefe_net,din_net,yabancı_net,diploma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tyt);

        edit_turkdili_dogru = findViewById(R.id.edit_turkdiliveedebiyatı_dogru);
        edit_turkdili_yanlis = findViewById(R.id.edit_turkdiliveedebiyatı_yanlis);

        edit_tarih1_dogru = findViewById(R.id.edit_tarih1_dogru);
        edit_tarih1_yanlis = findViewById(R.id.edit_tarih1_yanlis);

        edit_cografya1_dogru = findViewById(R.id.edit_cografya1_dogru);
        edit_cografya1_yanlis = findViewById(R.id.edit_cografya1_yanlis);

        edit_tarih2_dogru = findViewById(R.id.edit_tarih2_dogru);
        edit_tarih2_yanlis = findViewById(R.id.edit_tarih2_yanlis);

        edit_cografya2_dogru = findViewById(R.id.ediedit_cografya2_dogru);
        edit_cografya2_yanlis = findViewById(R.id.edit_cografya2_yanlis);

        edit_felsefe_dogru = findViewById(R.id.edit_felsefe_dogru);
        edit_felsefe_yanlis = findViewById(R.id.edit_felsefe_yanlis);

        edit_din_dogru = findViewById(R.id.edit_dinkulturu_dogru);
        edit_din_yanlis = findViewById(R.id.edit_dinkulturu_yanlis);

        edit_mat_dogru = findViewById(R.id.edit_matematik_dogru);
        edit_mat_yanlis = findViewById(R.id.edit_matematik_yanlis);

        edit_kimya_dogru = findViewById(R.id.edit_kimya_dogru);
        edit_kimya_yanlis = findViewById(R.id.edit_kimya_yanlis);

        edit_biyoloji_dogru = findViewById(R.id.edit_biyoloji_dogru);
        edit_biyoloji_yanlis = findViewById(R.id.edit_biyoloji_yanlis);

        edit_dil_dogru = findViewById(R.id.edit_yabancı_dogru);
        edit_dil_yanlis = findViewById(R.id.edit_yabancı_yanlis);

        edit_fizik_dogru = findViewById(R.id.edit_fizik_dogru);
        edit_fizik_yanlis = findViewById(R.id.edit_fizik_yanlis);


        EditText diploma_puanı;

        diploma_puanı = findViewById(R.id.edit_diplomapuanı);

        diploma = Double.parseDouble(diploma_puanı.getText().toString());

        Button hesapla;
        hesapla = findViewById(R.id.btn_ayt_hesapla);
        hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hesapla();
            }
        });


    }

    public void hesapla()
    {

        try {
            double hampuan_sayisal,hampuan_sözel,hampuan_esit;

            net_hesapla();

            hampuan_sayisal = 100+(3*mat_net)+(2.85*fizik_net)+(3.07*kimya_net)+(3.07*biyoloji_net);
            hampuan_esit = 100+(mat_net*3)+(turkdili_net*3)+(tarih1_net*2.8)+(cografya1_net*3.33);
            hampuan_sözel = 100+(turkdili_net*3)+(tarih1_net*2.8)+(cografya1_net*3.33)+(tarih2_net*2.91)+(cografya2_net*2.91)+(felsefe_net*3)+(din_net*3.33);

            Intent i = new Intent(Ayt.this,AytPopUp.class);
            i.putExtra("hampuan_sayısal",hampuan_sayisal);
            i.putExtra("hampuan_sözel",hampuan_sözel);
            i.putExtra("hampuan_esit",hampuan_esit);
            i.putExtra("diploma_puanı",diploma);
            startActivity(i);

        }catch (Exception e)
        {
            Toast.makeText(this, "HATALI GİRİŞ YAPTINIZ.", Toast.LENGTH_SHORT).show();
        }




    }


    void net_hesapla()
    {
        mat_net = Double.parseDouble(edit_mat_dogru.getText().toString())-(Double.parseDouble(edit_mat_yanlis.getText().toString())/4.0);

        fizik_net = Double.parseDouble(edit_fizik_dogru.getText().toString())-(Double.parseDouble(edit_fizik_yanlis.getText().toString())/4.0);
        kimya_net = Double.parseDouble(edit_kimya_dogru.getText().toString())-(Double.parseDouble(edit_kimya_yanlis.getText().toString())/4.0);
        biyoloji_net = Double.parseDouble(edit_biyoloji_dogru.getText().toString())-(Double.parseDouble(edit_biyoloji_yanlis.getText().toString())/4.0);

        turkdili_net = Double.parseDouble(edit_turkdili_dogru.getText().toString())-(Double.parseDouble(edit_turkdili_yanlis.getText().toString())/4.0);
        tarih1_net = Double.parseDouble(edit_tarih1_dogru.getText().toString())-(Double.parseDouble(edit_tarih1_yanlis.getText().toString())/4.0);
        cografya1_net = Double.parseDouble(edit_cografya1_dogru.getText().toString())-(Double.parseDouble(edit_cografya1_yanlis.getText().toString())/4.0);tarih2_net = Double.parseDouble(edit_tarih2_dogru.getText().toString())-(Double.parseDouble(edit_tarih2_yanlis.getText().toString())/4.0);

        cografya2_net = Double.parseDouble(edit_mat_dogru.getText().toString())-(Double.parseDouble(edit_mat_yanlis.getText().toString())/4.0);
        tarih2_net = Double.parseDouble(edit_tarih2_dogru.getText().toString())-(Double.parseDouble(edit_tarih2_yanlis.getText().toString())/4.0);
        felsefe_net = Double.parseDouble(edit_felsefe_dogru.getText().toString())-(Double.parseDouble(edit_felsefe_yanlis.getText().toString())/4.0);
        din_net = Double.parseDouble(edit_din_dogru.getText().toString())-(Double.parseDouble(edit_din_yanlis.getText().toString())/4.0);

        yabancı_net = Double.parseDouble(edit_dil_dogru.getText().toString())-(Double.parseDouble(edit_dil_yanlis.getText().toString())/4.0);


    }
}
