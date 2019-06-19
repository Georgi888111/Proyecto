package com.example.proyectofinalcrespo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DaoUsuario extends SQLiteOpenHelper {

    public static class FeedEntry implements BaseColumns {

        private static final String TABLA_NOMBRE = "Usuario";
        private static final String COLUMN_ID = "id_usuario";
        private static final String COLUMN_NOMBRE_USU= "nombre_usu";
        private static final String COLUMN_PASSWORD = "password";


    }

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "FinalCrespo.db";
    SQLiteDatabase db;

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + FeedEntry.TABLA_NOMBRE + " (" +
                    FeedEntry.COLUMN_ID + "  INTEGER PRIMARY KEY," +
                    FeedEntry.COLUMN_NOMBRE_USU + " TEXT," +
                    FeedEntry.COLUMN_PASSWORD + " TEXT)" ;

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + FeedEntry.TABLA_NOMBRE;

    public DaoUsuario(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void InsertarUsuario(Usuario usuario) {

        db = getWritableDatabase();
        String query = "SELECT * FROM " + FeedEntry.TABLA_NOMBRE ;
        Cursor cursor = db.rawQuery(query, null);
        int count = cursor.getCount();

        ContentValues contentvalues = new ContentValues();
        contentvalues.put(FeedEntry.COLUMN_ID, count + 1);
        contentvalues.put(FeedEntry.COLUMN_NOMBRE_USU, usuario.getNombre_usuario());
        contentvalues.put(FeedEntry.COLUMN_PASSWORD, usuario.getContraseña());

        db.insert(FeedEntry.TABLA_NOMBRE, null, contentvalues);
        db.close();
    }

    public String LoginIn(String nombreUsuario) {
        db = this.getReadableDatabase();
        String query = "SELECT nombre_usu,password FROM  " + FeedEntry.TABLA_NOMBRE;
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
