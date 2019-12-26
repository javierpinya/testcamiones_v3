package com.javierpinya.testcamiones_v3.ui.ResultadoBuscarVehiculo;


import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.javierpinya.testcamiones_v3.AppDatabase;
import com.javierpinya.testcamiones_v3.Clases.TacsecoEntity;
import com.javierpinya.testcamiones_v3.Clases.TplcprtEntity;
import com.javierpinya.testcamiones_v3.R;
import com.javierpinya.testcamiones_v3.ViewModels.TacsecoViewModel;
import com.javierpinya.testcamiones_v3.ViewModels.TplcprtViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResultadoBuscarCisternaFragment extends Fragment {

    private String cisterna;
    private TacsecoEntity tacsecoEntity;
    private TplcprtEntity tplcprtEntity;
    //private BuscarAsyncTask buscarAsyncTask;


    public ResultadoBuscarCisternaFragment(String cisterna) {
        // Required empty public constructor
        this.cisterna = cisterna;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_resultado_buscar_cisterna, container, false);



        return view;
    }

    private class BuscarAsyncTask extends AsyncTask<Void, Integer, TacsecoEntity> {

        @Override
        protected TacsecoEntity doInBackground(Void... voids) {
            tacsecoEntity = AppDatabase.getDatabase(getActivity()).tacsecoDao().findTacsecoByOneMatricula(cisterna);
            tplcprtEntity = AppDatabase.getDatabase(getActivity()).tplcprtDao().findTplcprtByMatricula(cisterna);
            return tacsecoEntity;
        }


        @Override
        protected void onPostExecute(TacsecoEntity tacsecoEntity) {
            /*

                matricula.setText(tacsecoEntity.getMatricula());
                tipo.setText(tacsecoEntity.getTipo());
                chip.setText(tacsecoEntity.getChip());
                adr.setText(tacsecoEntity.getFec_cadu_adr().toString());
                itv.setText(tacsecoEntity.getFec_cadu_itv().toString());
                tara.setText(tacsecoEntity.getTara());
                mma.setText(tacsecoEntity.getPeso_maximo());
                transresp.setText("-");
                bloqueado.setText(String.valueOf(tacsecoEntity.getInd_bloqueo()));

             */

        }
    }
}
