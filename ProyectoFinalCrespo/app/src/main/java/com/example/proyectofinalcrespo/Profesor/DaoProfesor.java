package com.example.proyectofinalcrespo.Profesor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectofinalcrespo.Alumno.AlumnoModelo;
import com.example.proyectofinalcrespo.DataBaseHelper;

import java.util.ArrayList;

public class DaoProfesor {
    ArrayList<ProfesorModelo> profesores = new ArrayList();


    public static final String NOMBRE_TABLA = "Profesor";
    public static final String DNI_PROF =  "dni";
    public static  final String NOMBRE_PROF = "nombre";
    public static final String APE_PROF = "apellido";
    public static final String DOMIC_PROF="domicilio";
    public static final String TEL_PROF="telefono";

    public static final String CREATE_TABLE = "CREATE TABLE " + NOMBRE_TABLA + " ("
            + DNI_PROF + " integer primary key,"
            + NOMBRE_PROF + " text not null, "
            + APE_PROF + " text not null,"
            + DOMIC_PROF + " text,"
            + TEL_PROF + " text);";


    private DataBaseHelper helper;
    private SQLiteDatabase db;

    public DaoProfesor(Context context){
        helper = new DataBaseHelper(context);
        db = helper.getWritableDatabase();
        db = helper.getReadableDatabase();

    }

    public void crearProfesor(int dni, String nombre, String apellido, String domicilio, String telefono){
        ContentValues valores = new ContentValues();
        valores.put(DNI_PROF,dni);
        valores.put(NOMBRE_PROF,nombre);
        valores.put(APE_PROF, apellido);
        valores.put(DOMIC_PROF, domicilio);
        valores.put(TEL_PROF,telefono);
        db.insert(NOMBRE_TABLA,null,valores);
    }

    public ArrayList<ProfesorModelo> mostrarTodos(){

        String query = "SELECT * FROM Profesor";
        Cursor registro = db.rawQuery(query,null);
        if(registro.moveToFirst()){
            do{
                ProfesorModelo profeMode= new ProfesorModelo();
                profeMode.setDni(registro.getInt(0));
                profeMode.setNombre(registro.getString(1));
                profeMode.setApellido(registro.getString(2));
                profeMode.setDomicilio(registro.getString(3));
                profeMode.setTelefono(registro.getString(4));
                profesores.add(profeMode);
            }while(registro.moveToNext());
        }

        return profesores;
    }
    public int actualizar(ProfesorModelo profesorModelo){
        ContentValues valores = new ContentValues();
        valores.put(DNI_PROF,profesorModelo.getDni());
        valores.put(NOMBRE_PROF,profesorModelo.getNombre());
        valores.put(APE_PROF,profesorModelo.getApellido());
        valores.put(DOMIC_PROF,profesorModelo.getDomicilio());
        valores.put(TEL_PROF,profesorModelo.getTelefono());
        return db.update(NOMBRE_TABLA,valores,"dni=?",new String []{String.valueOf(profesorModelo.getDni())});
    }

    public int eliminar(int dni){

        return db.delete(NOMBRE_TABLA,"dni=?", new String []{String.valueOf(dni)});
    }

    public ProfesorModelo buscarPorApellido(String dato){
        ProfesorModelo profMode = new ProfesorModelo();
        String query = "SELECT * FROM " + NOMBRE_TABLA + " WHERE " + APE_PROF + " = " + dato;
        Cursor registro = db.rawQuery(query,null);

        if(registro.moveToFirst()){
            profMode.getDni();
            profMode.getNombre();
            profMode.getApellido();
            profMode.getDomicilio();
            profMode.getTelefono();

        }

        return profMode;

    }

}
