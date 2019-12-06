package com.javierpinya.testcamiones_v3.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.javierpinya.testcamiones_v3.Clases.TaccamiEntity;
import com.javierpinya.testcamiones_v3.R;

import java.util.List;

public class VehiculosAdapter extends RecyclerView.Adapter<VehiculosAdapter.VehiculosAdapter_Holder>{


    private List<String> matT;
    private List<String> matC;
    private List<Integer> bloqueoTractora;
    private List<Integer> bloqueoCisterna;
    private int layout;
    private OnItemClickListener itemClickListener;

    public VehiculosAdapter(List<String> matT, List<String> matC, List<Integer> bloqueoTractora, List<Integer> bloqueoCisterna, int layout, OnItemClickListener listener){
        this.matT = matT;
        this.matC = matC;
        this.bloqueoTractora = bloqueoTractora;
        this.bloqueoCisterna = bloqueoCisterna;
        this.layout = layout;
        this.itemClickListener = listener;
    }

    @NonNull
    @Override
    public VehiculosAdapter_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent,false);
        VehiculosAdapter_Holder vh = new VehiculosAdapter_Holder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VehiculosAdapter_Holder holder, int position) {

        holder.bind(matT.get(position), matC.get(position), bloqueoTractora.get(position), bloqueoCisterna.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return matT.size();
    }

    public static class VehiculosAdapter_Holder extends RecyclerView.ViewHolder {
        public TextView tvTractora, tvCisterna;
        public ImageView ivTractora, ivCisterna, ivTractoraBloqueada, ivCisternaBloqueada, ivTractoraInspeccionada, ivCisternaInspeccionada;

        public VehiculosAdapter_Holder(@NonNull View itemView) {
            super(itemView);

            /* Esto está mal, hay que hacerlo con ViewModel...*/
            this.tvTractora = itemView.findViewById(R.id.tvTractora);
            this.tvCisterna = itemView.findViewById(R.id.tvCisterna);
            this.ivTractora = itemView.findViewById(R.id.ivTractora);
            this.ivCisterna = itemView.findViewById(R.id.ivCisterna);
            this.ivTractoraBloqueada = itemView.findViewById(R.id.ind_observaciones);
            this.ivCisternaBloqueada = itemView.findViewById(R.id.ivCisternaBloqueada);
            this.ivTractoraInspeccionada = itemView.findViewById(R.id.ivTractoraInspeccionada);
            this.ivCisternaInspeccionada = itemView.findViewById(R.id.ivCisternaInspeccionada);
        }


        public void bind(final String matT, final String matC, final int bloqueoTractora, final int bloqueoCisterna, final OnItemClickListener listener){

            this.tvTractora.setText(matT);
            this.tvCisterna.setText(matC);
            this.ivCisterna.setImageResource(R.drawable.ic_oil_tank);
            this.ivTractora.setImageResource(R.drawable.ic_frontal_truck);  //Habría que cambiarlo en el futuro, discriminando entre tractora y rígido

            /*
            if(listaVehiculoEntities.get(getAdapterPosition()).gettTipo().equals("T")){
                this.ivTractora.setImageResource(R.drawable.ic_frontal_truck);
            }else{
                this.ivTractora.setImageResource(R.drawable.ic_oil_truck);
            }

             */

            if(bloqueoCisterna==1){
                this.ivCisternaBloqueada.setImageResource(R.drawable.ic_ban);
            }else if (bloqueoCisterna==2){
                this.ivCisternaBloqueada.setImageResource(R.drawable.ic_checked);
            }else{
                this.ivCisternaBloqueada.setImageResource(View.GONE);
            }

            if(bloqueoTractora==1){
                this.ivTractoraBloqueada.setImageResource(R.drawable.ic_ban);
            }else{
                this.ivTractoraBloqueada.setImageResource(R.drawable.ic_checked);
            }
    /*
            if(){
                this.ivCisternaInspeccionada.setImageResource(R.drawable.ic_inspeccionado_true);
            }else{
                this.ivCisternaInspeccionada.setImageResource(R.drawable.ic_inspeccionado_false);
            }

            if(listaVehiculoEntities.get(getAdapterPosition()).gettInspeccionada()){
                this.ivTractoraInspeccionada.setImageResource(R.drawable.ic_inspeccionado_true);
            }else{
                this.ivTractoraInspeccionada.setImageResource(R.drawable.ic_inspeccionado_false);
            }
     */
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    listener.onItemClick(matT,matC,bloqueoTractora, bloqueoCisterna, getAdapterPosition());
                }
            });



        }
    }

    public interface OnItemClickListener{
        void onItemClick(String matT, String matC, int bloqueoTractora, int bloqueoCisterna, int position);
    }
}


