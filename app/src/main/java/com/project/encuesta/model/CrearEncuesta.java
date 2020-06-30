package com.project.encuesta.model;

import com.project.encuesta.interfaz.CrearEncuestaInterface;
import com.project.encuesta.interfaz.PresentInterface;

import java.util.ArrayList;

public class CrearEncuesta implements CrearEncuestaInterface {
    private PresentInterface presentador;
    Encuesta encuesta;
    ArrayList<Pregunta> array;

    public CrearEncuesta(PresentInterface presentador) {
        this.presentador = presentador;
    }


    @Override
    public void arrayPregunta(String pregunta) {
        if(array!=null){
            Pregunta pregunta1 = new Pregunta(pregunta);
            array.add(pregunta1);
            //HACER mostrar pregunta
        }else{
            array=new ArrayList();
            Pregunta pregunta1 = new Pregunta(pregunta);
            array.add(pregunta1);
        }
    }

    @Override
    public void agregarPreguntas(String imagen) {
        encuesta = new Encuesta(" ",array);
        presentador.mostrarPregunta(""+encuesta.getPregunta().get(1).getPregunta());
        array.clear();
        try {
            //CONECTAR A LA BD Y GUARDAR LA ENCUESTA
        } catch (Exception e) {

        }
    }

    @Override
    public ArrayList<Pregunta> mostrarArray() {
        if(array!=null){
            return array;
        }else{
            array = new ArrayList();
            return array;
        }

    }


}
