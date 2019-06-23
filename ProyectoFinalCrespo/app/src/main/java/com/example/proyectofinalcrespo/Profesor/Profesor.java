package com.example.proyectofinalcrespo.Profesor;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import com.example.proyectofinalcrespo.R;
import java.util.ArrayList;

public class Profesor extends AppCompatActivity {

    ImageView agregar, buscar;
    EditText busqueda;
    ProfesoresAdapter adapter;
    ListView listaProfesores;
    ArrayList<ProfesorModelo>profesores = new ArrayList();
    DaoProfesor daoProfe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesor);
        agregar = (ImageView)findViewById(R.id.imgAgregar);
        listaProfesores = (ListView) findViewById(R.id.todosProfesores);
        daoProfe = new DaoProfesor(this);
        profesores = daoProfe.mostrarTodos();
        busqueda = (EditText) findViewById(R.id.busqueda);
        buscar = (ImageView)findViewById(R.id.buscar);


        adapter = new ProfesoresAdapter(this,profesores);
        listaProfesores.setAdapter(adapter);


        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAgrega = new Intent(Profesor.this, AgregarProf.class);
                startActivity(intentAgrega);

            }
        });

         buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String buscado = busqueda.getText().toString();
            ProfesorModelo profesorModelo;
                profesorModelo= daoProfe.buscar(buscado);
                Intent intentUpdateProfesor = new Intent(Profesor.this, ProfesorUpdate.class);
                intentUpdateProfesor.putExtra("Profesor",profesorModelo);
                startActivity(intentUpdateProfesor);
            }
        });


        listaProfesores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ProfesorModelo profeMode = profesores.get(position);
                Intent intentUpdateProfesor = new Intent(Profesor.this,ProfesorUpdate.class);
                intentUpdateProfesor.putExtra("Profesor", profeMode);
                startActivity(intentUpdateProfesor);

            }
        });


    }




    }

