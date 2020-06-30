package com.project.encuesta.model;

public class Pregunta {
    //private int id;
    private String pregunta;

    public Pregunta(String pregunta) {
       // this.id = id;
        this.pregunta = pregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
}
