package com.example.a16alfonsofa.aurora01.Pantallas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.a16alfonsofa.aurora01.R;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ActividadIndividual extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_individual);

        Random r = new Random();
        Set<Integer> generados = new HashSet<>();
        for (int i = 1; i <= 20; i++) {
            int aleatorio = -1;
            boolean generado = false;
            while (!generado) {
                int posible = r.nextInt();
                if (!generados.contains(posible)) {
                    generados.add(posible);
                    aleatorio = posible;
                    generado = true;
                }
            }
            //usa el valor de aleatorio...

        }
    }
}
