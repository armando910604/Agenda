package com.example.marc.miniagenda;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class MainActivity2 extends ActionBarActivity {

    private EditText nombre,apellido,telefono,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);

        nombre=(EditText)findViewById(R.id.et_nombre);
        apellido=(EditText)findViewById(R.id.et_apellido);
        telefono=(EditText)findViewById(R.id.et_telefono);
        email=(EditText)findViewById(R.id.et_email);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void limpiar(View view){
        nombre.setText("");
        apellido.setText("");
        telefono.setText("");
        email.setText("");
    }

    public void agregar(View view){
        String nombre,apellido,telefono,email;
        nombre=this.nombre.getText().toString();
        apellido=this.apellido.getText().toString();
        telefono=this.telefono.getText().toString();
        email=this.email.getText().toString();

        ConexionBD ObjCnx = new ConexionBD(this);

        ObjCnx.abrirConexion();
        if(ObjCnx.insertar(nombre,apellido,telefono,email)==true){
            String texto ="Elemento Agregado Corectamente";
            Toast toast = Toast.makeText(this, texto, Toast.LENGTH_LONG);
            toast.show();
        }
        else{
            String texto ="Error al Agregar Elemento";
            Toast toast = Toast.makeText(this, texto, Toast.LENGTH_LONG);
            toast.show();
        }
        ObjCnx.cerrarConexion();
    }
}
