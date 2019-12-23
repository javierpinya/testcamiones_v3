package com.javierpinya.testcamiones_v3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;
import com.ToxicBakery.viewpager.transforms.FlipHorizontalTransformer;
import com.javierpinya.testcamiones_v3.Adapters.ResultadoBuscarVehiculoSliderAdapter;

public class ResultadoBuscarVehiculoActivity extends AppCompatActivity {

    FragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_buscar_vehiculo);
        //Recuperamos matrícula del vehículo previamente seleccionado
        Intent intent = getIntent();
        String matT = intent.getStringExtra("tractora");
        String matC = intent.getStringExtra("cisterna");
        ViewPager vpPager = (ViewPager) findViewById(R.id.pager);
        adapter = new ResultadoBuscarVehiculoSliderAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapter);
        vpPager.setPageTransformer(true, new FlipHorizontalTransformer());
    }
}
