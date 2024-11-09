package com.example.appevaluacion3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.navMenu);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        //getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new fragment1InfoCliente()).commit();
        //bottomNavigationView.setSelectedItemId(R.id.clienteInfo);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemID = item.getItemId();
        if (itemID == R.id.clienteInfo){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new fragment1InfoCliente()).commit();
        }
        else if (itemID == R.id.opciones){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new fragment2Opciones()).commit();
        }
        else if (itemID == R.id.iniciarSesion){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new fragment3IniciarSesion()).commit();
        }
        else if (itemID == R.id.cerrarSesion){
            getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new fragment4CerrarSesion()).commit();
        }

        return true;
    }
}