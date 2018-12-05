package com.example.mateokosta.myapplication;

import java.io.Serializable;
import java.util.List;

public class Studenti implements Serializable {
    String sIme;
    String sPrezime;
    String sDatum;
    String sPredmet;
    String sProfesor;
    String sAkGodina;
    String sBrojSati;
    String sBrojSatiLv;

    public Studenti(String sime,String sprezime, String sdatum, String spredmet, String sprofesor, String sakgodina, String sbrojsati, String sbrojsatilv)
    {
        sIme=sime;
        sPrezime=sprezime;
        sDatum=sdatum;
        sPredmet=spredmet;
        sProfesor=sprofesor;
        sAkGodina=sakgodina;
        sBrojSati=sbrojsati;
        sBrojSatiLv=sbrojsatilv;
    }
    public String getIme()
    {
        return sIme;
    }
    public String getPrezime()
    {
        return sPrezime;
    }
    public String getDatum()
    {
        return sDatum;
    }
    public String getPredmet()
    {
        return sPredmet;
    }
    public String getProfesor()
    {
        return sProfesor;
    }
    public String getAkGodina()
    {
        return sAkGodina;
    }
    public String getBrojSati()
    {
        return sBrojSati;
    }
    public String getBrojSatiLv()
    {
        return sBrojSatiLv;
    }
}
