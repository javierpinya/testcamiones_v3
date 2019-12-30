package com.javierpinya.testcamiones_v3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.javierpinya.testcamiones_v3.Adapters.CompartimentosAdapter;
import com.javierpinya.testcamiones_v3.Clases.TplcprtEntity;
import com.javierpinya.testcamiones_v3.ViewModels.TplcprtViewModel;
import com.javierpinya.testcamiones_v3.ui.ResultadoBuscarVehiculo.CompartimentosFragment;

import java.util.List;

public class CompartimentosActivity extends AppCompatActivity {

    private String cisterna;
    private List<TplcprtEntity> tplcprtEntity;
    private TplcprtViewModel tplcprtViewModel;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compartimentos);
        Intent intent = getIntent();
        cisterna = intent.getStringExtra("cisterna").trim();
        Log.d("cisterna",cisterna);
        mRecyclerView = findViewById(R.id.rv_compartimentos);
        mLayoutManager = new LinearLayoutManager(this);
        tplcprtViewModel = ViewModelProviders.of(this).get(TplcprtViewModel.class);
        //buscarTplcprtAsyncTask = new CompartimentosFragment.BuscarTplcprtAsyncTask();
        //buscarTplcprtAsyncTask.execute();

        tplcprtViewModel.findTplcprtByMatricula(cisterna).observe(this, new Observer<List<TplcprtEntity>>() {
            @Override
            public void onChanged(List<TplcprtEntity> tplcprtEntities) {
                tplcprtEntity = tplcprtEntities;
                Log.d("tplcprt:", tplcprtEntity.get(0).getCod_tag_cprt());
                mAdapter = new CompartimentosAdapter(tplcprtEntity, R.layout.listview_compartimentos_item);
                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setAdapter(mAdapter);
            }
        });



    }
}
