package com.example.marc.miniagenda;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by marc on 17/04/2015.
 */
public class ConexionBD {
    private SQLiteDatabase db;
    private Context nContext;
    private BD objBD;


    //Constructor de la Clase
    //Recibe como parámetro una variable de Tipo contexto
    // Esto debido a que Para acceder o crear la BD lo pide la Clase SQLiteOpenHelper
    public ConexionBD(Context c){
        nContext=c;

    }

    public void abrirConexion(){
        objBD =new BD(nContext,"BDAgenda",null,1 );
        db=objBD.getWritableDatabase();
    }

    public void cerrarConexion(){
        db.close();
    }

    public boolean insertar(String nombre, String apellido,String telefono,String email){
        boolean resultado=false;

        try{
            String query="INSERT INTO personas(Nombre, Apellido, Telefono, Email) VALUES('"+nombre+"','"+apellido+"','"+
                    telefono+"','"+email+"')";

            db.execSQL(query);
            resultado=true;
            return resultado;
        }
        catch (Exception e){
            resultado=false;
            return resultado;
        }
    }



}
