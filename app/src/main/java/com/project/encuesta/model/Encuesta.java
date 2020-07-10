package com.project.encuesta.model;

import java.util.ArrayList;

public class Encuesta {
    //private byte[] imagen;
    private String pregunta;
    private ArrayList<Opcion> opcion;

    public Encuesta(String pregunta, ArrayList<Opcion> opcion) {
        this.pregunta = pregunta;
        this.opcion = opcion;
    }

    public ArrayList<Opcion> getOpcion() {
        return opcion;
    }

    public void setOpcion(ArrayList<Opcion> opcion) {
        this.opcion = opcion;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }


}
