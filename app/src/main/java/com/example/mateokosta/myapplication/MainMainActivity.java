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

import java.util.ArrayList;
import java.util.List;

public class MainMainActivity extends AppCompatActivity {
    private static final String TAG = "MainMainActivity";

    private Button oBtnDalje;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private ArrayList<Object> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_main);

        oBtnDalje = (Button)findViewById(R.id.btnDalje);

        oBtnDalje.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent oMainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(oMainActivity);
            }
        });

        /*Spinner dropdown = findViewById(R.id.language_spinner);
        //create a list of items for the spinner.
        String[] items = new String[]{"Hrvatski", "Engleski", "Madarski"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(adapter);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(
                this, LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(mLayoutManager);*/

        // specify an adapter (see also next example)



        list.add("Studenti");

        String sIme="Mateo";
        String sPrezime="Kostadinovich";
        Studenti sStudent=new Studenti(sIme,sPrezime);
        list.add(sStudent);

        initRecyclerView(list);
    }
    private void initRecyclerView(ArrayList<Object> list)
    {
        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        MyAdapter adapter = new MyAdapter(list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    //odlicna stvar !!!!
    @Override
    public void onBackPressed()
    {

    }
}
