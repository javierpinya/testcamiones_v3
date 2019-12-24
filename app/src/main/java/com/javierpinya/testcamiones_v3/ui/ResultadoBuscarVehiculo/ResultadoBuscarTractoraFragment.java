package com.javierpinya.testcamiones_v3.ui.ResultadoBuscarVehiculo;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.javierpinya.testcamiones_v3.R;
import com.javierpinya.testcamiones_v3.ViewModels.TaccondViewModel;
import com.javierpinya.testcamiones_v3.ViewModels.TacprcoViewModel;
import com.javierpinya.testcamiones_v3.ViewModels.TacsecoViewModel;
import com.javierpinya.testcamiones_v3.ViewModels.TplcprtViewModel;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResultadoBuscarTractoraFragment extends Fragment {

    private TacprcoViewModel tacprcoViewModel;
    private TacsecoViewModel tacsecoViewModel;
    private TplcprtViewModel tplcprtViewModel;
    private TaccondViewModel taccondViewModel;




    public ResultadoBuscarTractoraFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resultado_buscar_tractora, container, false);
    }

    private void lanzarViewModel(){
        //Esto hay que hacerlo sí o sí desde un fragment, así que no queda más remedio que hacer la búsqueda directamente desde aquí.
        tacprcoViewModel = ViewModelProviders.of(getActivity()).get(TacprcoViewModel.class);
        tacsecoViewModel = ViewModelProviders.of(getActivity()).get(TacsecoViewModel.class);
    }

    private void buscarDatosTractora(String tractora){
        //Seguimos aquí
    }

}
