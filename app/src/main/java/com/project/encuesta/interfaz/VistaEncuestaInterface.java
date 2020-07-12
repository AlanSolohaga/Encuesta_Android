package com.project.encuesta.interfaz;

import com.project.encuesta.model.Imagen;
import com.project.encuesta.model.Opcion;

import java.util.ArrayList;

public interface VistaEncuestaInterface {
    void mostrarOpciones(ArrayList<Opcion> opciones);
    void mostrarError(String error);
    void mostrarImagen(Imagen imagen);
}
