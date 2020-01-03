package com.javierpinya.testcamiones_v3.Adapters;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.javierpinya.testcamiones_v3.ui.NuevaInspeccion.CabeceraInspeccionFragment;
import com.javierpinya.testcamiones_v3.ui.NuevaInspeccion.CheckListFragment;

public class NuevaInspeccionSliderAdapter extends FragmentPagerAdapter {

    public NuevaInspeccionSliderAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public int getCount() {
        return 3;
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
        }
        return "0;";
    }
}
