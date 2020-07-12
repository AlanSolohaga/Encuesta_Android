package com.project.encuesta.adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.encuesta.R;
import com.project.encuesta.model.Opcion;

import java.util.ArrayList;

public class AdaptadorEncuesta extends RecyclerView.Adapter<AdaptadorEncuesta.ViewHolderEncuesta>
        implements View.OnClickListener{

    View.OnClickListener listener;
    ArrayList<Opcion> opciones;

    public AdaptadorEncuesta(ArrayList<Opcion> opciones) {
        this.opciones = opciones;
    }

    @NonNull
    @Override
    public ViewHolderEncuesta onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_opciones,
                null,false);
        view.setOnClickListener(this);
        return new ViewHolderEncuesta(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderEncuesta holder, int position) {
        holder.txtOpcion.setText(opciones.get(position).getOpcion());
    }

    @Override
    public int getItemCount() {
        return opciones.size();
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }



    public class ViewHolderEncuesta extends RecyclerView.ViewHolder {
        TextView txtOpcion;
        public ViewHolderEncuesta(@NonNull View itemView) {
            super(itemView);
            txtOpcion = itemView.findViewById(R.id.txtOpcion);
        }
    }
}
