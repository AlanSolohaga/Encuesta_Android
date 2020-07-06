package com.project.encuesta.vista;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.project.encuesta.R;
import com.project.encuesta.adaptador.AdaptadorTipoEncuesta;
import com.project.encuesta.interfaz.PresentInterface;
import com.project.encuesta.interfaz.VistaInterface;
import com.project.encuesta.model.TipoEncuesta;
import com.project.encuesta.presentador.Presentador;

import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class MenuFragment extends Fragment implements VistaInterface {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    PresentInterface presentador;

    public MenuFragment() {
        // Required empty public constructor
        presentador = new Presentador(this);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuFragment newInstance(String param1, String param2) {
        MenuFragment fragment = new MenuFragment();
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



    RecyclerView recyclerPreguntas;
    AdaptadorTipoEncuesta adaptador;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        recyclerPreguntas = view.findViewById(R.id.recyclerPreguntas);
        recyclerPreguntas.setLayoutManager(new LinearLayoutManager(view.getContext()));

        //NECESITO UN ARRAY PARA PASAR AL ADAPTADOR

        /*final AdaptadorTipoEncuesta adaptador = new AdaptadorTipoEncuesta(presentador.mostrarArray());
        */
        /*
        ArrayList<TipoEncuesta> tipoEncuestas = new ArrayList<>();
        TipoEncuesta tipoEncuesta1 = new TipoEncuesta("Personajes de Mafalda",
                "¿Qué personaje está viendo?");
        TipoEncuesta tipoEncuesta2 = new TipoEncuesta("Sentimientos de Mafalda",
                "¿Qué sentimientos expresa?");
        TipoEncuesta tipoEncuesta3 = new TipoEncuesta("¿Qué dice la oración?",
                "¿Qué dice la oración?");
        tipoEncuestas.add(tipoEncuesta1);
        tipoEncuestas.add(tipoEncuesta2);
        tipoEncuestas.add(tipoEncuesta3);

        AdaptadorTipoEncuesta adaptador = new AdaptadorTipoEncuesta(tipoEncuestas);
        recyclerPreguntas.setAdapter(adaptador);

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"MOSTRAR FRAGMENT DE LA ENCUESTA SELEC",Toast.LENGTH_LONG).show();
            }
        });
        */

        presentador.listarTipoEncuesta(getContext());

        return view;
    }

    @Override
    public void mostrarPregunta(String pregunta) {
    }

    @Override
    public void mostrarImagen(byte[] imagen) {

    }

    @Override
    public void mostrarTipoEncuestas(ArrayList<TipoEncuesta> tipoEncuestas) {
        //Creo el adaptador, le paso el array que traigo y lo cargo en el recycler
        adaptador = new AdaptadorTipoEncuesta(tipoEncuestas);
        recyclerPreguntas.setAdapter(adaptador);

        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /** DIRECCIONAR AL FRAGMENT DE LA ENCUESTA**/

                Toast.makeText(getContext(),"Enviar al fragment correspondiente",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void errorMostrarTipoEncuestas(String error) {
        Toast.makeText(getContext(),""+error,Toast.LENGTH_LONG).show();
    }
}
