package com.project.encuesta.model;

public class Opcion {
    private int id;
    private String opcion;

    public Opcion(int id, String opcion) {
        this.id = id;
        this.opcion = opcion;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
