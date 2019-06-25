package com.example.proyectofinalcrespo.Nota;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectofinalcrespo.Alumno.AlumnoModelo;
import com.example.proyectofinalcrespo.Materia.MateriaModelo;
import com.example.proyectofinalcrespo.R;

import java.util.ArrayList;

public class AgregarNota extends AppCompatActivity {

    private Spinner muestraNombreMateria, muestraDniAlumno;
    private TextView agregar;
    private EditText nota, nombreAlumnoDni;
    private ImageView volver;
    private ArrayList<MateriaModelo> modemate;
    private ArrayList<AlumnoModelo> modealu;
    private DaoNota daoNota;
    private NotasSpinnerAdapter adapterSpinner;
    private NotasSpinnerAdapterDos adapterDos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_nota);

        muestraDniAlumno = (Spinner) findViewById(R.id.alumnosDni);
        muestraNombreMateria = (Spinner) findViewById(R.id.materiasNombres);
        agregar = (TextView) findViewById(R.id.btn_agregar);
        nota = (EditText) findViewById(R.id.nota);
        daoNota = new DaoNota(this);
        modealu = daoNota.retornaArrayAlumnos();
        modemate = daoNota.retornaArrayMaterias();
        nombreAlumnoDni = (EditText) findViewById(R.id.nombreAlumnoDni);
        volver = (ImageView) findViewById(R.id.volver);


        adapterSpinner = new NotasSpinnerAdapter(this, modealu);
        muestraDniAlumno.setAdapter(adapterSpinner);
        adapterDos = new NotasSpinnerAdapterDos(this,modemate);
        muestraNombreMateria.setAdapter(adapterDos);


        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int notaAlu = Integer.parseInt(nota.getText().toString());
                String materia = muestraNombreMateria.getSelectedItem().toString();
                int dniAlu = Integer.parseInt(muestraDniAlumno.getSelectedItem().toString());

                if (notaAlu > 10 || notaAlu < 0) {
                    Toast.makeText(AgregarNota.this, "La nota solo puede estar entre 0 y 10", Toast.LENGTH_SHORT).show();
                } else {
                    daoNota.crearNota(notaAlu, materia, dniAlu);
                    Intent intentCreaNota = new Intent(AgregarNota.this, Nota.class);
                    startActivity(intentCreaNota);
                }
            }
        });

        muestraDniAlumno.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nombreAlumnoDni.setText(modealu.get(position).getNombre() + " " + modealu.get(position).getApellido());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNota = new Intent(AgregarNota.this, Nota.class);
                startActivity(intentNota);
            }
        });


    }
}


