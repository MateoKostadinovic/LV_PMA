package com.example.mateokosta.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;

import com.example.mateokosta.myapplication.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainMainActivity extends AppCompatActivity {
    private static final String TAG = "MainMainActivity";

    private Button oBtnDalje;
    List<Object> list = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    //private ArrayList<Studenti> list = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_main);

        oBtnDalje = (Button)findViewById(R.id.btnDalje);



        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);

        List<Object> studentiList=generateList();

        Studenti oStudent=(Studenti) getIntent().getSerializableExtra("student");
        studentiList.add(oStudent);

        initRecyclerView(recyclerView,studentiList);

        /*final Bundle oExtras = getIntent().getExtras();
        list = (ArrayList<Studenti>) oExtras.getSerializable("list");

        if((list = (ArrayList<Studenti>) oExtras.getSerializable("list")).size()>=1)
        {
            list = (ArrayList<Studenti>) oExtras.getSerializable("list");
            initRecyclerView(list);
        }*/




        oBtnDalje.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent oMainActivity = new Intent(getApplicationContext(), CreateNewRecordActivity.class);
                startActivity(oMainActivity);
            }
        });

        Spinner dropdown = findViewById(R.id.language_spinner);
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
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)


        /*String sIme = "Mateo";
        String sPrezime = "Kostadinovich";
        String sIme2 = "Pero";
        String sPrezime2 = "Peric";
        Studenti sStudent = new Studenti(sIme,sPrezime);
        Studenti sStudent2 = new Studenti(sIme2,sPrezime2);
        list.add(sStudent);
        list.add(sStudent2);

        initRecyclerView(recyclerView,list);*/

    }
    List<Object> generateList()
    {

        list.add("Studenti");

        /*list.add(new Studenti("Ivan","Ivic"));
        list.add(new Studenti("Luka","Modric"));
        list.add(new Studenti("Ivan","Horvat"));*/
        return list;
    }
    private void initRecyclerView(RecyclerView recyclerView, List<Object> studentList)
    {
        //RecyclerView recyclerView = findViewById(R.id.my_recycler_view);
        MyAdapter adapter = new MyAdapter(studentList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));//ovdje izbacuje gresku
    }
    //odlicna stvar !!!!
    @Override
    public void onBackPressed()
    {

    }
}
