package com.javierpinya.testcamiones_v3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.ToxicBakery.viewpager.transforms.CubeOutTransformer;
import com.ToxicBakery.viewpager.transforms.FlipHorizontalTransformer;
import com.javierpinya.testcamiones_v3.Adapters.ResultadoBuscarVehiculoSliderAdapter;
import com.javierpinya.testcamiones_v3.ViewModels.TacprcoViewModel;
import com.javierpinya.testcamiones_v3.ViewModels.TacsecoViewModel;

public class ResultadoBuscarVehiculoActivity extends AppCompatActivity{

    FragmentPagerAdapter adapter;
    private String matT;
    private String matC;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_buscar_vehiculo);
        //Recuperamos matrícula del vehículo previamente seleccionado
        Intent intent = getIntent();
        matT = intent.getStringExtra("tractora");
        matC = intent.getStringExtra("cisterna");
        ViewPager vpPager = (ViewPager) findViewById(R.id.pager);
        adapter = new ResultadoBuscarVehiculoSliderAdapter(getSupportFragmentManager(), matT, matC);
        vpPager.setAdapter(adapter);
        vpPager.setPageTransformer(true, new FlipHorizontalTransformer());
    }
}
