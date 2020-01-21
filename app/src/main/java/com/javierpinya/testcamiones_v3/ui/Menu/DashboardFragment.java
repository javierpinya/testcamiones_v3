package com.javierpinya.testcamiones_v3.ui.Menu;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.javierpinya.testcamiones_v3.BuscarInspeccionActivity;
import com.javierpinya.testcamiones_v3.BuscarVehiculoActivity;
import com.javierpinya.testcamiones_v3.NuevaInspeccionActivity;
import com.javierpinya.testcamiones_v3.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardFragment extends Fragment{

    private ImageButton buscarCamion;
    private ImageButton buscarInspeccion;
    private ImageButton nuevaInspeccion;
    private ImageButton calculadora;
    private ImageView oleoducto;


    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        buscarCamion = view.findViewById(R.id.imageBuscarCamion);
        buscarInspeccion = view.findViewById(R.id.imageBuscarInspeccion);
        nuevaInspeccion = view.findViewById(R.id.imageNuevaInspeccion);
        calculadora = view.findViewById(R.id.imageCalculadora);
        oleoducto = view.findViewById(R.id.imageViewOleo);


        buscarCamion.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), BuscarVehiculoActivity.class);
                startActivity(intent);
            }
        });

        buscarInspeccion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), BuscarInspeccionActivity.class);
                startActivity(intent);
            }
        });

        nuevaInspeccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getContext(), NuevaInspeccionActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

}
