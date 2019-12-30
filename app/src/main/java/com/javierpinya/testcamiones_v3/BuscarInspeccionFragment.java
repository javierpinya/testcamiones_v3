package com.javierpinya.testcamiones_v3;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.javierpinya.testcamiones_v3.ViewModels.TaccamiViewModel;
import com.javierpinya.testcamiones_v3.ViewModels.TaccatrViewModel;
import com.javierpinya.testcamiones_v3.ViewModels.TaccondViewModel;
import com.javierpinya.testcamiones_v3.ViewModels.TacprcoViewModel;
import com.javierpinya.testcamiones_v3.ViewModels.TacsecoViewModel;
import com.javierpinya.testcamiones_v3.ViewModels.TplcprtViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class BuscarInspeccionFragment extends Fragment {

    private EditText conductor,inspector,ia,tractora,cisterna;
    private Button btnBuscarInspeccion;
    private ProgressBar progressBar;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private String cond,insp,instalacion,primercomp, segundocomp;




    public BuscarInspeccionFragment() {
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
        View view  = inflater.inflate(R.layout.fragment_buscar_inspeccion, container, false);
        conductor = view.findViewById(R.id.etConductor);
        inspector = view.findViewById(R.id.etInspector);
        ia = view.findViewById(R.id.etInstalacion);
        tractora = view.findViewById(R.id.etPrimerComp);
        cisterna = view.findViewById(R.id.etSegundoComp);
        btnBuscarInspeccion = view.findViewById(R.id.btnBuscarInspeccion);

        lanzarViewModel();

        //RecyclerView
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rv_buscarinspeccion);
        mLayoutManager = new LinearLayoutManager(getActivity());

        btnBuscarInspeccion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(cisterna.getWindowToken(), 0);
                imm.hideSoftInputFromWindow(conductor.getWindowToken(),0);
                imm.hideSoftInputFromWindow(tractora.getWindowToken(),0);
                imm.hideSoftInputFromWindow(ia.getWindowToken(),0);
                imm.hideSoftInputFromWindow(inspector.getWindowToken(),0);

                cond = conductor.getText().toString().trim();
                insp = inspector.getText().toString().trim();
                instalacion = ia.getText().toString().trim();
                primercomp = tractora.getText().toString().trim();
                segundocomp = cisterna.getText().toString().trim();




            }
        });

        return view;
    }

    private void lanzarViewModel() {
        //InspeccionViewModel = ViewModelProviders.of(getActivity()).get(InspeccionViewModel.class);
    }


}
