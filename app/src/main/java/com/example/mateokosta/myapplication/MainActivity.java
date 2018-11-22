package com.example.mateokosta.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private Button oBtnPosalji;
    private EditText oInputIme;
    private EditText oInputPrezime;
    private EditText oInputDatumRodenja;
    private String sIme;
    private String sPrezime;
    private String sImePrijenos;
    private String sPrezimePrijenos;
    private String sDatumRodenja;

    //private ArrayList<Studenti> list = new ArrayList<>();

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
        //sImePrijenos = oInputIme.getText().toString();
        //sPrezimePrijenos = oInputPrezime.getText().toString();
        //Studenti oStudent = new Studenti(sImePrijenos,sPrezimePrijenos);
        //list.add(oStudent);

        //initRecyclerView(list);
        oBtnPosalji.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sIme = oInputIme.getText().toString();
                sPrezime = oInputPrezime.getText().toString();
                sDatumRodenja=oInputDatumRodenja.getText().toString();

                Intent oUpisiIme = new Intent(getApplicationContext(), StudentInfoActivity.class);
                oUpisiIme.putExtra("ime", sIme);
                oUpisiIme.putExtra("prezime",sPrezime);
                oUpisiIme.putExtra("datum_rodenja",sDatumRodenja);
                //oUpisiIme.putExtra("list", (Serializable) list);
                startActivity(oUpisiIme);
            }
        });
    }

}
