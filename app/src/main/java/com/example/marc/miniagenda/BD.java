package com.example.marc.miniagenda;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by marc on 17/04/2015.
 */
public class BD extends SQLiteOpenHelper {
    //Query para crear las tablas en la bd
    String query="CREATE TABLE personas (id INTEGER PRIMARY KEY AUTOINCREMENT, Nombre TEXT, Apellido TEXT, Telefono TEXT, Email TEXT)";

    //Constructor de la clase
    public BD(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        //Ejecuta query para crear la tabla
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i2) {
        db.execSQL("DROP TABLE IF EXISTS personas");

        //Se crea la nueva versión de la tabla
        db.execSQL(query);
    }

}
