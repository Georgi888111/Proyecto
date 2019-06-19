package com.example.proyectofinalcrespo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

public class Alumno extends AppCompatActivity {

    ListView listaAlumnos;
    ArrayList<AlumnoModelo> alumnos = new ArrayList();
    ArrayAdapter adaptador;
    DaoAlumno daoAlu;
    ImageView agregar, eliminar ,editar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno);
        listaAlumnos = (ListView)findViewById(R.id.todosAlumnos);
        agregar = (ImageView) findViewById(R.id.imgAgregar);
        eliminar = (ImageView)findViewById(R.id.imgEliminar);
        editar = (ImageView)findViewById(R.id.imgEditar);
        daoAlu = new DaoAlumno(this);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });

    }
}
