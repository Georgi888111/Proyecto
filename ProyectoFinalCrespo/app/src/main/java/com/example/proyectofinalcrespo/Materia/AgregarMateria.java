package com.example.proyectofinalcrespo.Materia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.proyectofinalcrespo.Profesor.ProfesorModelo;
import com.example.proyectofinalcrespo.R;

import java.util.ArrayList;

public class AgregarMateria extends AppCompatActivity  {

    Spinner muestraDniProf;
    TextView agregar;
    EditText descripcion, cantHoras,nombreProf;

    ArrayList<ProfesorModelo>modeProfe;
    ArrayList<String> infoPrfesores;
    DaoMateria daoMate;
    ArrayAdapter<String> adapterSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_materia);
        daoMate = new DaoMateria(this);
        muestraDniProf =(Spinner) findViewById(R.id.dniProf);
        agregar = (TextView)findViewById(R.id.btn_agregar);
        modeProfe = daoMate.retornaArrayProfesor();
        infoPrfesores = obtenerListaInfo();
        descripcion = (EditText) findViewById(R.id.descrpcion);
        cantHoras = (EditText)findViewById(R.id.cantHoras);
        nombreProf = (EditText)findViewById(R.id.muestraNombreProf);


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



        ArrayAdapter<CharSequence>adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,infoPrfesores);
        muestraDniProf.setAdapter(adapter);


        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String descrMate = descripcion.getText().toString();
                int cantHorMate = Integer.parseInt(cantHoras.getText().toString());
                int dniProf = Integer.parseInt(muestraDniProf.getSelectedItem().toString());

                daoMate.crearMateria(descrMate,cantHorMate,dniProf);
                Intent intentCreaMate = new Intent(AgregarMateria.this,Materia.class);
                startActivity(intentCreaMate);
            }
        });

        adapterSpinner = new ArrayAdapter(this,R.layout.spinner_item,infoPrfesores);
        muestraDniProf.setAdapter(adapterSpinner);



    }

    public ArrayList <String> obtenerListaInfo(){
       infoPrfesores = new ArrayList();

       for(int i=0;i<modeProfe.size();i++){
          infoPrfesores.add(String.valueOf(modeProfe.get(i).getDni()));


       }
       return infoPrfesores;

    }


}
