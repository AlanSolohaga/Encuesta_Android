package com.project.encuesta.interfaz;

import com.project.encuesta.model.TipoEncuesta;

import java.util.ArrayList;

public interface VistaInterface {
    void mostrarPregunta(String pregunta);
    void mostrarImagen(byte[] imagen);

    void mostrarTipoEncuestas(ArrayList<TipoEncuesta> tipoEncuestas);
    void errorMostrarTipoEncuestas(String error);
}
