package com.example.proyectofinalcrespo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Alumno extends AppCompatActivity {

    ListView listaAlumnos;
    ArrayList<AlumnoModelo> alumnos = new ArrayList();
    ArrayAdapter adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno);
        listaAlumnos = (ListView)findViewById(R.id.todosAlumnos);
    }
}
