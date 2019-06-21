package com.example.proyectofinalcrespo.Alumno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.proyectofinalcrespo.R;

import java.util.ArrayList;

public class Alumno extends AppCompatActivity {



    ListView listaAlumnos;


    ArrayList<AlumnoModelo> alumnos = new ArrayList();

    ArrayAdapter<AlumnoModelo> arrayAdapter;

    DaoAlumno daoAlu;
    ImageView agregar, eliminar ,editar, buscar;
    EditText busqueda;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno);

        listaAlumnos = (ListView)findViewById(R.id.todosAlumnos);
        agregar = (ImageView) findViewById(R.id.imgAgregar);
        eliminar = (ImageView)findViewById(R.id.imgEliminar);
        editar = (ImageView)findViewById(R.id.imgEditar);
        busqueda = (EditText)findViewById(R.id.busqueda);
        buscar = (ImageView) findViewById(R.id.buscar);

        daoAlu = new DaoAlumno(this);
        alumnos = daoAlu.mostrarTodos();


        arrayAdapter = new ArrayAdapter<AlumnoModelo>(this,android.R.layout.simple_list_item_1,alumnos);
        listaAlumnos.setAdapter(arrayAdapter);


      /*  buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String buscado = busqueda.getText().toString();
            AlumnoModelo aluMode = new AlumnoModelo();
                aluMode= daoAlu.buscarPorApellido(buscado);
                Intent intent = new Intent(Alumno.this, AlumnoUpdate.class);
                intent.putExtra("Alumno",aluMode);
                startActivity(intent);
            }
        });

*/
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAgrega = new Intent(Alumno.this, AgregarAlumno.class);
                startActivity(intentAgrega);

            }
        });

        listaAlumnos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

              AlumnoModelo alumnoMode = alumnos.get(position);
              Intent intentUpdateAlumono = new Intent(Alumno.this,AlumnoUpdate.class);
              intentUpdateAlumono.putExtra("Alumno", alumnoMode);
              startActivity(intentUpdateAlumono);

            }
        });

    }
}
