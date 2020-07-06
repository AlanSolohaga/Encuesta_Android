package com.project.encuesta.presentador;

import android.content.Context;

import com.project.encuesta.interfaz.BuscarImagenInterface;
import com.project.encuesta.interfaz.CrearEncuestaInterface;
import com.project.encuesta.interfaz.PresentInterface;
import com.project.encuesta.interfaz.TipoEncuestaInterface;
import com.project.encuesta.interfaz.VistaInterface;
import com.project.encuesta.model.CrearEncuesta;
import com.project.encuesta.model.Pregunta;
import com.project.encuesta.model.TipoEncuesta;
import com.project.encuesta.model.TipoEncuestaInteractor;

import java.io.File;
import java.util.ArrayList;

public class Presentador implements PresentInterface {
    private CrearEncuestaInterface crearEncuesta;
    private VistaInterface vista;
    private BuscarImagenInterface buscarImagen;
    private TipoEncuestaInterface tipoEncuesta;

    public Presentador(VistaInterface vista) {
        this.vista = vista;
        this.crearEncuesta = new CrearEncuesta(this);
        this.buscarImagen = new BuscarImagen(this);
        this.tipoEncuesta = new TipoEncuestaInteractor(this);
    }

    @Override
    public void mostrarPregunta(String pregunta) {
        if(vista!=null){
            vista.mostrarPregunta(pregunta);
        }
    }

    @Override
    public ArrayList<Pregunta> mostrarArray() {
        if(vista!=null){
            return crearEncuesta.mostrarArray();
        }else{
            return null;
        }
    }


    @Override
    public void arrayPregunta(String pregunta) {
        if(vista!=null){
            crearEncuesta.arrayPregunta(pregunta);
        }
    }

    @Override
    public void agregarPreguntas(String imagen) {
        if(vista!=null){
            crearEncuesta.agregarPreguntas(imagen);
        }
    }

    @Override
    public void buscarImagen(File archivo) {
        if(vista!=null){
            buscarImagen.buscarImagen(archivo);
        }
    }

    @Override
    public void mostrarImagen(byte[] imagen) {
        if(vista!=null){
            vista.mostrarImagen(imagen);
        }
    }

    @Override
    public void mostrarTipoEncuestas(ArrayList<TipoEncuesta> tipoEncuestas) {
        if(vista!=null){
            vista.mostrarTipoEncuestas(tipoEncuestas);
        }
    }

    @Override
    public void errorMostrarTipoEncuestas(String error) {
        if(vista!=null){
            vista.errorMostrarTipoEncuestas(error);
        }
    }

    @Override
    public void listarTipoEncuesta(Context context) {
        if(vista!=null){
            tipoEncuesta.listarTipoEncuesta(context);
        }
    }

}
