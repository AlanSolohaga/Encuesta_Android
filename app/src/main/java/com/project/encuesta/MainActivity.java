package com.project.encuesta;

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

import com.project.encuesta.interfaz.ComunicaFragments;
import com.project.encuesta.interfaz.PresentInterface;
import com.project.encuesta.interfaz.VistaInterface;
import com.project.encuesta.presentador.Presentador;
import com.project.encuesta.vista.EncuestaFragment;
import com.project.encuesta.vista.MenuFragment;
import com.project.encuesta.vista.SplashDespedida;

public class MainActivity extends AppCompatActivity implements ComunicaFragments {
    FragmentTransaction fragmentTransaction;
    MenuFragment menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu = new MenuFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor,menu).commit();
        /*
    <fragment
        android:id="@+id/fragmentPreguntas"
        tools:layout="@layout/fragment_menu"
        android:name="com.project.encuesta.vista.MenuFragment"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">
    </fragment>

        */

    }

    @Override
    public void mostrarEncuesta(int id,String pregunta) {
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
    protected void onDestroy() {
        super.onDestroy();
        Intent intent = new Intent(MainActivity.this,SplashDespedida.class);
        startActivity(intent);
        finish();
    }

}
