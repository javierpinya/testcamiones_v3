package com.javierpinya.testcamiones_v3.Adapters;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.javierpinya.testcamiones_v3.ui.DashboardFragment;
import com.javierpinya.testcamiones_v3.ui.PerfilFragment;
import com.javierpinya.testcamiones_v3.ui.SincronizarFragment;


public class MenuSliderAdapter extends FragmentPagerAdapter{

    private String tractora;

    public MenuSliderAdapter(FragmentManager fm, String tractora) {
        super(fm);
        this.tractora = tractora;
    }


    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle args = new Bundle();
        switch (position){
            case 0:
                PerfilFragment perfilFragment = new PerfilFragment();
                args.putString("tractora", tractora);
                perfilFragment.setArguments(args);
                return perfilFragment;
            case 1:
                DashboardFragment dashboardFragment = new DashboardFragment();
                return dashboardFragment;

            case 2:
                SincronizarFragment sincronizarFragment = new SincronizarFragment();
                return sincronizarFragment;
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Perfil";
            case 1:
                return "Dashboard";
            case 2:
                return "Sincronizar";
        }
        return "0";
    }
}
