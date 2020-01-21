package com.javierpinya.testcamiones_v3.ui.NuevaInspeccion;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.javierpinya.testcamiones_v3.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ValoracionInspeccionFragment extends Fragment {


    public ValoracionInspeccionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_valoracion_inspeccion, container, false);
    }

}
