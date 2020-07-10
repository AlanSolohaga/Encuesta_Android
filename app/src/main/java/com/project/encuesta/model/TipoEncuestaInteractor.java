package com.project.encuesta.model;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.project.encuesta.interfaz.PresentInterface;
import com.project.encuesta.interfaz.TipoEncuestaInterface;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class TipoEncuestaInteractor implements TipoEncuestaInterface,Response.Listener<JSONObject>, Response.ErrorListener {

    private PresentInterface presentador;

    public TipoEncuestaInteractor(PresentInterface presentador) {
        this.presentador = presentador;
    }

    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;
    ArrayList<TipoEncuesta> tipoEncuestas;
    Encuesta encuesta;
    ArrayList<Opcion> opcions;


    /************************CARGA DE LA VISTA MENU*************************************/

    /**COMUNICO CON EL WEB SERVICE QUE DEVUELVE LOS TIPO_ENCUESTA**/
    @Override
    public void listarTipoEncuesta(Context context) {
        request = Volley.newRequestQueue(context);
        cargarWebService();
    }

    public void cargarWebService(){
        String sql = "http://192.168.5.112/bdEncuesta/tipoEncuesta.php";
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,sql,null,
                this,this);
        request.add(jsonObjectRequest);
    }
    @Override
    public void onErrorResponse(VolleyError error) {
        //Mostrar error
        presentador.errorMostrarTipoEncuestas("ERROR AL CARGAR WEBSERVICE: "+error.toString());
    }

    @Override
    public void onResponse(JSONObject response) {
        //LISTAMOS LO DE LA BASE DE DATOS
        TipoEncuesta tipoEncuesta=null;
        JSONArray json = response.optJSONArray("tipoEncuesta");
        tipoEncuestas = new ArrayList<>();
        try {
            for(int i=0;i<json.length();i++){
                JSONObject jsonObject = json.getJSONObject(i);
                tipoEncuesta = new TipoEncuesta(
                        jsonObject.optInt("id"),
                        jsonObject.optString("nombre"),
                        jsonObject.optString("pregunta")
                );
                tipoEncuestas.add(tipoEncuesta);
                //agregarAlArray(tipoEncuesta);
            }

            //ENVIO AL PRESENTADOR EL ARRAY PARA MOSTRARLO EN LA VISTA A TRAVES DEL ADAPTADOR
            presentador.mostrarTipoEncuestas(tipoEncuestas);

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ERROR AL QUERER LISTAR");
            presentador.errorMostrarTipoEncuestas("ERROR AL QUERER LISTAR: "+e.toString());
        }
    }

    private void agregarAlArray(TipoEncuesta tipoEncuesta) {
        if(tipoEncuestas!=null){
            tipoEncuestas.add(tipoEncuesta);
        }else{
            tipoEncuestas = new ArrayList<>();
            tipoEncuestas.add(tipoEncuesta);
        }
    }
    /**********************************************************************************/
    /** ******************CARGA DE LA VISTA ENCUESTA***********************************/

    // NO LO VOY A USAR POR EL MOMENTO
    @Override
    public ArrayList<Opcion> obtenerOpciones(ArrayList<Opcion> opciones) {
        String sql = "http://192.168.5.112/bdEncuesta/opciones.php?id_tipo_encuesta=4";

        return null;
    }


    @Override
    public void cargarEncuesta(int id) {
        //encuesta = new Encuesta(tipoEncuestas.get(id).getPregunta(),obtenerOpciones(id));

        opcions = new ArrayList<>();
        Opcion opcion = new Opcion(1,"Opcion");
        opcions.add(opcion);
        Encuesta encuesta1 = new Encuesta("PREGUNTA NUEVA",opcions);
        presentador.mostrarEncuesta(encuesta1);

    }



    private ArrayList<Opcion> obtenerOpciones(int id) {
        String sql = "http://192.168.5.112/bdEncuesta/opciones.php?id_tipo_encuesta="+id;


        return opcions;
    }

    private void obtenerImagen(int id){
        // DE AQUÍ RELACIONARÉ LA IMAGEN
    }


}
