package com.javierpinya.testcamiones_v3;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.ToxicBakery.viewpager.transforms.FlipHorizontalTransformer;
import com.javierpinya.testcamiones_v3.Adapters.NuevaInspeccionSliderAdapter;


public class NuevaInspeccionActivity extends AppCompatActivity {

    FragmentPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_inspeccion);
        ViewPager viewPager = findViewById(R.id.pager_nueva_inspeccion);
        adapter = new NuevaInspeccionSliderAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(true,new FlipHorizontalTransformer());
    }


}
