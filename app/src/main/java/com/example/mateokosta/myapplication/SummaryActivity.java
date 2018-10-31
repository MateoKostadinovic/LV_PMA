package com.example.mateokosta.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity
{

    private String sIme;
    private TextView oIme;
    private String sPredmet;
    private TextView oPredmet;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        final Bundle oExtras = getIntent().getExtras();
        sIme = oExtras.getString("ime");
        sPredmet = oExtras.getString("predmet");

        oIme = (TextView)findViewById(R.id.textviewIme);
        oIme.setText(sIme);

        oPredmet = (TextView)findViewById(R.id.textviewPredmet);
        oPredmet.setText(sPredmet);

    }
}
