package com.example.proyectofinalcrespo.Nota;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectofinalcrespo.Alumno.AlumnoModelo;
import com.example.proyectofinalcrespo.DataBaseHelper;
import com.example.proyectofinalcrespo.Materia.MateriaModelo;

import java.util.ArrayList;

public class DaoNota {

    ArrayList<NotaModelo> notas = new ArrayList();
    ArrayList<MateriaModelo>materias= new ArrayList();
    ArrayList<AlumnoModelo>alumnos = new ArrayList<>();


    public static final String NOMBRE_TABLA = "Nota";
    public static final String COD_NOT =  "codigo";
    public static  final String NOT_NOT = "nota";
    public static final String MATE_NOT = "materia";
    public static final String ALU_NOT="alumno";


    public static final String CREATE_TABLE = "CREATE TABLE " + NOMBRE_TABLA + " ("
            + COD_NOT + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + NOT_NOT + " integer not null, "
            + MATE_NOT + " text not null,"
            + ALU_NOT + " integer);";



    private DataBaseHelper helper;
    private SQLiteDatabase db;


    public DaoNota(Context context){
        helper = new DataBaseHelper(context);
        db = helper.getWritableDatabase();
        db = helper.getReadableDatabase();

    }

    public void crearNota(int nota,String materia,int dniAlu){
        ContentValues valores = new ContentValues();

        valores.put(NOT_NOT,nota);
        valores.put(MATE_NOT, materia);
        valores.put(ALU_NOT, dniAlu);

        db.insert(NOMBRE_TABLA,null,valores);
    }

    public ArrayList<NotaModelo> mostrarTodos(){

        String query = "SELECT * FROM Nota";
        Cursor registro = db.rawQuery(query,null);
        if(registro.moveToFirst()){
            do{
                NotaModelo notaMode= new NotaModelo();
                notaMode.setCodigo(registro.getInt(0));
                notaMode.setNota(registro.getInt(1));
                notaMode.setMateria(registro.getString(2));
                notaMode.setDniAlu(registro.getInt(3));
                notas.add(notaMode);

            }while(registro.moveToNext());
        }

        return notas;
    }

    public ArrayList<AlumnoModelo> retornaArrayAlumnos(){

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

    public ArrayList<MateriaModelo> retornaArrayMaterias(){

        String query = "SELECT * FROM Materia";
        Cursor registro = db.rawQuery(query,null);
        if(registro.moveToFirst()){
            do{
                MateriaModelo mateMode= new MateriaModelo();
                mateMode.setCodigo(registro.getInt(0));
                mateMode.setDescripcion(registro.getString(1));
                mateMode.setCantHoras(registro.getInt(2));
                mateMode.setDniProf(registro.getInt(3));
                materias.add(mateMode);


            }while(registro.moveToNext());
        }

        return materias;
    }

    public int actualizar(NotaModelo notaModelo){
        ContentValues valores = new ContentValues();
        valores.put(NOT_NOT,notaModelo.getNota());
        valores.put(MATE_NOT,notaModelo.getMateria());
        valores.put(ALU_NOT,notaModelo.getDniAlu());

        return db.update(NOMBRE_TABLA,valores,"codigo=?",new String []{String.valueOf(notaModelo.getCodigo())});
    }

    public int eliminar(int codigo){

        return db.delete(NOMBRE_TABLA,"codigo=?", new String []{String.valueOf(codigo)});
    }

}
