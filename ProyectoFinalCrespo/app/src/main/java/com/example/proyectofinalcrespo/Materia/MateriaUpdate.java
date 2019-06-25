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
import android.widget.Toast;

import com.example.proyectofinalcrespo.Profesor.ProfesorModelo;
import com.example.proyectofinalcrespo.R;

import java.util.ArrayList;

public class MateriaUpdate extends AppCompatActivity {
    private Spinner muestraDniProf;
    private EditText descripcion, cantHoras,nombreProf, codigo;
    private ImageView editar,eliminar, volver;
    private ArrayList<ProfesorModelo> profeMode;
    private DaoMateria daoMate;
    private MateriaSpinnerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia_update);

        muestraDniProf =(Spinner) findViewById(R.id.dniProf);
        descripcion = (EditText) findViewById(R.id.descrpcion);
        cantHoras = (EditText)findViewById(R.id.cantHoras);
        nombreProf = (EditText)findViewById(R.id.muestraNombreProf);
        codigo = (EditText)findViewById(R.id.codigoMateria);
        editar = (ImageView)findViewById(R.id.imgEditar);
        eliminar = (ImageView)findViewById(R.id.imgEliminar);
        daoMate = new DaoMateria(this);
        profeMode = daoMate.retornaArrayProfesor();
        volver = (ImageView) findViewById(R.id.volver);

        adapter = new MateriaSpinnerAdapter(this,profeMode);
        muestraDniProf.setAdapter(adapter);

        muestraDniProf.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                nombreProf.setText(profeMode.get(position).getNombre() + " " + profeMode.get(position).getApellido());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //Another interface callback
            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volverMateria = new Intent(MateriaUpdate.this, Materia.class);
                startActivity(volverMateria);
            }
        });
        MateriaModelo mateMode = (MateriaModelo) getIntent().getExtras().getSerializable("Materia");

        descripcion.setText(mateMode.getDescripcion());
        cantHoras.setText(String.valueOf(mateMode.getCantHoras()));
        codigo.setText(String.valueOf(mateMode.getCodigo()));




        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String descMateria = descripcion.getText().toString();
                int cantidadHoras = Integer.parseInt(cantHoras.getText().toString());
                int dniProf =Integer.parseInt(muestraDniProf.getSelectedItem().toString());
                int codigoMateria = Integer.parseInt(codigo.getText().toString());
                MateriaModelo materiaModelo = new MateriaModelo(descMateria,cantidadHoras,dniProf,codigoMateria);
                int result = daoMate.actualizar(materiaModelo);

                if(result>0){
                    Toast.makeText(MateriaUpdate.this,"Materia modificada",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MateriaUpdate.this, Materia.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MateriaUpdate.this,"Hubo un problema al modificar",Toast.LENGTH_SHORT).show();
                }



            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String codigoMateria = codigo.getText().toString();
                int codMat = Integer.parseInt(codigoMateria);
                int result = daoMate.eliminar(codMat);
                if(result>0){
                    Toast.makeText(MateriaUpdate.this,"Materia Eliminada",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MateriaUpdate.this, Materia.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MateriaUpdate.this,"Hubo un problema al eliminar",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }



}
