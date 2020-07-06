package com.project.encuesta.adaptador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.encuesta.R;
import com.project.encuesta.model.Pregunta;
import com.project.encuesta.model.TipoEncuesta;

import java.util.ArrayList;

public class AdaptadorTipoEncuesta extends RecyclerView.Adapter<AdaptadorTipoEncuesta.ViewHolderPreguntas>
        implements View.OnClickListener{

    View.OnClickListener listener;

    ArrayList<TipoEncuesta> tipoEncuestas;

    public AdaptadorTipoEncuesta(ArrayList<TipoEncuesta> tipoEncuestas) {
        this.tipoEncuestas = tipoEncuestas;
    }

    @NonNull
    @Override
    public ViewHolderPreguntas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_lista_preguntas,null,false);

        view.setOnClickListener(this);
        return new ViewHolderPreguntas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPreguntas holder, int position) {
        holder.txtPregunta.setText(""+tipoEncuestas.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return tipoEncuestas.size();
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

    public class ViewHolderPreguntas extends RecyclerView.ViewHolder {
        TextView txtPregunta;

        public ViewHolderPreguntas(@NonNull View itemView) {
            super(itemView);
            txtPregunta = itemView.findViewById(R.id.txtPregunta);
        }
    }
}
