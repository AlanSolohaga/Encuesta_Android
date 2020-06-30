package com.project.encuesta.interfaz;

import com.project.encuesta.model.Pregunta;

import java.io.File;
import java.util.ArrayList;

public interface PresentInterface {
    void arrayPregunta(String pregunta);
    void agregarPreguntas(String imagen);
    void mostrarPregunta(String pregunta);

    ArrayList<Pregunta> mostrarArray();


    void buscarImagen(File archivo);
    void mostrarImagen(byte[] imagen);
}
