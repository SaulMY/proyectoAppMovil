 package com.example.appevaluacion3;

 import android.content.Intent;
 import android.os.Bundle;
 import android.os.Handler;

 import androidx.appcompat.app.AppCompatActivity;
 import androidx.appcompat.app.AppCompatDelegate;

 public class Inicio extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);

        final int DURACION = 6000;

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent intent = new Intent(Inicio.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },DURACION);
    }
}