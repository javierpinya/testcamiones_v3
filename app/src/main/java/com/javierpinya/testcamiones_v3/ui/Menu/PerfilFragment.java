package com.javierpinya.testcamiones_v3.ui.Menu;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.javierpinya.testcamiones_v3.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private String matT;
    private TextView tvPuesto;


    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        matT = getArguments().getString("tractora");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        tvPuesto = view.findViewById(R.id.profileActivityTvPuesto);
        //tvPuesto.setText(matT);

        return view;
    }

}
