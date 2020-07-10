package com.project.encuesta.vista;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.project.encuesta.R;

public class SplashDespedida extends AppCompatActivity {
    private final int duracion = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_despedida);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            };
        },duracion);

    }
}
