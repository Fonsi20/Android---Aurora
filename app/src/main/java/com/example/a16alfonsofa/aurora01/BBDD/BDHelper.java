package com.example.a16alfonsofa.aurora01.BBDD;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDHelper extends SQLiteOpenHelper {


    static final String tabla1 = "actividades";
    static final String tabla2 = "sentimientos";
    static final String columna1 = "id";
    static final String columna2 = "nombreA";
    static final String columna3 = "descripcionA";
    static final String columna4 = "tipoA";
    static final String columna5 = "respuesta";
    static final String columna6 = "fechayhora";
    static final String columna7 = "fecha";
    static final String columna8 = "sensacion";
    static final String columna9 = "respuesta";

    String SQLCrearActivi = "CREATE TABLE IF NOT EXISTS " + tabla1 + "(" + columna1 + " INTEGER not null PRIMARY KEY, " + columna2 + " VARCHAR(50), " + columna3 + " VARCHAR(900), "
            + columna4 + " VARCHAR(50)," + columna5 + " varchar(500) not null," + columna6 + " datetime not null )";
    String SQLCrearSenti = "CREATE TABLE IF NOT EXISTS " + tabla2 + "(" + columna7 + " date PRIMARY KEY, " + columna8 + " VARCHAR(50), " + columna9 + " FLOAT(5))";

    String SQLDeleteActivi = "DROP TABLE IF EXISTS " + tabla1;
    String SQLDeleteSenti = "DROP TABLE IF EXISTS " + tabla2;

    public BDHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLCrearActivi);
        sqLiteDatabase.execSQL(SQLCrearSenti);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQLDeleteActivi);
        sqLiteDatabase.execSQL(SQLDeleteSenti);
    }
}
