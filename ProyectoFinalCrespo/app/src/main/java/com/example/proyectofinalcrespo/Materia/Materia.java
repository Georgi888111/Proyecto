package com.example.proyectofinalcrespo.Materia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.proyectofinalcrespo.R;

import java.util.ArrayList;

public class Materia extends AppCompatActivity {

    ListView listaMaterias;
    ImageView agregar;
    ArrayList<MateriaModelo> materias = new ArrayList();

    ArrayAdapter<MateriaModelo> arrayAdapter;

    DaoMateria daoMate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia);

        listaMaterias = (ListView) findViewById(R.id.todasMaterias);
       agregar = (ImageView) findViewById(R.id.imgAgregar);

        daoMate = new DaoMateria(this);
        materias = daoMate.mostrarTodos();


        arrayAdapter = new ArrayAdapter<MateriaModelo>(this,android.R.layout.simple_list_item_1,materias);
        listaMaterias.setAdapter(arrayAdapter);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent agregaMateria = new Intent(Materia.this,AgregarMateria.class);
                startActivity(agregaMateria);
            }
        });




    }
}
