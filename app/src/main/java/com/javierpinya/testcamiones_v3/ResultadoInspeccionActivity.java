package com.javierpinya.testcamiones_v3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.ToxicBakery.viewpager.transforms.FlipHorizontalTransformer;
import com.javierpinya.testcamiones_v3.Adapters.ResultadoBuscarVehiculoSliderAdapter;

public class ResultadoInspeccionActivity extends AppCompatActivity {

    FragmentPagerAdapter adapter;
    private String matT,matC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_inspeccion);
        ViewPager vpPager = (ViewPager) findViewById(R.id.pager);
        Intent intent = new Intent();
        matT = intent.getStringExtra("tractora");
        matC = intent.getStringExtra("cisterna");
        adapter = new ResultadoBuscarVehiculoSliderAdapter(getSupportFragmentManager(), matT, matC);
        vpPager.setAdapter(adapter);
        vpPager.setPageTransformer(true, new FlipHorizontalTransformer());
    }
}
