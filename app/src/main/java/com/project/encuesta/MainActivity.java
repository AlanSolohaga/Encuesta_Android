package com.project.encuesta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.project.encuesta.interfaz.ComunicaFragments;
import com.project.encuesta.interfaz.PresentInterface;
import com.project.encuesta.interfaz.VistaInterface;
import com.project.encuesta.presentador.Presentador;
import com.project.encuesta.vista.EncuestaFragment;
import com.project.encuesta.vista.LoginActivity;
import com.project.encuesta.vista.MenuFragment;
import com.project.encuesta.vista.SplashDespedida;

public class MainActivity extends AppCompatActivity implements ComunicaFragments, GoogleApiClient.OnConnectionFailedListener {
    FragmentTransaction fragmentTransaction;
    MenuFragment menu;

    private GoogleApiClient googleApiClient;

    int id_user = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** INSTANCIO EL FRAGMENT MENU Y LO ASIGNO AL CONTENEDOR DEL MAIN PRINCIPAL**/
        menu = new MenuFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor,menu).commit();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        googleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this,this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
    }

    @Override
    public void mostrarEncuesta(int id,String pregunta) {
        /** ENVIO DATOS ID Y PREGUNTA AL FRAGMENT DE LA ENCUESTA PARA OBTENER LOS OTROS DATOS
            (OPCIONES, IMAGENES)**/
        Bundle objEnviado = new Bundle();
        objEnviado.putInt("id",id);
        objEnviado.putString("pregunta",pregunta);
        EncuestaFragment encuestaFragment = new EncuestaFragment();
        encuestaFragment.setArguments(objEnviado);
        fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, encuestaFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(this, "ERROR DE CONEC "+connectionResult.toString(), Toast.LENGTH_SHORT).show();
    }

    /**LLAMAMOS AL METODO onStart() para que al iniciar verifiquemos si existe alguna cuenta
     * registrada**/
    @Override
    protected void onStart() {
        super.onStart();
        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(googleApiClient);
        if(opr.isDone()){
            GoogleSignInResult result = opr.get();
            validarResult(result);
        }else{
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(@NonNull GoogleSignInResult googleSignInResult) {
                    validarResult(googleSignInResult);
                }
            });
        }
    }

    private void validarResult(GoogleSignInResult result) {
        if(result.isSuccess()){
            /**Obtenemos el id de la cuenta iniciada*/
            GoogleSignInAccount account = result.getSignInAccount();

            //Toast.makeText(this, "id_user: "+account.getId(), Toast.LENGTH_SHORT).show();
            id_user = Integer.parseInt(account.getId());
            Toast.makeText(this, "Bienvenido/a "+account.getGivenName(), Toast.LENGTH_SHORT).show();
        }else{
            /**Caso contrario volvemos a la activity de login**/
            abrirLogin();
        }
    }

    private void abrirLogin() {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


    /**Metodo para el boton logOut**/
    public void logOut(View view) {
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                if (status.isSuccess()) {
                    //Toast.makeText(MainActivity.this, "SALGA DE LA APP Y VUELVA A INGRESAR PARA CAMBIAR DE USUARIO", Toast.LENGTH_SHORT).show();
                    abrirLogin();
                } else {
                    Toast.makeText(getApplicationContext(), "NO SE PUDO CERRAR SESIÓN", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    /**CUANDO LA ACTIVIDAD PRINCIPAL SE DESTRUYE INICIO EL SPLASH DESPEDIDA**/
    /*
    @Override
    protected void onDestroy() {
        super.onDestroy();



        Intent intent = new Intent(MainActivity.this,SplashDespedida.class);
        startActivity(intent);
        finish();
    }
    */
}
