package com.project.encuesta.presentador;

import android.content.Context;
import com.project.encuesta.interfaz.EncuestaInterface;
import com.project.encuesta.interfaz.PresentadorEncuestaInterface;
import com.project.encuesta.interfaz.VistaEncuestaInterface;
import com.project.encuesta.model.EncuestaInteractor;
import com.project.encuesta.model.Imagen;
import com.project.encuesta.model.Opcion;
import java.util.ArrayList;

public class PresentadorEncuesta implements PresentadorEncuestaInterface {
    private VistaEncuestaInterface vista;
    private EncuestaInterface encuesta;

    public PresentadorEncuesta(VistaEncuestaInterface vista) {
        this.vista = vista;
        this.encuesta = new EncuestaInteractor(this);
    }


    @Override
    public void listarOpcion(int id, Context context) {
        if(vista!=null){
            encuesta.listarOpcion(id,context);
        }
    }

    @Override
    public void obtenerImagen(int id, Context context) {
        if(vista!=null){
            encuesta.obtenerImagen(id,context);
        }
    }

    @Override
    public void mostrarOpciones(ArrayList<Opcion> opciones) {
        if(vista!=null){
            vista.mostrarOpciones(opciones);
        }
    }

    @Override
    public void mostrarError(String error) {
        if (vista!=null){
            vista.mostrarError(error);
        }
    }


    @Override
    public void mostrarImagen(Imagen imagen) {
        if(vista!=null){
            vista.mostrarImagen(imagen);
        }
    }

}
