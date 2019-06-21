package com.example.proyectofinalcrespo.Alumno;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectofinalcrespo.Alumno.AlumnoModelo;
import com.example.proyectofinalcrespo.DataBaseHelper;

import java.util.ArrayList;

public class DaoAlumno {

    ArrayList<AlumnoModelo>alumnos = new ArrayList();


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

    public ArrayList<AlumnoModelo> mostrarTodos(){

      String query = "SELECT * FROM Alumno";
      Cursor registro = db.rawQuery(query,null);
      if(registro.moveToFirst()){
          do{
              AlumnoModelo aluMode= new AlumnoModelo();
              aluMode.setDni(registro.getInt(0));
              aluMode.setNombre(registro.getString(1));
              aluMode.setApellido(registro.getString(2));
              aluMode.setDomicilio(registro.getString(3));
              aluMode.setTelefono(registro.getString(4));
              alumnos.add(aluMode);
          }while(registro.moveToNext());
      }

      return alumnos;
    }
    public ArrayList<String> mostrarTitulos(){
        ArrayList<String>alumnosTitulo = new ArrayList<>();
        String query = "SELECT * FROM Alumno";
        Cursor registro = db.rawQuery(query,null);
        if(registro.moveToFirst()){
            do{
              alumnosTitulo.add(registro.getString(1) + " " + registro.getString(2));
            }while(registro.moveToNext());
        }

        return alumnosTitulo;
    }

    public int actualizar(AlumnoModelo alumnoModelo){
        ContentValues valores = new ContentValues();
        valores.put(DNI_ALU,alumnoModelo.getDni());
        valores.put(NOMBRE_ALU,alumnoModelo.getNombre());
        valores.put(APE_ALU,alumnoModelo.getApellido());
        valores.put(DOMIC_ALU,alumnoModelo.getDomicilio());
        valores.put(TEL_ALU,alumnoModelo.getTelefono());
      return db.update(NOMBRE_TABLA,valores,"dni=?",new String []{String.valueOf(alumnoModelo.getDni())});
    }

    public int eliminar(int dni){

        return db.delete(NOMBRE_TABLA,"dni=?", new String []{String.valueOf(dni)});
    }

    public AlumnoModelo buscarPorApellido(String dato){
      AlumnoModelo aluMode = new AlumnoModelo();
      String query = "SELECT * FROM " + NOMBRE_TABLA + " WHERE " + APE_ALU + " = " + dato;
      Cursor registro = db.rawQuery(query,null);

      if(registro.moveToFirst()){
          aluMode.getDni();
          aluMode.getNombre();
          aluMode.getApellido();
          aluMode.getDomicilio();
          aluMode.getTelefono();

      }

    return aluMode;

    }
}
