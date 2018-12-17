package com.example.a16alfonsofa.aurora01.Pantallas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.a16alfonsofa.aurora01.Adaptador;
import com.example.a16alfonsofa.aurora01.R;

public class ListaActividad extends AppCompatActivity {

    ListView lista;

    String[][] datos = {
            {"¿Que tal el dia?", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras laoreet ac eros tincidunt sodales. Nam tortor ipsum, accumsan vel porttitor in, consequat sit amet leo. Etiam turpis velit, ullamcorper ut lacinia eu, luctus eget diam."},
            {"Escoge la foto que más te gusta", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras laoreet ac eros tincidunt sodales. Nam tortor ipsum, accumsan vel porttitor in, consequat sit amet leo. Etiam turpis velit, ullamcorper ut lacinia eu, luctus eget diam."},
            {"¿Que es lo mejor que te pasó hoy?", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras laoreet ac eros tincidunt sodales. Nam tortor ipsum, accumsan vel porttitor in, consequat sit amet leo. Etiam turpis velit, ullamcorper ut lacinia eu, luctus eget diam."},
            {"¿Cual es tu comida favorita?", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras laoreet ac eros tincidunt sodales. Nam tortor ipsum, accumsan vel porttitor in, consequat sit amet leo. Etiam turpis velit, ullamcorper ut lacinia eu, luctus eget diam."},
            {"¿Quien era tu mejor amigo de la infancia?", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras laoreet ac eros tincidunt sodales. Nam tortor ipsum, accumsan vel porttitor in, consequat sit amet leo. Etiam turpis velit, ullamcorper ut lacinia eu, luctus eget diam."},
            {"Dime tu canción favorita!", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras laoreet ac eros tincidunt sodales. Nam tortor ipsum, accumsan vel porttitor in, consequat sit amet leo. Etiam turpis velit, ullamcorper ut lacinia eu, luctus eget diam."},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_actividad);

        lista = (ListView) findViewById(R.id.lvLista);
        lista.setAdapter(new Adaptador(ListaActividad.this, datos));

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /** Intent visorDetalles = new Intent(view.getContext(), DetallesPelicula.class);
                 visorDetalles.putExtra("TIT", datos[position][0]);
                 visorDetalles.putExtra("DET", datos[position][4]);
                 startActivity(visorDetalles);**/
            }
        });
    }
}
