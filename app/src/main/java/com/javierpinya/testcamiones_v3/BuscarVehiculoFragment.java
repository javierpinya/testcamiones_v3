package com.javierpinya.testcamiones_v3;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.javierpinya.testcamiones_v3.Adapters.VehiculosAdapter;
import com.javierpinya.testcamiones_v3.Clases.TaccamiEntity;
import com.javierpinya.testcamiones_v3.ViewModels.TaccamiViewModel;
import com.javierpinya.testcamiones_v3.ViewModels.TaccatrViewModel;
import com.javierpinya.testcamiones_v3.ViewModels.TaccondViewModel;
import com.javierpinya.testcamiones_v3.ViewModels.TacprcoViewModel;
import com.javierpinya.testcamiones_v3.ViewModels.TacsecoViewModel;
import com.javierpinya.testcamiones_v3.ViewModels.TplcprtViewModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BuscarVehiculoFragment extends Fragment {
    private EditText primerComp;
    private EditText segundoComp;
    private Button buscar;
    private ProgressBar progressBar;
    private String primer="";
    private String segundo = "";
    private String conductor="";
    private TacprcoViewModel tacprcoViewModel;
    private TacsecoViewModel tacsecoViewModel;
    private TaccamiViewModel taccamiViewModel;
    private TaccatrViewModel taccatrViewModel;
    private TaccondViewModel taccondViewModel;
    private TplcprtViewModel tplcprtViewModel;
    private List<TaccamiEntity> taccamiList1 = new ArrayList<>();
    private List<TaccamiEntity> taccamiList2 = new ArrayList<>();
    private List<TaccamiEntity> taccamiList3 = new ArrayList<>();
    private List<TaccamiEntity> taccamiList4 = new ArrayList<>();

    private List<Integer> cod_vehiculo1 = new ArrayList<>();
    private List<Integer> cod_vehiculo2 = new ArrayList<>();
    private List<Integer> listaEquivalente = new ArrayList<>();
    private List<String> tractoras = new ArrayList<>();
    private List<String> cisternas = new ArrayList<>();

    private List<Integer> bloqueadoTractoras = new ArrayList<>();
    private List<Integer> bloqueadoCisternas = new ArrayList<>();

    private List<String> matT = new ArrayList<>();
    private List<String> matC = new ArrayList<>();

    private List<Integer> vehiculoT = new ArrayList<>();
    private List<Integer> vehiculoC= new ArrayList<>();
    private List<Integer> vehiculo = new ArrayList<>();

    private BuscarAsyncTask buscarAsyncTask;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    public BuscarVehiculoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_buscar_vehiculo, container, false);
        primerComp = view.findViewById(R.id.etPrimerComp);
        segundoComp = view.findViewById(R.id.etSegundoComp);
        progressBar = view.findViewById(R.id.progressBar);
        buscar = view.findViewById(R.id.btnBuscarVehiculo);

        lanzarViewModel();



        //RecyclerView
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_resultadobuscarvehiculo);
        mLayoutManager = new LinearLayoutManager(getActivity());


        final List<Integer> bT = new ArrayList<>();
        final List<Integer> bC = new ArrayList<>();

        final List<String> mT = new ArrayList<>();
        final List<String> mC = new ArrayList<>();

        for (int i=0;i<10;i++){
            mT.add("000"+i+"AAA");
            mC.add("000"+i+"BBB");
            bT.add(2);
            bC.add(2);

        }


        buscar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                vehiculo.clear();
                vehiculoC.clear();
                vehiculoT.clear();
                matT.clear();
                matC.clear();
                bloqueadoCisternas.clear();
                bloqueadoTractoras.clear();
                progressBar.setVisibility(View.VISIBLE);
                primerComp.clearFocus();
                segundoComp.clearFocus();
                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(primerComp.getWindowToken(), 0);
                buscarAsyncTask = new BuscarAsyncTask();

                primer = primerComp.getText().toString().trim();
                segundo = segundoComp.getText().toString().trim();
                if (primer.isEmpty() && segundo.isEmpty()){
                    Toast.makeText(getActivity(), "Introduzca una matrícula", Toast.LENGTH_SHORT).show();
                }else {
                    buscarAsyncTask.execute();
                }
            }

        });

        return view;
    }

    private void buscarTractoraCisterna(String tractora, String cisterna){
        taccamiViewModel.findTaccamiByTCMat("%" + tractora + "%", "%" + cisterna + "%").observe(getActivity(), new Observer<List<TaccamiEntity>>() {
            @Override
            public void onChanged(List<TaccamiEntity> taccamiEntities) {
                taccamiList4 = taccamiEntities;
            }
        });
    }

    private void lanzarViewModel() {
        tacprcoViewModel = ViewModelProviders.of(getActivity()).get(TacprcoViewModel.class);
        tacsecoViewModel = ViewModelProviders.of(getActivity()).get(TacsecoViewModel.class);
        taccamiViewModel = ViewModelProviders.of(getActivity()).get(TaccamiViewModel.class);
        taccatrViewModel = ViewModelProviders.of(getActivity()).get(TaccatrViewModel.class);
        taccondViewModel = ViewModelProviders.of(getActivity()).get(TaccondViewModel.class);
        tplcprtViewModel = ViewModelProviders.of(getActivity()).get(TplcprtViewModel.class);
    }

    private void UnSegundo(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){}
    }

    private class BuscarAsyncTask extends AsyncTask<Void, Integer, Boolean>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setMax(100);
            progressBar.setProgress(0);
            buscarTractoraCisterna(primer,segundo);
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
            for(int i=1;i<=2;i++){
                UnSegundo();
                publishProgress(i*50);
                if(isCancelled()){
                    break;
                }
            }

            if(taccamiList4.size()>0) {
                for (int i = 0; i < taccamiList4.size(); i++) {
                    matT.add(taccamiList4.get(i).getTractora());
                    if (taccamiList4.get(i).getCisterna().isEmpty()) {
                        matC.add("-");
                    } else {
                        matC.add(taccamiList4.get(i).getCisterna());
                    }
                    Log.d("matT", matT.get(matT.size() - 1));
                    Log.d("matC", matC.get(matC.size() - 1));
                    bloqueadoTractoras.add(1);
                    bloqueadoCisternas.add(1);
                }

            }else{
                Toast.makeText(getActivity(), "Sin datos sobre ese vehículo", Toast.LENGTH_SHORT).show();
            }

            return true;
        }



        @Override
        protected void onPostExecute(Boolean resultado) {

            if(resultado) {
                progressBar.setVisibility(View.GONE);
                mAdapter = new VehiculosAdapter(matT, matC, bloqueadoTractoras, bloqueadoCisternas, R.layout.listview_resultado_buscar_vehiculos, new VehiculosAdapter.OnItemClickListener() {

                    @Override
                    public void onItemClick(String matT, String matC, int bloqueoTractora, int bloqueoCisterna, int position) {
                        Intent intent = new Intent();
                        intent.putExtra("tractora", matT);
                        intent.putExtra("cisterna", matC);
                        intent.setClass(getContext(), ResultadoBuscarVehiculoActivity.class);
                        startActivity(intent);
                    }
                });

                mRecyclerView.setLayoutManager(mLayoutManager);
                mRecyclerView.setAdapter(mAdapter);
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0].intValue());
        }

        @Override
        protected void onCancelled(){
            super.onCancelled();

        }
    }
}
