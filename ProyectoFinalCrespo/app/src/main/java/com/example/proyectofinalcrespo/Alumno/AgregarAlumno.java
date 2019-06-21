package com.example.proyectofinalcrespo.Alumno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectofinalcrespo.R;

public class AgregarAlumno extends AppCompatActivity {

    EditText nombreAumno,domicilioAlumno,apellidoAlumno,telefonoAlumno,dniAlumno;
    TextView agregaAlumno;
    DaoAlumno daoAlu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_alumno);
        nombreAumno = (EditText)findViewById(R.id.nombre_alumno);
        domicilioAlumno = (EditText)findViewById(R.id.domicilio_alumno);
        apellidoAlumno = (EditText)findViewById(R.id.apellido_alumno);
        dniAlumno = (EditText)findViewById(R.id.dni_alumno);
        telefonoAlumno = (EditText)findViewById(R.id.telefono_alumno);
        agregaAlumno = (TextView)findViewById(R.id.btn_agregar);

        daoAlu = new DaoAlumno(this);

        agregaAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = nombreAumno.getText().toString();
                String apellido = apellidoAlumno.getText().toString();
                String dni = dniAlumno.getText().toString();
                String domicilio = domicilioAlumno.getText().toString();
                String telefono = telefonoAlumno.getText().toString();

                if((nombre.equals(""))||(apellido.equals(""))||(dni.equals(""))){
                    Toast.makeText(AgregarAlumno.this, "El nombre, apellido y dni son obligatorios", Toast.LENGTH_SHORT).show();
                }else{
                    int dniFinal = Integer.parseInt(dni);
                    daoAlu.crearAlumno(dniFinal,nombre,apellido,domicilio,telefono);
                    Intent volverATodosAlu = new Intent(AgregarAlumno.this, Alumno.class);
                    startActivity(volverATodosAlu);
                }
            }
        });



    }
}
