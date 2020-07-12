package com.project.encuesta.presentador;

import android.content.Context;

import com.project.encuesta.interfaz.PresentInterface;
import com.project.encuesta.interfaz.TipoEncuestaInterface;
import com.project.encuesta.interfaz.VistaInterface;
import com.project.encuesta.model.TipoEncuesta;
import com.project.encuesta.model.TipoEncuestaInteractor;

import java.util.ArrayList;

public class Presentador implements PresentInterface{
    private VistaInterface vista;
    private TipoEncuestaInterface tipoEncuesta;

    public Presentador(VistaInterface vista) {
        this.vista = vista;
        this.tipoEncuesta = new TipoEncuestaInteractor(this);
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
