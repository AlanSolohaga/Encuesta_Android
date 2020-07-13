package com.project.encuesta.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.project.encuesta.MainActivity;
import com.project.encuesta.R;

public class LoginActivity extends AppCompatActivity {

    SignInButton btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnIngresar = findViewById(R.id.btn_ingresar);
        btnIngresar.setSize(SignInButton.SIZE_WIDE);

        btnIngresar.setColorScheme(SignInButton.COLOR_AUTO);
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /** REALIZAR LA OPTENCIÓN DEL ID DE LA CUENTA GOOGLE PARA ENVIARLA AL ACTIVITY PRINCIPAL
                 * Y, A PARTIR DE ESE DATO LLEVAR EL SEGUIMIENTO DE IMAGENES CONTESTADAS**/

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}
