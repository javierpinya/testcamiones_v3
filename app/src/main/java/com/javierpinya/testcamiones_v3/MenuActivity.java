package com.javierpinya.testcamiones_v3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;
import com.javierpinya.testcamiones_v3.Adapters.MenuSliderAdapter;

public class MenuActivity extends AppCompatActivity {

    FragmentPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ViewPager vpPager = (ViewPager) findViewById(R.id.pager);
        adapter = new MenuSliderAdapter(getSupportFragmentManager(), "hola");
        vpPager.setAdapter(adapter);
        vpPager.setPageTransformer(true, new CubeOutTransformer());
    }

}
