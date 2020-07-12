package com.project.encuesta.interfaz;

import android.content.Context;

import com.project.encuesta.model.TipoEncuesta;
import java.util.ArrayList;

public interface PresentInterface {

    /**VISTA INTERFACE**/
    void mostrarTipoEncuestas(ArrayList<TipoEncuesta> tipoEncuestas);
    void errorMostrarTipoEncuestas(String error);


    /**TIPO DE ENCUESTA INTERFACE**/
    void listarTipoEncuesta(Context context);
}
