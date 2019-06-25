package com.example.proyectofinalcrespo.Materia;

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

import com.example.proyectofinalcrespo.Alumno.Alumno;
import com.example.proyectofinalcrespo.Profesor.ProfesorModelo;
import com.example.proyectofinalcrespo.R;

import java.util.ArrayList;

public class AgregarMateria extends AppCompatActivity {

    private Spinner muestraDniProf;
    private TextView agregar;
    private EditText descripcion, cantHoras, nombreProf;
    private ArrayList<ProfesorModelo> modeProfe;
    private DaoMateria daoMate;
    private ImageView volver;
    private MateriaSpinnerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_materia);

        daoMate = new DaoMateria(this);
        muestraDniProf = (Spinner) findViewById(R.id.dniProf);
        agregar = (TextView) findViewById(R.id.btn_agregar);
        modeProfe = daoMate.retornaArrayProfesor();
        descripcion = (EditText) findViewById(R.id.descrpcion);
        cantHoras = (EditText) findViewById(R.id.cantHoras);
        nombreProf = (EditText) findViewById(R.id.muestraNombreProf);
        volver = (ImageView) findViewById(R.id.volver);

        adapter = new MateriaSpinnerAdapter(this, modeProfe);
        muestraDniProf.setAdapter(adapter);

        muestraDniProf.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nombreProf.setText(modeProfe.get(position).getNombre() + " " + modeProfe.get(position).getApellido());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String descrMate = descripcion.getText().toString();
                int cantHorMate = Integer.parseInt(cantHoras.getText().toString());
                int dniProf = Integer.parseInt(muestraDniProf.getSelectedItem().toString());

                daoMate.crearMateria(descrMate, cantHorMate, dniProf);
                Intent intentCreaMate = new Intent(AgregarMateria.this, Materia.class);
                startActivity(intentCreaMate);
            }
        });


        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volverMateria = new Intent(AgregarMateria.this, Materia.class);
                startActivity(volverMateria);
            }
        });


    }
}
