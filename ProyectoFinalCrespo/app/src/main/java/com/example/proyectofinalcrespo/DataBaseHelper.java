package com.example.proyectofinalcrespo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.proyectofinalcrespo.Alumno.DaoAlumno;
import com.example.proyectofinalcrespo.Materia.DaoMateria;
import com.example.proyectofinalcrespo.Nota.DaoNota;
import com.example.proyectofinalcrespo.Profesor.DaoProfesor;
import com.example.proyectofinalcrespo.Usuario.DaoUsuario;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static String NOMBRE_BD = "Colegio.db";
    public static final int VERSION =1;


    public DataBaseHelper(Context context) {
        super(context, NOMBRE_BD, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(DaoUsuario.CREATE_TABLE);
    db.execSQL(DaoAlumno.CREATE_TABLE);
    db.execSQL(DaoProfesor.CREATE_TABLE);
    db.execSQL(DaoMateria.CREATE_TABLE);
    db.execSQL(DaoNota.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
