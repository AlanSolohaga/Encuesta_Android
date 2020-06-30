package com.project.encuesta.interfaz;

import com.project.encuesta.model.Pregunta;

import java.util.ArrayList;

public interface CrearEncuestaInterface {
    void arrayPregunta(String pregunta);
    void agregarPreguntas(String imagen);
    ArrayList<Pregunta> mostrarArray();
}
