package com.javierpinya.testcamiones_v3.Adapters;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.javierpinya.testcamiones_v3.ui.NuevaInspeccion.CabeceraInspeccionFragment;
import com.javierpinya.testcamiones_v3.ui.NuevaInspeccion.CheckListFragment;
import com.javierpinya.testcamiones_v3.ui.NuevaInspeccion.CompartimentosInspeccionFragment;
import com.javierpinya.testcamiones_v3.ui.NuevaInspeccion.FotosInspeccionFragment;
import com.javierpinya.testcamiones_v3.ui.NuevaInspeccion.ValoracionInspeccionFragment;

public class NuevaInspeccionSliderAdapter extends FragmentPagerAdapter {

    public NuevaInspeccionSliderAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                CabeceraInspeccionFragment cabeceraInspeccionFragment = new CabeceraInspeccionFragment();
                return cabeceraInspeccionFragment;
            case 1:
                CheckListFragment checkListFragment = new CheckListFragment();
                return checkListFragment;
            case 2:
                CompartimentosInspeccionFragment compartimentosInspeccionFragment = new CompartimentosInspeccionFragment();
                return compartimentosInspeccionFragment;
            case 3:
                FotosInspeccionFragment fotosInspeccionFragment = new FotosInspeccionFragment();
                return fotosInspeccionFragment;
            case 4:
                ValoracionInspeccionFragment valoracionInspeccionFragment = new ValoracionInspeccionFragment();
                return valoracionInspeccionFragment;
        }

        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Cabecera";
            case 1:
                return "CheckList";
            case 2:
                return "Compartimentos";
            case 3:
                return "Fotos";
            case 4:
                return "Valoración";
        }
        return "0";
    }
}
