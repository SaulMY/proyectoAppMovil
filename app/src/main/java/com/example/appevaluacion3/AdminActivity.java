package com.example.appevaluacion3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AdminActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        BottomNavigationView bottomNavigationView = findViewById(R.id.menuAdmin);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction() .replace(R.id.frameContainer2, new inicioAdmin()).commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if(itemId == R.id.itemInfoAdmin){
            getSupportFragmentManager().beginTransaction() .replace(R.id.frameContainer2, new inicioAdmin()).commit();
        }else if (itemId == R.id.itemAltas){
            getSupportFragmentManager().beginTransaction() .replace(R.id.frameContainer2, new registro_cliente()).commit();
        }else if (itemId == R.id.itemSalir2){
            getSupportFragmentManager().beginTransaction() .replace(R.id.frameContainer2, new cerrar_admin()).commit();
        }

        return true;
    }
}