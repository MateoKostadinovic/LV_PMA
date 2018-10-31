package com.example.mateokosta.myapplication;

import android.content.Intent;
import android.support.v4.os.IResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StudentInfoActivity extends AppCompatActivity
{
    private Button oBtnUpisi;
    private String sIme;
    private TextView oIme;
    //private TextView oTextviewIme;
    private EditText oInputPredmet;
    private String sPredmet;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_student_info);
        oBtnUpisi = (Button)findViewById(R.id.btnUpisi);
        oInputPredmet = (EditText)findViewById(R.id.edittextPredmet);



        final Bundle oExtras = getIntent().getExtras();
        sIme = oExtras.getString("ime");
        oIme = (TextView)findViewById(R.id.textviewIme);
        oIme.setText(sIme);

        //oTextviewIme = (TextView) findViewById(R.id.textviewIme);

        oBtnUpisi.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //startActivity(new Intent(StudentInfoActivity.this, SummaryActivity.class));

                sIme = oIme.getText().toString();
                sPredmet = oInputPredmet.getText().toString();

                Intent oUpisiPredmet = new Intent(getApplicationContext(), SummaryActivity.class);
                oUpisiPredmet.putExtra("ime", sIme);
                oUpisiPredmet.putExtra("predmet", sPredmet);
                startActivity(oUpisiPredmet);

            }
        });

    }
}
