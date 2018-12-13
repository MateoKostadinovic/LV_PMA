package com.example.mateokosta.myapplication.fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mateokosta.myapplication.MainMainActivity;
import com.example.mateokosta.myapplication.R;
import com.example.mateokosta.myapplication.Studenti;
import com.example.mateokosta.myapplication.listeners.SummaryInfoDataSource;

import java.io.Serializable;
import java.util.ArrayList;

public class SummaryFragment extends Fragment {
    private static final String EXTRA_NAME =  "EXTRA_NAME";
    private static final String EXTRA_LAST_NAME =  "EXTRA_LAST_NAME";

    public static SummaryFragment newInstance() {
        
        Bundle args = new Bundle();
        
        SummaryFragment fragment = new SummaryFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public SummaryInfoDataSource dataSource;
    TextView textviewIme;
    TextView textviewPrezime;
    TextView textviewDatumRodenja;
    TextView textviewPredmet;
    TextView textviewProfesor;
    TextView textviewAkGodina;
    TextView textviewBrojSati;
    TextView textviewBrojSatiLV;
    Button oBtnKraj;
    Studenti oStudent;
    private ArrayList<Studenti> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View inflatedView = inflater.inflate(R.layout.fragment_summary, container,false);
        textviewIme = inflatedView.findViewById(R.id.textviewIme);
        textviewPrezime = inflatedView.findViewById(R.id.textviewPrezime);
        textviewDatumRodenja = inflatedView.findViewById(R.id.textviewDatumRodenja);
        textviewPredmet = inflatedView.findViewById(R.id.textviewPredmet);
        textviewProfesor = inflatedView.findViewById(R.id.textviewProfesor);
        textviewAkGodina = inflatedView.findViewById(R.id.textviewAkGodina);
        textviewBrojSati = inflatedView.findViewById(R.id.textviewBrojSati);
        textviewBrojSatiLV = inflatedView.findViewById(R.id.textviewBrojSatiLV);
        oBtnKraj = inflatedView.findViewById(R.id.btnKraj);
        return inflatedView;
    }
    /**
     * Funkcija koja se poziva svaki puta kada se promjeni vidljivost Fragmenta (Poziva ju ViewPager),to je idealno mjesto za ponovno osvježiti podatke.
     * @param isVisibleToUser
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser){
            if(dataSource != null){
                oStudent = dataSource.getPerson();

                if(oStudent != null){
                    setupTextViews(oStudent);
                }
            }
        }
    }
    private void setupTextViews(Studenti person){
        textviewIme.setText(person.getIme());
        textviewPrezime.setText(person.getPrezime());
        textviewDatumRodenja.setText(person.getDatum());
        textviewPredmet.setText(person.getPredmet());
        textviewProfesor.setText(person.getProfesor());
        textviewAkGodina.setText(person.getAkGodina());
        textviewBrojSati.setText(person.getBrojSati());
        textviewBrojSatiLV.setText(person.getBrojSatiLv());
        oStudent = new Studenti(person.getIme(),person.getPrezime(),person.getDatum(),person.getPredmet(),person.getProfesor(),person.getAkGodina(),person.getBrojSati(),person.getBrojSatiLv());

    }
}
