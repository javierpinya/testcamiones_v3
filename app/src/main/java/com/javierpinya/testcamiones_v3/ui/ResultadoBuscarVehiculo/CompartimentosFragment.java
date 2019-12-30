package com.javierpinya.testcamiones_v3.ui.ResultadoBuscarVehiculo;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.javierpinya.testcamiones_v3.Adapters.CompartimentosAdapter;
import com.javierpinya.testcamiones_v3.Clases.TplcprtEntity;
import com.javierpinya.testcamiones_v3.CompartimentosActivity;
import com.javierpinya.testcamiones_v3.R;
import com.javierpinya.testcamiones_v3.ViewModels.TplcprtViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompartimentosFragment extends Fragment {

    private String cisterna;
    private List<TplcprtEntity> tplcprtEntity;
    private TplcprtViewModel tplcprtViewModel;
    //private BuscarTplcprtAsyncTask buscarTplcprtAsyncTask;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    public CompartimentosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_compartimentos, container, false);
        /*
        cisterna = getArguments().getString("cisterna");
        mRecyclerView = view.findViewById(R.id.rv_compartimentos);
        mLayoutManager = new LinearLayoutManager(getActivity());
        tplcprtViewModel = ViewModelProviders.of(getActivity()).get(TplcprtViewModel.class);
        buscarTplcprtAsyncTask = new BuscarTplcprtAsyncTask();
        buscarTplcprtAsyncTask.execute();


         */
        return view;
    }
/*
    private void UnSegundo(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){}
    }

    private class BuscarTplcprtAsyncTask extends AsyncTask<Void,Void, Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tplcprtViewModel.findTplcprtByMatricula(cisterna).observe(getActivity(), new Observer<List<TplcprtEntity>>() {
                @Override
                public void onChanged(List<TplcprtEntity> tplcprtEntities) {
                    tplcprtEntity = tplcprtEntities;
                }
            });
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            for(int i=0;i<1;i++){
                UnSegundo();
            }

            return true;
        }

        @Override
        protected void onPostExecute(Boolean ok) {
            super.onPostExecute(ok);
            if (ok){
                //Log.d("recyclerviewcomp", tplcprtEntity.get(0).cod_tag_cprt);
                mAdapter = new CompartimentosAdapter(tplcprtEntity, R.layout.listview_compartimentos_item);
                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setAdapter(mAdapter);
            }

        }
    }

 */

}
