package com.project.encuesta.vista;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.encuesta.R;
import com.project.encuesta.adaptador.AdaptadorPreguntas;
import com.project.encuesta.interfaz.PresentInterface;
import com.project.encuesta.interfaz.VistaInterface;
import com.project.encuesta.model.Pregunta;
import com.project.encuesta.presentador.Presentador;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PreguntasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class PreguntasFragment extends Fragment implements VistaInterface {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    PresentInterface presentador;

    public PreguntasFragment() {
        // Required empty public constructor
        presentador = new Presentador(this);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PreguntasFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PreguntasFragment newInstance(String param1, String param2) {
        PreguntasFragment fragment = new PreguntasFragment();
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


    EditText editPregunta;
    Button btnImagen, btnAgregar,btnFinalizar;
    TextView txtPreguntaX;
    RecyclerView recyclerPreguntas;
    ImageView imagenSelec;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_preguntas, container, false);

        btnImagen = view.findViewById(R.id.btnImagen);
        editPregunta = view.findViewById(R.id.editPregunta);
        btnAgregar = view.findViewById(R.id.btnAgregar);
        btnFinalizar = view.findViewById(R.id.btnFinalizar);
        txtPreguntaX = view.findViewById(R.id.textPrguntaX);
        imagenSelec = view.findViewById(R.id.imagenSelec);

        recyclerPreguntas = view.findViewById(R.id.recyclerPreguntas);
        recyclerPreguntas.setLayoutManager(new LinearLayoutManager(view.getContext()));

        final AdaptadorPreguntas adaptador = new AdaptadorPreguntas(presentador.mostrarArray());

        btnImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarImagen();
            }
        });
        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presentador.arrayPregunta(editPregunta.getText().toString());
                recyclerPreguntas.setAdapter(adaptador);
                editPregunta.setText("");
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presentador.agregarPreguntas("imagen");
            }
        });


        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SERVIRÍA PARA ELIMINAR UNA PREGUNTA
                Toast.makeText(getContext(),"PROGRAMAR PARA BORRAR SELECCIÓN ",Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

    private void cargarImagen() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, 100);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK && requestCode == 100){
            Uri imageUri = data.getData();
            imagenSelec.setImageURI(imageUri);
        }
    }

    @Override
    public void mostrarPregunta(String pregunta) {
        txtPreguntaX.setText(pregunta);
    }

    @Override
    public void mostrarImagen(byte[] imagen) {

    }
}
