package com.javierpinya.testcamiones_v3.ui.ResultadoBuscarVehiculo;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.javierpinya.testcamiones_v3.AppDatabase;
import com.javierpinya.testcamiones_v3.Clases.TacprcoEntity;
import com.javierpinya.testcamiones_v3.R;
import com.javierpinya.testcamiones_v3.ViewModels.TaccondViewModel;
import com.javierpinya.testcamiones_v3.ViewModels.TacprcoViewModel;
import com.javierpinya.testcamiones_v3.ViewModels.TacsecoViewModel;
import com.javierpinya.testcamiones_v3.ViewModels.TplcprtViewModel;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ResultadoBuscarTractoraFragment extends Fragment {

    private String tractora;
    private TacprcoEntity tacprcoEntity;
    private BuscarAsyncTask buscarAsyncTask;
    private TextView matricula, tipo,chip,adr,itv,tara,mma,sologas,transresp,queroseno,bloqueado;


    public ResultadoBuscarTractoraFragment(String tractora) {
        // Required empty public constructor
        this.tractora = tractora;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_resultado_buscar_tractora, container, false);
        matricula = view.findViewById(R.id.tv_tractoramatricula);
        tipo = view.findViewById(R.id.tv_tipotractora1);
        chip = view.findViewById(R.id.tv_chiptractora1);
        adr = view.findViewById(R.id.tv_adrtractora1);
        itv = view.findViewById(R.id.tv_itvtractora1);
        tara = view.findViewById(R.id.tv_taratractora1);
        mma = view.findViewById(R.id.tv_mmatractora1);
        sologas = view.findViewById(R.id.tv_sologasoleostractora1);
        transresp = view.findViewById(R.id.tv_transportistaresp1);
        queroseno = view.findViewById(R.id.tv_querosenos1);
        bloqueado = view.findViewById(R.id.tv_Bloqueadotractora1);
        buscarAsyncTask = new BuscarAsyncTask();
        buscarAsyncTask.execute();

        return view;
    }

    private class BuscarAsyncTask extends AsyncTask<Void, Integer, TacprcoEntity> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected TacprcoEntity doInBackground(Void... voids) {
            tacprcoEntity = AppDatabase.getDatabase(getActivity()).tacprcoDao().findTacprcoByOneMatricula(tractora);
            return tacprcoEntity;
        }

        @Override
        protected void onPostExecute(TacprcoEntity tacprco) {
                matricula.setText(tacprco.getMatricula());
                tipo.setText(tacprco.getTipo());
                chip.setText(String.valueOf(tacprco.getChip()));
                adr.setText(tacprco.getFec_cadu_adr().toString());
                itv.setText(tacprco.getFec_cadu_itv().toString());
                tara.setText(String.valueOf(tacprco.getTara()));
                mma.setText(String.valueOf(tacprco.getPeso_maximo()));
                transresp.setText("-");
                sologas.setText(String.valueOf(tacprco.isSolo_gasoleos()));
                queroseno.setText(String.valueOf(tacprco.isInd_queroseno()));
                bloqueado.setText(String.valueOf(tacprco.isInd_bloqueo()));
        }
    }

}
