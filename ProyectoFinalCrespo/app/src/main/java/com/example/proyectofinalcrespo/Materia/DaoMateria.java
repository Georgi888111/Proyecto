package com.example.proyectofinalcrespo.Materia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectofinalcrespo.DataBaseHelper;
import com.example.proyectofinalcrespo.Profesor.ProfesorModelo;

import java.util.ArrayList;

public class DaoMateria {



        ArrayList<MateriaModelo> materias = new ArrayList();
        ArrayList<ProfesorModelo>profesores= new ArrayList();


        public static final String NOMBRE_TABLA = "Materia";
        public static final String COD_MAT =  "codigo";
        public static  final String DESCR_MAT = "descripcion";
        public static final String CANT_HORAS = "cantHoras";
        public static final String DNI_PROF="dniProf";


        public static final String CREATE_TABLE = "CREATE TABLE " + NOMBRE_TABLA + " ("
                + COD_MAT + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DESCR_MAT + " text not null, "
                + CANT_HORAS + " text not null,"
                + DNI_PROF + " text);";



        private DataBaseHelper helper;
        private SQLiteDatabase db;


        public DaoMateria(Context context){
            helper = new DataBaseHelper(context);
            db = helper.getWritableDatabase();
            db = helper.getReadableDatabase();

        }

        public void crearMateria(String descripcion, int cantidad, int dniProf){
            ContentValues valores = new ContentValues();

            valores.put(DESCR_MAT,descripcion);
            valores.put(CANT_HORAS, cantidad);
            valores.put(DNI_PROF, dniProf);

            db.insert(NOMBRE_TABLA,null,valores);
        }

        public ArrayList<MateriaModelo> mostrarTodos(){

            String query = "SELECT * FROM Materia";
            Cursor registro = db.rawQuery(query,null);
            if(registro.moveToFirst()){
                do{
                    MateriaModelo mateMode= new MateriaModelo();
                    ProfesorModelo modeProf = new ProfesorModelo();
                    mateMode.setDescripcion(registro.getString(1));
                    mateMode.setCantHoras(registro.getInt(2));
                    mateMode.getProfeMode().setDni(registro.getInt(3));
                    materias.add(mateMode);

                }while(registro.moveToNext());
            }

            return materias;
        }

    public ArrayList<ProfesorModelo> retornaArrayProfesor(){

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
}
