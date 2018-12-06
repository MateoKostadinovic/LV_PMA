package com.example.mateokosta.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.mateokosta.myapplication.Studenti;
import com.example.mateokosta.myapplication.fragments.PersonalInfoFragment;
import com.example.mateokosta.myapplication.fragments.StudentInfoFragment;
import com.example.mateokosta.myapplication.fragments.SummaryFragment;
import com.example.mateokosta.myapplication.listeners.PersonalInfoListener;
import com.example.mateokosta.myapplication.listeners.StudentInfoListener;
import com.example.mateokosta.myapplication.listeners.SummaryInfoDataSource;

import java.util.List;

public class FragmentViewPagerAdapter  extends FragmentPagerAdapter implements PersonalInfoListener,StudentInfoListener, SummaryInfoDataSource {
    List<Integer> dataList;

    private String sName = "";
    private String sLastName = "";
    private String sDate="";
    private String sPredmet="";
    private String sProfesor="";
    private String sAkGodina="";
    private String sBrojSati="";
    private String sBrojSatiLv="";


    public FragmentViewPagerAdapter(FragmentManager fm, List<Integer> dataList) {
        super(fm);
        this.dataList=dataList;
    }

    @Override
    public Fragment getItem(int position) {
        int dataType = dataList.get(position);
        Fragment fragment;
        if(dataType == 1)
        {
            fragment = PersonalInfoFragment.newInstance();
            ((PersonalInfoFragment)fragment).personalInfoListener = this;
        }
        else if (dataType == 2)
        {
            fragment = StudentInfoFragment.newInstance();
            ((StudentInfoFragment)fragment).studentInfoListener = this;
        }
        else
        {
            fragment = SummaryFragment.newInstance();
            ((SummaryFragment) fragment).dataSource = this;

        }
        return fragment;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    /**
     * Ova metoda će se pozvati kada {@link PersonalInfoFragment##setName(String)} bude pozvan.
     *
     */
    public void setName(String sName)
    {
        this.sName = sName;
    }


    public void setLastName(String sLastName)
    {
        this.sLastName = sLastName;
    }

    public void setDate(String sDate)
    {
        this.sDate = sDate;
    }
    public void setPredmet(String sPredmet)
    {
        this.sPredmet = sPredmet;
    }
    public void setProfesor(String sProfesor)
    {
        this.sProfesor = sProfesor;
    }
    public void setAkGodina(String sAkGodina)
    {
        this.sAkGodina = sAkGodina;
    }
    public void setBrojSati(String sBrojSati)
    {
        this.sBrojSati = sBrojSati;
    }
    public void setBrojSatiLv(String sBrojSatiLv)
    {
        this.sBrojSatiLv = sBrojSatiLv;
    }

    public Studenti getPerson() {
        return new Studenti(sName,sLastName,sDate,sPredmet,sProfesor,sAkGodina,sBrojSati,sBrojSatiLv);
    }
}
