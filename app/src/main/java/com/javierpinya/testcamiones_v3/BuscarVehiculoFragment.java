package com.javierpinya.testcamiones_v3;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.javierpinya.testcamiones_v3.Adapters.VehiculosAdapter;
import com.javierpinya.testcamiones_v3.Clases.TaccamiEntity;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BuscarVehiculoFragment extends Fragment {
    private EditText primerComp;
    private EditText segundoComp;
    private Button buscar;
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

                primer = primerComp.getText().toString().trim();
                segundo = segundoComp.getText().toString().trim();
                if (primer.isEmpty() && segundo.isEmpty()){
                    Toast.makeText(getActivity(), "Introduzca una matrícula", Toast.LENGTH_SHORT).show();
                }else {
                    /*
                    if (!primer.isEmpty()) {
                        buscarTractora(primer);
                    }
                    if (!segundo.isEmpty()) {
                        buscarCisterna(segundo);
                    }

                    if (taccamiList1.size() > 0) {
                        for (int i = 0; i < taccamiList1.size(); i++) {
                            vehiculoT.add(taccamiList1.get(i).getCod_vehiculo());
                        }
                    }
                    if (taccamiList2.size() > 0) {
                        for (int i = 0; i < taccamiList2.size(); i++) {
                            vehiculoC.add(taccamiList2.get(i).getCod_vehiculo());
                        }
                    }



                    if (vehiculoT.size() <= 0 && vehiculoC.size() <= 0) {
                        Toast.makeText(getActivity(), "Sin datos sobre ese vehículo", Toast.LENGTH_SHORT).show();
                    } else {
                        if (vehiculoT.size() > 0){
                            if(vehiculoC.size() > 0){
                                vehiculo = new ArrayList<>(compararCodVehiculo(vehiculoT, vehiculoC));
                            }else{
                                vehiculo.addAll(vehiculoT);
                            }
                        }else{
                            vehiculo.addAll(vehiculoC);
                        }
                        buscaConjuntos(vehiculo);
                        for (int i = 0; i < taccamiList3.size(); i++) {
                            matT.add(taccamiList3.get(i).getTractora());
                            if (taccamiList3.get(i).getCisterna().isEmpty()) {
                                matC.add("-");
                            } else {
                                matC.add(taccamiList3.get(i).getCisterna());
                            }
                            Log.d("matT", matT.get(matT.size()-1));
                            Log.d("matC", matC.get(matC.size()-1));
                            bloqueadoTractoras.add(1);
                            bloqueadoCisternas.add(1);
                        }
                     */

                        buscarTractoraCisterna(primer,segundo);
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


                            mAdapter = new VehiculosAdapter(matT, matC, bloqueadoTractoras, bloqueadoCisternas, R.layout.listview_resultado_buscar_vehiculos, new VehiculosAdapter.OnItemClickListener() {

                                @Override
                                public void onItemClick(String matT, String matC, int bloqueoTractora, int bloqueoCisterna, int position) {
                                    Toast.makeText(getActivity(), matT + " - " + matC + " - " + position, Toast.LENGTH_SHORT).show();
                                }
                            });

                            mRecyclerView.setLayoutManager(mLayoutManager);
                            mRecyclerView.setAdapter(mAdapter);
                        }else{
                            Toast.makeText(getActivity(), "Sin datos sobre ese vehículo", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

        });

        return view;
    }

    private void buscarTractora(String matricula){
        taccamiViewModel.findTaccamiByTMatricula("%" + matricula + "%").observe(getActivity(), new Observer<List<TaccamiEntity>>() {
            @Override
            public void onChanged(List<TaccamiEntity> taccamiEntities) {
                taccamiList1 = taccamiEntities;
            }
        });
    }

    private void buscarCisterna(String matricula){

        taccamiViewModel.findTaccamiByCMatricula("%" + matricula + "%").observe(getActivity(), new Observer<List<TaccamiEntity>>() {
            @Override
            public void onChanged(List<TaccamiEntity> taccamiEntities) {
                taccamiList2 = taccamiEntities;
            }
        });
    }

    private void buscarTractoraCisterna(String tractora, String cisterna){
        taccamiViewModel.findTaccamiByTCMat("%" + tractora + "%", "%" + cisterna + "%").observe(getActivity(), new Observer<List<TaccamiEntity>>() {
            @Override
            public void onChanged(List<TaccamiEntity> taccamiEntities) {
                taccamiList4 = taccamiEntities;
            }
        });
    }

    private List<Integer> compararCodVehiculo(List<Integer> vehiculo1, List<Integer> vehiculo2){
        final List<Integer> cod_vehiculo = new ArrayList<>();

        for(int i=0; i<vehiculo1.size();i++){
            for(int j=0;j<vehiculo2.size();j++){
                if(vehiculo1.get(i).equals(vehiculo2.get(j))){
                    cod_vehiculo.add(vehiculo1.get(i));
                }
            }
        }

        return cod_vehiculo;
    }

    private void buscaConjuntos(List<Integer> vehiculo){
        for(int i=0;i<vehiculo.size();i++) {
            taccamiList3.add(taccamiViewModel.findTaccamiByCodVehiculo(vehiculo.get(i)));
        }
    }


    private void lanzarViewModel() {
        tacprcoViewModel = ViewModelProviders.of(getActivity()).get(TacprcoViewModel.class);
        tacsecoViewModel = ViewModelProviders.of(getActivity()).get(TacsecoViewModel.class);
        taccamiViewModel = ViewModelProviders.of(getActivity()).get(TaccamiViewModel.class);
        taccatrViewModel = ViewModelProviders.of(getActivity()).get(TaccatrViewModel.class);
        taccondViewModel = ViewModelProviders.of(getActivity()).get(TaccondViewModel.class);
        tplcprtViewModel = ViewModelProviders.of(getActivity()).get(TplcprtViewModel.class);
    }

}
