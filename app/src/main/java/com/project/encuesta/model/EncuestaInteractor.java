package com.project.encuesta.model;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.project.encuesta.interfaz.EncuestaInterface;
import com.project.encuesta.interfaz.PresentInterface;
import com.project.encuesta.interfaz.PresentadorEncuestaInterface;
import com.project.encuesta.utilidades.Utilidades;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class EncuestaInteractor implements EncuestaInterface, Response.ErrorListener, Response.Listener<JSONObject> {

    private PresentadorEncuestaInterface presentador;

    public EncuestaInteractor(PresentadorEncuestaInterface presentador) {
        this.presentador = presentador;
    }
    Utilidades utilidades = new Utilidades();
    RequestQueue request;
    JsonObjectRequest objectRequest;
    ArrayList<Opcion> opciones;

    /** METODO QUE CARGA EL WEB SERVICE Y NOS DEVUELVE LA LISTA DE OPCIONES SEGUN EL TIPO DE
     * ENCUESTA SELECCIONADO*/
    @Override
    public void listarOpcion(int id, Context context) {
        request = Volley.newRequestQueue(context);
        CargarWebService(id);
    }
    /** METODO QUE CARGA EL WEB SERVICE Y NOS DEVUELVE UNA IMAGEN */

    @Override
    public void obtenerImagen(int id, Context context) {
        request = Volley.newRequestQueue(context);
        CargarWebServiceImagen(id);
    }

    private void CargarWebServiceImagen(int id) {
        String sql="http://"+utilidades.IP+"/bdEncuesta/imagen.php?id_imagen="+id;
        objectRequest = new JsonObjectRequest(Request.Method.GET, sql, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Imagen imagen = null;
                JSONArray json = response.optJSONArray("imagenes");
                //ArrayList<Imagen> imagenes = new ArrayList<>();
                try {
                    for (int i = 0; i < json.length(); i++) {
                        JSONObject object = json.getJSONObject(i);
                        imagen = new Imagen();
                        imagen.setId(object.optInt("id_imagen"));
                        imagen.setDato(object.optString("imagen"));
                  //      imagenes.add(imagen);
                    }
                    /** NOS LLEVA LA IMAGEN A TRAVES DEL PRESENTADOR PARA MOSTRARLO EN EL
                     * FRAGMENT ENCUESTA**/
                    presentador.mostrarImagen(imagen);
                    //presentador.mostrarImagen(imagenes);
                }catch (Exception e){
                    e.printStackTrace();
                    presentador.mostrarError("ERROR EN ONRESPONSE: "+e.toString());
                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                presentador.mostrarError("ERROR AL CARGAR WEBSERVICE IMAGEN"+error.toString());
            }
        });

        request.add(objectRequest);
    }

    public void CargarWebService(int id){
        String sql = "http://"+utilidades.IP+"/bdEncuesta/opciones.php?id_tipo_encuesta="+id;
        objectRequest = new JsonObjectRequest(Request.Method.GET,sql,null,
                this,this);
        request.add(objectRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        presentador.mostrarError("ERROR AL CARGAR WEBSERVICE "+error.toString());
    }

    @Override
    public void onResponse(JSONObject response) {
        Opcion opcion = null;
        JSONArray json = response.optJSONArray("opciones");
        opciones = new ArrayList<>();
        try {
            for (int i = 0; i < json.length(); i++) {
                JSONObject object = json.getJSONObject(i);
                opcion = new Opcion(
                        object.optInt("id_opciones"),
                        object.optString("opcion")
                );
                opciones.add(opcion);
            }
            /** NOS LLEVA EL ARRAY DE OPCIONES A TRAVES DEL PRESENTADOR PARA MOSTRARLO EN EL
             * FRAGMENT ENCUESTA**/
            presentador.mostrarOpciones(opciones);
        }catch (Exception e){
            e.printStackTrace();
            presentador.mostrarError("ERROR EN ONRESPONSE: "+e.toString());
        }
    }

}
