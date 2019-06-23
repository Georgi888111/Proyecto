package com.example.proyectofinalcrespo.Nota;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

    ImageView editar,eliminar;
    EditText nota,codigo;
    Spinner muestraNombreMateria,muestraDniAlumno;
    ArrayList<MateriaModelo> modemate;
    ArrayList<AlumnoModelo> modealu;
    ArrayList<String> infoNombreMateria;
    ArrayList<String>infoAlumno;
    DaoNota daoNota;

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
        infoNombreMateria = obtenerListaMaterias();
        codigo = (EditText) findViewById(R.id.codigoNota);
        infoAlumno = obtenerListaAlumnos();
        muestraDniAlumno = (Spinner)findViewById(R.id.alumnosDni);
        muestraNombreMateria = (Spinner)findViewById(R.id.materiasNombres);

        NotaModelo notaMode = (NotaModelo) getIntent().getExtras().getSerializable("nota");

        nota.setText(String.valueOf(notaMode.getNota()));
        codigo.setText(String.valueOf(notaMode.getCodigo()));

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,infoNombreMateria);
        muestraNombreMateria.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapterDos = new ArrayAdapter(this,android.R.layout.simple_spinner_item,infoAlumno);
        muestraDniAlumno.setAdapter(adapterDos);

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
