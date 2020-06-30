package com.project.encuesta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.project.encuesta.interfaz.PresentInterface;
import com.project.encuesta.interfaz.VistaInterface;
import com.project.encuesta.presentador.Presentador;

public class MainActivity extends AppCompatActivity {
/*
    private PresentInterface presentador;

    EditText editImagen, editPregunta;
    Button btnAgregar,btnFinalizar;
    TextView txtPreguntaX;
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


  /*
        presentador = new Presentador(this);

        editImagen = findViewById(R.id.editImagen);
        editPregunta = findViewById(R.id.editPregunta);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnFinalizar = findViewById(R.id.btnFinalizar);
        txtPreguntaX = findViewById(R.id.textPrguntaX);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presentador.arrayPregunta(editPregunta.getText().toString());
                editPregunta.setText("");
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presentador.agregarPreguntas(editImagen.getText().toString());
            }
        });
*/
    }
/*
    @Override
    public void mostrarPregunta(String pregunta) {
        txtPreguntaX.setText(pregunta);
    }

    @Override
    public void mostrarImagen(byte[] imagen) {

    }

 */
}
