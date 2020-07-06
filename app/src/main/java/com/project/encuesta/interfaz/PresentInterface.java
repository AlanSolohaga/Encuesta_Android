package com.project.encuesta.interfaz;

import android.content.Context;

import com.project.encuesta.model.Pregunta;
import com.project.encuesta.model.TipoEncuesta;

import java.io.File;
import java.util.ArrayList;

public interface PresentInterface {
    /**CREAR ENCUESTA INTERFACE**/
    void arrayPregunta(String pregunta);
    void agregarPreguntas(String imagen);
    ArrayList<Pregunta> mostrarArray();

    /**BUSCAR IMAGEN INTERFACE**/
    void buscarImagen(File archivo);


    /**VISTA INTERFACE**/
    void mostrarPregunta(String pregunta);
    void mostrarImagen(byte[] imagen);
    void mostrarTipoEncuestas(ArrayList<TipoEncuesta> tipoEncuestas);
    void errorMostrarTipoEncuestas(String error);

    /**TIPO DE ENCUESTA INTERFACE**/
    void listarTipoEncuesta(Context context);
}
