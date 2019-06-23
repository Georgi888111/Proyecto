package com.example.proyectofinalcrespo.Nota;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.proyectofinalcrespo.Alumno.AlumnoModelo;
import com.example.proyectofinalcrespo.Materia.MateriaModelo;
import com.example.proyectofinalcrespo.R;

import java.util.ArrayList;

public class AgregarNota extends AppCompatActivity {

    Spinner muestraNombreMateria,muestraDniAlumno;
    TextView agregar;
    EditText nota;

    ArrayList<MateriaModelo> modemate;
    ArrayList<AlumnoModelo> modealu;
    ArrayList<String> infoNombreMateria;
    ArrayList<String>infoAlumno;
    DaoNota daoNota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_nota);
        muestraDniAlumno = (Spinner)findViewById(R.id.alumnosDni);
        muestraNombreMateria = (Spinner)findViewById(R.id.materiasNombres);
        agregar = (TextView) findViewById(R.id.btn_agregar);
        nota = (EditText) findViewById(R.id.nota);
        daoNota = new DaoNota(this);
        modealu = daoNota.retornaArrayAlumnos();
        modemate = daoNota.retornaArrayMaterias();
        infoNombreMateria = obtenerListaMaterias();
        infoAlumno = obtenerListaAlumnos();

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,infoNombreMateria);
        muestraNombreMateria.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapterDos = new ArrayAdapter(this,android.R.layout.simple_spinner_item,infoAlumno);
        muestraDniAlumno.setAdapter(adapterDos);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int notaAlu = Integer.parseInt(nota.getText().toString());
                String materia = muestraNombreMateria.getSelectedItem().toString();
                int dniAlu = Integer.parseInt(muestraDniAlumno.getSelectedItem().toString());


                daoNota.crearNota(notaAlu,materia,dniAlu);
                Intent intentCreaNota = new Intent(AgregarNota.this,Nota.class);
                startActivity(intentCreaNota);
            }
        });

    }

    public ArrayList <String> obtenerListaMaterias(){
        infoNombreMateria = new ArrayList();
        infoNombreMateria.add(" ");
        for(int i=0;i<modemate.size();i++){
            infoNombreMateria.add(modemate.get(i).getDescripcion());

        }
        return infoNombreMateria;

    }

    public ArrayList <String> obtenerListaAlumnos(){
        infoAlumno = new ArrayList();
        infoAlumno.add(" ");
        for(int i=0;i<modealu.size();i++){
            infoAlumno.add(String.valueOf(modealu.get(i).getDni()));

        }
        return infoAlumno;

    }
}
