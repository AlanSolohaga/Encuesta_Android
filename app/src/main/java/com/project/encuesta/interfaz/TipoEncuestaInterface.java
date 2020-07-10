package com.project.encuesta.interfaz;

import android.content.Context;

import com.project.encuesta.model.Encuesta;
import com.project.encuesta.model.Opcion;

import java.util.ArrayList;

public interface TipoEncuestaInterface {
    void listarTipoEncuesta(Context context);
    ArrayList<Opcion> obtenerOpciones(ArrayList<Opcion> opciones);
    public void cargarEncuesta(int id);


}
