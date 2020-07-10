package com.project.encuesta.vista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.project.encuesta.R;
import com.project.encuesta.adaptador.AdaptadorEncuesta;
import com.project.encuesta.interfaz.PresentadorEncuestaInterface;
import com.project.encuesta.interfaz.VistaEncuestaInterface;
import com.project.encuesta.model.Opcion;
import com.project.encuesta.presentador.PresentadorEncuesta;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EncuestaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EncuestaFragment extends Fragment implements VistaEncuestaInterface {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private PresentadorEncuestaInterface presentador;
    public EncuestaFragment() {
        // Required empty public constructor
        this.presentador = new PresentadorEncuesta(this);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EncuestaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EncuestaFragment newInstance(String param1, String param2) {
        EncuestaFragment fragment = new EncuestaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    View view;
    TextView txtpregunta;
    RecyclerView recycleropciones;
    AdaptadorEncuesta adaptador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_encuesta, container, false);
        txtpregunta = view.findViewById(R.id.pregunta);
        recycleropciones = view.findViewById(R.id.recyclerOpciones);
        recycleropciones.setLayoutManager(new LinearLayoutManager(view.getContext()));

        Bundle objRecibido = getArguments();
        int id = objRecibido.getInt("id");
        String pregunta = objRecibido.getString("pregunta");
        txtpregunta.setText(pregunta);

        presentador.listarOpcion(id,getContext());

        return view;
    }

    @Override
    public void mostrarOpciones(ArrayList<Opcion> opciones) {
        adaptador = new AdaptadorEncuesta(opciones);
        recycleropciones.setAdapter(adaptador);

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "SELECCIONAR", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void mostrarError(String error) {

    }
}
