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
import com.project.encuesta.utilidades.Utilidades;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class TipoEncuestaInteractor implements TipoEncuestaInterface,Response.Listener<JSONObject>, Response.ErrorListener {

    private PresentInterface presentador;

    public TipoEncuestaInteractor(PresentInterface presentador) {
        this.presentador = presentador;
    }

    Utilidades utilidades = new Utilidades();

    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;
    ArrayList<TipoEncuesta> tipoEncuestas;

    /************************CARGA DE LA VISTA MENU*************************************/

    /**COMUNICO CON EL WEB SERVICE QUE DEVUELVE LOS TIPO_ENCUESTA**/
    @Override
    public void listarTipoEncuesta(Context context) {
        request = Volley.newRequestQueue(context);
        cargarWebService();
    }
    public void cargarWebService(){
        String sql = "http://"+ utilidades.IP +"/bdEncuesta/tipoEncuesta.php";
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,sql,null,
                this,this);
        request.add(jsonObjectRequest);
    }
    @Override
    public void onErrorResponse(VolleyError error) {
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
            }

            /**ENVIO AL PRESENTADOR EL ARRAY PARA MOSTRARLO EN LA VISTA A TRAVES DEL ADAPTADOR*/
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

}
