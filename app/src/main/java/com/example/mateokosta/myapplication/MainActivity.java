package com.example.mateokosta.myapplication;

import android.content.Intent;
import android.support.v4.os.IResultReceiver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    private Button oBtnPosalji;
    private EditText oInputIme;
    private EditText oInputPrezime;
    private EditText oInputDatumRodenja;
    private String sIme;
    private String sPrezime;
    private String sDatumRodenja;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oInputIme = (EditText)findViewById(R.id.edittextIme);
        oInputPrezime = (EditText)findViewById(R.id.edittextPrezime);
        oInputDatumRodenja = (EditText)findViewById(R.id.edittextDatumRodenja);
        oBtnPosalji = (Button)findViewById(R.id.btnPosaljiIme);

        /*oBtnPosalji.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, StudentInfoActivity.class));
            }
        });*/

        oBtnPosalji.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sIme = oInputIme.getText().toString();
                sPrezime = oInputPrezime.getText().toString();
                sDatumRodenja=oInputDatumRodenja.getText().toString();
                Intent oUpisiIme = new Intent(getApplicationContext(), StudentInfoActivity.class);
                oUpisiIme.putExtra("ime", sIme);
                oUpisiIme.putExtra("prezime",sPrezime);
                oUpisiIme.putExtra("datum_rodenja",sDatumRodenja);
                startActivity(oUpisiIme);
            }
        });
    }
    //odlicna stvar !!!!
    @Override
    public void onBackPressed()
    {

    }

}
