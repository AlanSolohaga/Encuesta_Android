package com.project.encuesta.model;

import java.util.ArrayList;

public class Encuesta {
    //private byte[] imagen;
    private String imagen;
    private ArrayList<Pregunta> pregunta;

    public Encuesta(String imagen, ArrayList<Pregunta> pregunta) {
        this.imagen = imagen;
        this.pregunta = pregunta;
    }

    public ArrayList<Pregunta> getPregunta() {
        return pregunta;
    }

    public void setPregunta(ArrayList<Pregunta> pregunta) {
        this.pregunta = pregunta;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }


}
