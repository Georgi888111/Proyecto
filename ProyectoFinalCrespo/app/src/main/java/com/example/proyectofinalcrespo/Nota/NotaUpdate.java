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
import android.widget.Toast;

import com.example.proyectofinalcrespo.Alumno.AlumnoModelo;
import com.example.proyectofinalcrespo.Materia.MateriaModelo;
import com.example.proyectofinalcrespo.R;

import java.util.ArrayList;

public class NotaUpdate extends AppCompatActivity {

    private ImageView editar,eliminar,volver;
    private EditText nota,nombreAlumnoDni, codigo;
    private Spinner muestraNombreMateria,muestraDniAlumno;
    private ArrayList<MateriaModelo> modemate;
    private ArrayList<AlumnoModelo> modealu;
    private NotasSpinnerAdapter adapterSpinner;
    private NotasSpinnerAdapterDos adapterDos;
    private DaoNota daoNota;
    private String inicializarItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota_update);

        editar = (ImageView)findViewById(R.id.imgEditar);
        eliminar = (ImageView)findViewById(R.id.imgEliminar);
        nota=(EditText)findViewById(R.id.nota);
        daoNota = new DaoNota(this);
        modealu = daoNota.retornaArrayAlumnos();
        modemate = daoNota.retornaArrayMaterias();
        codigo = (EditText) findViewById(R.id.codigoCod);
        nombreAlumnoDni = (EditText) findViewById(R.id.nombreAlumnoDni);
        muestraDniAlumno = (Spinner)findViewById(R.id.alumnosDni);
        muestraNombreMateria = (Spinner)findViewById(R.id.materiasNombres);
        volver = (ImageView) findViewById(R.id.volver);


        adapterSpinner = new NotasSpinnerAdapter(this, modealu);
        muestraDniAlumno.setAdapter(adapterSpinner);
        adapterDos = new NotasSpinnerAdapterDos(this,modemate);
        muestraNombreMateria.setAdapter(adapterDos);


        NotaModelo notaMode = (NotaModelo) getIntent().getExtras().getSerializable("nota");

        nota.setText(String.valueOf(notaMode.getNota()));
        codigo.setText(String.valueOf(notaMode.getCodigo()));

        //inicializarItem = String.valueOf(notaMode.getDniAlu());


        /*for (int i=0; i<muestraDniAlumno.getAdapter().getCount();i++){
           if (muestraDniAlumno.getItemAtPosition(i).toString().equalsIgnoreCase(inicializarItem)) {
               muestraDniAlumno.setSelection(i);
               break;

           }
       }*/





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

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int notaAlu = Integer.parseInt(nota.getText().toString());
                String materia = muestraNombreMateria.getSelectedItem().toString();
                int dniAlu =Integer.parseInt(muestraDniAlumno.getSelectedItem().toString());
                int codigoNota = Integer.parseInt(codigo.getText().toString());
                NotaModelo notaModelo = new NotaModelo(notaAlu,dniAlu,materia,codigoNota);
                int result = daoNota.actualizar(notaModelo);

                if(result>0){
                    Toast.makeText(NotaUpdate.this,"Nota modificada",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(NotaUpdate.this, Nota.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(NotaUpdate.this,"Hubo un problema al modificar",Toast.LENGTH_SHORT).show();
                }



            }
        });



        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int codigoMateria = Integer.parseInt(codigo.getText().toString());

                int result = daoNota.eliminar(codigoMateria);
                if(result>0){
                    Toast.makeText(NotaUpdate.this,"Nota Eliminada",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(NotaUpdate.this, Nota.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(NotaUpdate.this,"Hubo un problema al eliminar",Toast.LENGTH_SHORT).show();
                }

            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volverNota = new Intent(NotaUpdate.this, Nota.class);
                startActivity(volverNota);
            }
        });
    }





}
