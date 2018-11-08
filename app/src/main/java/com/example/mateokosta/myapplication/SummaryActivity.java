package com.example.mateokosta.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity
{
    private String sIme;
    private TextView oIme;
    private String sPrezime;
    private TextView oPrezime;
    private String sDatumRodenja;
    private TextView oDatumRodenja;
    private String sPredmet;
    private TextView oPredmet;
    private String sProfesor;
    private TextView oProfesor;
    private String sAkGodina;
    private TextView oAkGodina;
    private String sBrojSati;
    private TextView oBrojSati;
    private String sBrojSatiLV;
    private TextView oBrojSatiLV;
    public Button oBtnKraj;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        final Bundle oExtras = getIntent().getExtras();
        sIme = oExtras.getString("ime");
        sPrezime = oExtras.getString("prezime");
        sDatumRodenja = oExtras.getString("datum_rodenja");
        sPredmet = oExtras.getString("predmet");
        sProfesor = oExtras.getString("profesor");
        sAkGodina = oExtras.getString("ak_godina");
        sBrojSati = oExtras.getString("broj_sati");
        sBrojSatiLV = oExtras.getString("broj_sati_lv");

        oIme = (TextView)findViewById(R.id.textviewIme);
        oIme.setText(sIme);

        oPrezime = (TextView)findViewById(R.id.textviewPrezime);
        oPrezime.setText(sPrezime);

        oDatumRodenja = (TextView)findViewById(R.id.textviewDatumRodenja);
        oDatumRodenja.setText(sDatumRodenja);

        oPredmet = (TextView)findViewById(R.id.textviewPredmet);
        oPredmet.setText(sPredmet);

        oProfesor = (TextView)findViewById(R.id.textviewProfesor);
        oProfesor.setText(sProfesor);

        oAkGodina = (TextView)findViewById(R.id.textviewAkGodina);
        oAkGodina.setText(sAkGodina);

        oBrojSati = (TextView)findViewById(R.id.textviewBrojSati);
        oBrojSati.setText(sBrojSati);

        oBrojSatiLV = (TextView)findViewById(R.id.textviewBrojSatiLV);
        oBrojSatiLV.setText(sBrojSatiLV);

        oBtnKraj = (Button)findViewById(R.id.btnKraj);
        oBtnKraj.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(SummaryActivity.this, MainActivity.class));
            }
        });

    }
}
