package com.example.a16alfonsofa.aurora01.Pantallas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.a16alfonsofa.aurora01.BBDD.BDHelper;
import com.example.a16alfonsofa.aurora01.Objetos.Actividades;
import com.example.a16alfonsofa.aurora01.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ActividadIndividual extends AppCompatActivity {

    private String BDname;
    private int BDversion;
    private SQLiteDatabase DBComidas;

    ArrayList<Actividades> ActividadesList;
    ArrayList<String> listActividades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_individual);

        try {
            deployDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BDname = "aurora";
        BDversion = 1;
        BDHelper bdhelper = new BDHelper(this, BDname, null, BDversion);
        DBComidas = bdhelper.getWritableDatabase();

        consultarActividades();

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

    private void deployDatabase() throws IOException {

        //Open your local db as the input stream
        String packageName = getApplicationContext().getPackageName();
        String DB_PATH = "/data/data/" + packageName + "/databases/";
        //Create the directory if it does not exist
        File directory = new File(DB_PATH);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        String DB_NAME = "aurora"; //The name of the source sqlite file

        InputStream myInput = getAssets().open("aurora");

        // Path to the just created empty db
        String outFileName = DB_PATH + DB_NAME;

        //Open the empty db as the output stream
        OutputStream myOutput = new FileOutputStream(outFileName);

        //transfer bytes from the inputfile to the outputfile
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }

        //Close the streams
        myOutput.flush();
        myOutput.close();
        myInput.close();

    }

    private void consultarActividades() {
        Actividades act = null;
        ActividadesList = new ArrayList<Actividades>();
        //select * from Categorias
        Cursor cursor = DBComidas.rawQuery("SELECT * FROM actividades", null);

        while (cursor.moveToNext()) {
            act = new Actividades();
            act.setId(cursor.getInt(0));
            act.setNombreA(cursor.getString(1));
            act.setDescripcionA(cursor.getString(2));
            Log.i("nuevaActividad", cursor.getString(1));

            ActividadesList.add(act);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listActividades = new ArrayList<String>();
        for (int i = 0; i < ActividadesList.size(); i++) {
            Log.i("nuevaActividadLista", ActividadesList.get(i).getNombreA());
            listActividades.add(ActividadesList.get(i).getNombreA());
        }
    }
}