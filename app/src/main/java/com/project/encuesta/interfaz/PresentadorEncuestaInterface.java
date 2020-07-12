package com.project.encuesta.interfaz;

import android.content.Context;
import com.project.encuesta.model.Imagen;
import com.project.encuesta.model.Opcion;
import java.util.ArrayList;

public interface PresentadorEncuestaInterface {
    /**  ENCUESTA INTERFACE **/
    void listarOpcion(int id, Context context);
    void obtenerImagen(int id, Context context);

    /**  VISTA ENCUESTA INTERFACE**/
    void mostrarOpciones(ArrayList<Opcion> opciones);
    void mostrarError(String error);
    void mostrarImagen(Imagen imagen);
}
