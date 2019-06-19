package com.example.proyectofinalcrespo;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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
}
