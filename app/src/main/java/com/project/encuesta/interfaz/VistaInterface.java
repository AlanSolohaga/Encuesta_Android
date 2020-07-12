package com.project.encuesta.interfaz;

import com.project.encuesta.model.TipoEncuesta;

import java.util.ArrayList;

public interface VistaInterface {
    void mostrarTipoEncuestas(ArrayList<TipoEncuesta> tipoEncuestas);
    void errorMostrarTipoEncuestas(String error);
}
