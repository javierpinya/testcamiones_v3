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

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.javierpinya.testcamiones_v3.Adapters.CompartimentosAdapter;
import com.javierpinya.testcamiones_v3.AppDatabase;
import com.javierpinya.testcamiones_v3.Clases.TacsecoEntity;
import com.javierpinya.testcamiones_v3.Clases.TplcprtEntity;
import com.javierpinya.testcamiones_v3.CompartimentosActivity;
import com.javierpinya.testcamiones_v3.LoginActivity;
import com.javierpinya.testcamiones_v3.R;
import com.javierpinya.testcamiones_v3.ViewModels.TplcprtViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultadoBuscarCisternaFragment extends Fragment {

    private String cisterna;
    private TacsecoEntity tacsecoEntity;
    private TextView matricula,tipo,chip,adr,itv,ejes,tara,mma,contador,tablacal,sologas,pesados,bloqueada;
    private Button compartimentos;
    private BuscarTacsecoAsyncTask buscarTacsecoAsyncTask;


    public ResultadoBuscarCisternaFragment(String cisterna) {
        // Required empty public constructor
        this.cisterna = cisterna;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_resultado_buscar_cisterna, container, false);
        matricula = view.findViewById(R.id.tv_cisternamatricula);
        tipo = view.findViewById(R.id.tv_tipocisterna1);
        chip = view.findViewById(R.id.tv_chipcisterna1);
        adr = view.findViewById(R.id.tv_adrcisterna1);
        itv = view.findViewById(R.id.tv_itvcisterna1);
        ejes = view.findViewById(R.id.tv_ejescisterna1);
        tara = view.findViewById(R.id.tv_taracisterna1);
        mma = view.findViewById(R.id.tv_mmacisterna1);
        contador = view.findViewById(R.id.tv_contadorcisterna1);
        tablacal = view.findViewById(R.id.tv_tablacalcisterna1);
        sologas = view.findViewById(R.id.tv_sologasoleoscisterna1);
        pesados = view.findViewById(R.id.tv_cargapesadoscisterna1);
        bloqueada = view.findViewById(R.id.tv_Bloqueadacisterna1);
        compartimentos = view.findViewById(R.id.tv_compartimentos);
        buscarTacsecoAsyncTask = new BuscarTacsecoAsyncTask();
        buscarTacsecoAsyncTask.execute();

        compartimentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("cisterna", cisterna);
                intent.setClass(getContext(), CompartimentosActivity.class);
                startActivity(intent);
            }
        });



        return view;
    }

    private class BuscarTacsecoAsyncTask extends AsyncTask<Void, Integer, TacsecoEntity> {

        @Override
        protected TacsecoEntity doInBackground(Void... voids) {
            tacsecoEntity = AppDatabase.getDatabase(getActivity()).tacsecoDao().findTacsecoByOneMatricula(cisterna);
            return tacsecoEntity;
        }


        @Override
        protected void onPostExecute(TacsecoEntity tacsecoEntity) {

                matricula.setText(tacsecoEntity.getMatricula());
                tipo.setText(tacsecoEntity.getTipo());
                chip.setText(String.valueOf(tacsecoEntity.getChip()));
                adr.setText(tacsecoEntity.getFec_cadu_adr().toString());
                itv.setText(tacsecoEntity.getFec_cadu_itv().toString());
                tara.setText(String.valueOf(tacsecoEntity.getTara()));
                mma.setText(String.valueOf(tacsecoEntity.getPeso_maximo()));
                bloqueada.setText(String.valueOf(tacsecoEntity.getInd_bloqueo()));
                tablacal.setText(tacsecoEntity.getFec_cadu_calibracion().toString());
                sologas.setText(String.valueOf(tacsecoEntity.getInd_bloqueo()));
                pesados.setText(String.valueOf(tacsecoEntity.isInd_carga_pesados()));
        }
    }



}
