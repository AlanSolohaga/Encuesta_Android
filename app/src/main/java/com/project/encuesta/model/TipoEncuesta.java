package com.project.encuesta.model;

public class TipoEncuesta {
    private int id;
    private String nombre;
    private String pregunta;

    public TipoEncuesta(int id,String nombre, String pregunta) {
        this.id = id;
        this.nombre = nombre;
        this.pregunta = pregunta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
