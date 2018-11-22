package com.example.mateokosta.myapplication;

import java.io.Serializable;
import java.util.List;

public class Studenti implements Serializable {
    String sIme;
    String sPrezime;

    public Studenti(String sime,String sprezime)
    {
        sIme=sime;
        sPrezime=sprezime;
    }
    public String getIme()
    {
        return sIme;
    }
    public String getPrezime()
    {
        return sPrezime;
    }
}
