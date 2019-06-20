package com.example.proyectofinalcrespo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DaoAlumno {

    public static final String NOMBRE_TABLA = "Alumno";
    public static final String DNI_ALU =  "dni";
    public static  final String NOMBRE_ALU = "nombre";
    public static final String APE_ALU = "apellido";
    public static final String DOMIC_ALU="domicilio";
    public static final String TEL_ALU="telefono";

    public static final String CREATE_TABLE = "CREATE TABLE " + NOMBRE_TABLA + " ("
            + DNI_ALU + " integer primary key,"
            + NOMBRE_ALU + " text not null, "
            + APE_ALU + " text not null,"
            + DOMIC_ALU + " text,"
            + TEL_ALU + " text);";


    private DataBaseHelper helper;
    private SQLiteDatabase db;


    public DaoAlumno(Context context){
        helper = new DataBaseHelper(context);
        db = helper.getWritableDatabase();
        db = helper.getReadableDatabase();

    }

    public void crearAlumno(int dni, String nombre, String apellido, String domicilio, String telefono){
        ContentValues valores = new ContentValues();
        valores.put(DNI_ALU,dni);
        valores.put(NOMBRE_ALU,nombre);
        valores.put(APE_ALU, apellido);
        valores.put(DOMIC_ALU, domicilio);
        valores.put(TEL_ALU,telefono);
        db.insert(NOMBRE_TABLA,null,valores);
    }

    public ArrayList mostrarTodos(){
      ArrayList<String>alumnos = new ArrayList();
      String query = "SELECT * FROM Alumno";
      Cursor registro = db.rawQuery(query,null);
      if(registro.moveToFirst()){
          do{
              alumnos.add((registro.getString(1) )+ " " +(registro.getString(2)) + " Dni: " +(registro.getInt(0)));

          }while(registro.moveToNext());
      }

      return alumnos;
    }
}
