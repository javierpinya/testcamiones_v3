package com.javierpinya.testcamiones_v3;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.javierpinya.testcamiones_v3.Adapters.MenuSliderAdapter;
import com.javierpinya.testcamiones_v3.ui.DashboardFragment;
import com.javierpinya.testcamiones_v3.ui.PerfilFragment;
import com.javierpinya.testcamiones_v3.ui.SincronizarFragment;

public class MenuActivity extends AppCompatActivity {

    FragmentPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ViewPager vpPager = (ViewPager) findViewById(R.id.pager);
        adapter = new MenuSliderAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapter);
        vpPager.setPageTransformer(true, new CubeOutTransformer());
    }

}
