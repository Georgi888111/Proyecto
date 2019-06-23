package com.example.proyectofinalcrespo.Profesor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectofinalcrespo.R;

public class AgregarProf extends AppCompatActivity {
    DaoProfesor daoProfesor;
    TextView agregar;
    EditText nombreProfesor,domicilioProfesor,apellidoProfesor,telefonoProfesor,dniProfesor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_prof);
        agregar = (TextView)findViewById(R.id.btn_agregar);
        nombreProfesor = (EditText) findViewById(R.id.nombre_prof);
        apellidoProfesor = (EditText) findViewById(R.id.apellido_prof);
        dniProfesor = (EditText)findViewById(R.id.dni_prof);
        domicilioProfesor = (EditText)findViewById(R.id.domicilio_prof);
        telefonoProfesor = (EditText)findViewById(R.id.telefono_prof);
        daoProfesor = new DaoProfesor(this);
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = nombreProfesor.getText().toString();
                String apellido = apellidoProfesor.getText().toString();
                String dni = dniProfesor.getText().toString();
                String domicilio = domicilioProfesor.getText().toString();
                String telefono = telefonoProfesor.getText().toString();

                if((nombre.equals(""))||(apellido.equals(""))||(dni.equals(""))){
                    Toast.makeText(AgregarProf.this, "El nombre, apellido y dni son obligatorios", Toast.LENGTH_SHORT).show();
                }else{
                    int dniFinal = Integer.parseInt(dni);
                    daoProfesor.crearProfesor(dniFinal,nombre,apellido,domicilio,telefono);
                    Intent volverATodosAlu = new Intent(AgregarProf.this, Profesor.class);
                    startActivity(volverATodosAlu);
                }
            }
        });

    }
}
