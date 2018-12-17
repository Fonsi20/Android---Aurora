package com.example.a16alfonsofa.aurora01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by mallo on 17/12/2018.
 */

public class Adaptador extends BaseAdapter {

    private static LayoutInflater inflater = null;

    Context contexto;
    String[][] datos;

    public Adaptador(Context conexto, String[][] datos) {
        this.contexto = conexto;
        this.datos = datos;
        inflater = (LayoutInflater) conexto.getSystemService(conexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {

        final View vista = inflater.inflate(R.layout.elemento_lista, null);

        TextView titulo = (TextView) vista.findViewById(R.id.tvTitulo);
        TextView duracion = (TextView) vista.findViewById(R.id.tvDuracion);
        TextView director = (TextView) vista.findViewById(R.id.tvDirector);
        ImageView imagen = (ImageView) vista.findViewById(R.id.ivImagen);

        titulo.setText(datos[i][0]);
        director.setText(datos[i][1]);
        duracion.setText("Pendiente");
        imagen.setImageResource(R.mipmap.ic_test_uncolor);

        return vista;
    }

    @Override
    public int getCount() {
        return datos.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

}
