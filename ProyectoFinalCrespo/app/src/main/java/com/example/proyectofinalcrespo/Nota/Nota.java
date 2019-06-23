package com.example.proyectofinalcrespo.Nota;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.proyectofinalcrespo.R;

import java.util.ArrayList;

public class Nota extends AppCompatActivity {

    ListView listaNotas;
    ImageView agregar;
    ArrayList<NotaModelo> notas = new ArrayList();

    ArrayAdapter<NotaModelo> arrayAdapter;

    DaoNota daoNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota);

        listaNotas = (ListView)findViewById(R.id.todasNotas);
        agregar = (ImageView)findViewById(R.id.imgAgregar);
        daoNota = new DaoNota(this);
        notas = daoNota.mostrarTodos();

        arrayAdapter = new ArrayAdapter<NotaModelo>(this,android.R.layout.simple_list_item_1,notas);
        listaNotas.setAdapter(arrayAdapter);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent agregaMateria = new Intent(Nota.this,AgregarNota.class);
                startActivity(agregaMateria);
            }
        });


        listaNotas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                NotaModelo notaMode = notas.get(position);
                Intent intentUpdateNota = new Intent(Nota.this,NotaUpdate.class);
                intentUpdateNota.putExtra("nota", notaMode);
                startActivity(intentUpdateNota);

            }
        });


    }


}
