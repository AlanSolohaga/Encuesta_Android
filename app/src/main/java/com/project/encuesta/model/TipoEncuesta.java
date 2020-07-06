package com.project.encuesta.model;

public class TipoEncuesta {
    private String nombre;
    private String pregunta;

    public TipoEncuesta(String nombre, String pregunta) {
        this.nombre = nombre;
        this.pregunta = pregunta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
}
