package com.javierpinya.testcamiones_v3;


import android.os.Bundle;
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

import com.javierpinya.testcamiones_v3.Adapters.ListaBuscarVehiculoRecyclerViewAdapter;
import com.javierpinya.testcamiones_v3.Adapters.VehiculosAdapter;
import com.javierpinya.testcamiones_v3.Clases.TaccamiEntity;
import com.javierpinya.testcamiones_v3.Clases.TaccondEntity;
import com.javierpinya.testcamiones_v3.Clases.TacprcoEntity;
import com.javierpinya.testcamiones_v3.Clases.TacsecoEntity;

import java.lang.reflect.Array;
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
    private List<TaccamiEntity> taccamiList = new ArrayList<>();

    final List<Integer> cod_vehiculo1 = new ArrayList<>();
    final List<Integer> cod_vehiculo2 = new ArrayList<>();
    final List<Integer> listaEquivalente = new ArrayList<>();
    final List<String> tractoras = new ArrayList<>();
    final List<String> cisternas = new ArrayList<>();

    private List<Integer> bloqueadoTractoras = new ArrayList<>();
    private List<Integer> bloqueadoCisternas = new ArrayList<>();

    private List<String> matT = new ArrayList<>();
    private List<String> matC = new ArrayList<>();


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
                primer = primerComp.getText().toString();
                segundo = segundoComp.getText().toString();
                if (primer.isEmpty() && segundo.isEmpty()){
                    Toast.makeText(getActivity(), "Introduzca una matrícula", Toast.LENGTH_SHORT).show();
                }else{

                    buscarComponentes(primer.trim(), segundo.trim());
                    /*
                    mAdapter = new VehiculosAdapter(matT, matC, bloqueadoTractoras, bloqueadoCisternas, R.layout.listview_resultado_buscar_vehiculos, new VehiculosAdapter.OnItemClickListener(){

                        @Override
                        public void onItemClick(String matT, String matC, int bloqueoTractora, int bloqueoCisterna, int position) {
                            Toast.makeText(getActivity(), matT + " - " + matC + " - " + position, Toast.LENGTH_SHORT).show();
                        }
                    });

                    mRecyclerView.setLayoutManager(mLayoutManager);
                    mRecyclerView.setAdapter(mAdapter);

                     */
                }
            }
        });

        return view;
    }


    private void buscarComponentes(String primer, String segundo) {
        cod_vehiculo1.clear();
        cod_vehiculo2.clear();
        listaEquivalente.clear();
        bloqueadoCisternas.clear();
        bloqueadoTractoras.clear();

        if (primer.length()>0) {

            taccamiViewModel.findTaccamiByTMatricula(primer).observe(getActivity(), new Observer<List<TaccamiEntity>>() {
                @Override
                public void onChanged(List<TaccamiEntity> taccamiEntities) {
                    for (int i = 0; i < taccamiEntities.size(); i++) {
                        cod_vehiculo1.add(taccamiEntities.get(i).getCod_vehiculo());
                    }
                }
            });
        }
        if(segundo.length()>0){
            taccamiViewModel.findTaccamiByCMatricula(segundo).observe(getActivity(), new Observer<List<TaccamiEntity>>() {
                @Override
                public void onChanged(List<TaccamiEntity> taccamiEntities) {
                    for(int i=0;i<taccamiEntities.size();i++) {
                        cod_vehiculo2.add(taccamiEntities.get(i).getCod_vehiculo());
                    }
                }
            });
        }

        if(cod_vehiculo1.size()>0 && cod_vehiculo2.size()>0){
            for(int i=0;i<cod_vehiculo1.size();i++){
                for(int j=0;j<cod_vehiculo2.size();j++){
                    if (cod_vehiculo1.get(i) == cod_vehiculo2.get(j)){
                        listaEquivalente.add(cod_vehiculo1.get(i));
                    }
                }
            }
        }else{
            for(int i=0;i<cod_vehiculo1.size();i++){
                listaEquivalente.add(cod_vehiculo1.get(i));
            }
            for(int i=0;i<cod_vehiculo2.size();i++){
                listaEquivalente.add(cod_vehiculo2.get(i));
            }
        }

        for(int i=0;i<listaEquivalente.size();i++) {
            taccamiViewModel.findTaccamiByCodVehiculo(listaEquivalente.get(i)).observe(getActivity(), new Observer<List<TaccamiEntity>>() {
                @Override
                public void onChanged(List<TaccamiEntity> taccamiEntities) {
                    tractoras.add(taccamiEntities.get(0).getTractora());
                    if (taccamiEntities.get(0).getCisterna() == null){
                        cisternas.add("-");
                    }else{
                        cisternas.add(taccamiEntities.get(0).getCisterna());  //En el caso de los rígidos, esta consulta devolvería null.
                    }
                }
            });
        }

        for(int i=0;i<listaEquivalente.size();i++){

            if(cisternas.get(i)=="-"){
                bloqueadoCisternas.add(0); //nulo
                matC.add("-");
            }else{
                matC.add(cisternas.get(i));
                tacsecoViewModel.findTacsecoByMatricula(cisternas.get(i)).observe(getActivity(), new Observer<List<TacsecoEntity>>() {
                    @Override
                    public void onChanged(List<TacsecoEntity> tacsecoEntities) {
                        if (tacsecoEntities.get(0).getInd_bloqueo()){
                            bloqueadoCisternas.add(1);  //bloqueado
                        }else{
                            bloqueadoCisternas.add(2);  //no bloqueado
                        }
                    }
                });
            }
            tacprcoViewModel.findTacprcoByMatricula(tractoras.get(i)).observe(getActivity(), new Observer<List<TacprcoEntity>>() {
                @Override
                public void onChanged(List<TacprcoEntity> tacprcoEntities) {
                    if (tacprcoEntities.get(0).isInd_bloqueo()){
                        bloqueadoTractoras.add(1);  //bloqueado
                    }else{
                        bloqueadoTractoras.add(2);
                    }
                }
            });
            matT.add(tractoras.get(i));
            Toast.makeText(getActivity(), "matT: " + matT.get(0), Toast.LENGTH_SHORT).show();
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
