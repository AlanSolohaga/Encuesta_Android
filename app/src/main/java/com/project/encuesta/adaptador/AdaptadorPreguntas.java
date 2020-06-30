package com.project.encuesta.adaptador;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.encuesta.R;
import com.project.encuesta.model.Pregunta;

import java.util.ArrayList;

public class AdaptadorPreguntas extends RecyclerView.Adapter<AdaptadorPreguntas.ViewHolderPreguntas>
        implements View.OnClickListener{

    View.OnClickListener listener;

    ArrayList<Pregunta> preguntas;

    public AdaptadorPreguntas(ArrayList<Pregunta> preguntas) {
        this.preguntas = preguntas;
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
        holder.txtNumPregunta.setText(""+position);
        holder.txtPregunta.setText(""+preguntas.get(position).getPregunta());
    }

    @Override
    public int getItemCount() {
        return preguntas.size();
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
        TextView txtNumPregunta,txtPregunta;

        public ViewHolderPreguntas(@NonNull View itemView) {
            super(itemView);
            txtNumPregunta = itemView.findViewById(R.id.txtNumPregunta);
            txtPregunta = itemView.findViewById(R.id.txtPregunta);
        }
    }
}
