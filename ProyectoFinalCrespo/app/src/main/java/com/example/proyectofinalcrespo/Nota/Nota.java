package com.example.proyectofinalcrespo.Nota;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.proyectofinalcrespo.Home;
import com.example.proyectofinalcrespo.R;

import java.util.ArrayList;

public class Nota extends AppCompatActivity {

    private ListView listaNotas;
    private ImageView agregar, buscar, volver;
    private ArrayList<NotaModelo> notas = new ArrayList();
    private TextView busqueda;
    private DaoNota daoNota;
    private NotasAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota);

        listaNotas = (ListView)findViewById(R.id.todasNotas);
        agregar = (ImageView)findViewById(R.id.imgAgregar);
        daoNota = new DaoNota(this);
        notas = daoNota.mostrarTodos();
        busqueda = (TextView) findViewById(R.id.busqueda);
        buscar = (ImageView) findViewById(R.id.buscar);
        volver = (ImageView) findViewById(R.id.volver);

        adapter = new NotasAdapter(this,notas);
        listaNotas.setAdapter(adapter);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent agregaMateria = new Intent(Nota.this,AgregarNota.class);
                startActivity(agregaMateria);
            }
        });

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buscado = busqueda.getText().toString();
                NotaModelo notaModelo;
                notaModelo= daoNota.buscar(buscado);
                Intent intentUpdateNota = new Intent(Nota.this, NotaUpdate.class);
                intentUpdateNota.putExtra("nota",notaModelo);
                startActivity(intentUpdateNota);
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

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volverHome = new Intent(Nota.this, Home.class);
                startActivity(volverHome);
            }
        });


    }


}
