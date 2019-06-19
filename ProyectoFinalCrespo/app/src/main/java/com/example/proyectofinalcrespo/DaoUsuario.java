package com.example.proyectofinalcrespo;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DaoUsuario {

    public static final String NOMBRE_TABLA = "Usuarios";
    public static final String CN_ID = "id_usuario";
    public static final String CN_NAME = "nombre_usuario";
    public static final String CN_CONTRASEÑA = "contraseña";



    public static final String CREATE_TABLE = "CREATE TABLE " + NOMBRE_TABLA + " ("
            + CN_ID + " integer primary key autoincrement,"
            + CN_NAME + " text not null, "
            + CN_CONTRASEÑA + " text);";

    private DataBaseHelper helper;
    private SQLiteDatabase db;

    public DaoUsuario(Context context){
     helper = new DataBaseHelper(context);
      db = helper.getWritableDatabase();
      db = helper.getReadableDatabase();

    }

    public void crearUsuario(String nombreUsu, String contraseña){
        ContentValues valores = new ContentValues();
        valores.put(CN_NAME,nombreUsu);
        valores.put(CN_CONTRASEÑA,contraseña);
        db.insert(NOMBRE_TABLA,null,valores);
    }

    public String LoginIn(String nombreUsuario) {

        String query = "SELECT nombre_usuario,contraseña FROM  " + NOMBRE_TABLA;
        Cursor corsor = db.rawQuery(query, null);
        String nombre_usu, contraseña;
        contraseña = "Not found";
        if (corsor.moveToFirst()) {
            do {
                nombre_usu = corsor.getString(0);
                if (nombre_usu.contentEquals(nombreUsuario)) {
                    contraseña = corsor.getString(1);
                    break;
                }
            } while (corsor.moveToNext());
        }
        return contraseña;
    }
}