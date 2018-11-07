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
    private String sPredmet;
    private TextView oPredmet;
    public Button oBtnKraj;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        oBtnKraj = (Button)findViewById(R.id.btnKraj);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        final Bundle oExtras = getIntent().getExtras();
        sIme = oExtras.getString("ime");
        sPredmet = oExtras.getString("predmet");

        oIme = (TextView)findViewById(R.id.textviewIme);
        oIme.setText(sIme);

        oPredmet = (TextView)findViewById(R.id.textviewPredmet);
        oPredmet.setText(sPredmet);

        oBtnKraj.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(SummaryActivity.this, MainActivity.class));
            }
        });

    }
}
