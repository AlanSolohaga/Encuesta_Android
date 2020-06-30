package com.project.encuesta.presentador;

import com.project.encuesta.interfaz.BuscarImagenInterface;
import com.project.encuesta.interfaz.PresentInterface;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BuscarImagen implements BuscarImagenInterface {

    private PresentInterface presentador;
    File archivo;
    byte[] imagen;
    FileInputStream entrada;
    FileOutputStream salida;

    public BuscarImagen(PresentInterface presentador) {
        this.presentador = presentador;
    }

    @Override
    public void buscarImagen(File archivo) {
        if(archivo.canRead()){
            imagen = abrirArchivo(archivo);
            presentador.mostrarImagen(imagen);
        }

    }

    public byte[] abrirArchivo(File archivo){
        byte[]imagen = new byte[1024*100];
        try {
            entrada = new FileInputStream(archivo);
            entrada.read(imagen);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR AL LEER");
        }
        return imagen;
    }

    public String guardarArchivo(File archivo,byte[]imagen){
        String mensaje = null;

        try {
            salida = new FileOutputStream(archivo);
            salida.write(imagen);
            mensaje = "archivo guardado";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR AL GUARDAR");
        }
        return mensaje;
    }

}

