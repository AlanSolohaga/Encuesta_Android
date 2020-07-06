package com.project.encuesta.model;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.project.encuesta.interfaz.PresentInterface;
import com.project.encuesta.interfaz.TipoEncuestaInterface;
import com.project.encuesta.presentador.Presentador;

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
                        jsonObject.optString("nombre"),
                        jsonObject.optString("pregunta")
                );
                agregarAlArray(tipoEncuesta);
            }
            presentador.mostrarTipoEncuestas(tipoEncuestas);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("ERROR AL QUERER LISTAR");
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
