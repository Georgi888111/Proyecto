package com.example.proyectofinalcrespo.Alumno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.proyectofinalcrespo.R;

public class AlumnoUpdate extends AppCompatActivity {

    EditText nombreAumno,domicilioAlumno,apellidoAlumno,telefonoAlumno,dniAlumno;
    DaoAlumno daoAlu;
    ImageView editar,eliminar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno_update);

        nombreAumno = (EditText)findViewById(R.id.nombre_alumno);
        domicilioAlumno = (EditText)findViewById(R.id.domicilio_alumno);
        apellidoAlumno = (EditText)findViewById(R.id.apellido_alumno);
        dniAlumno = (EditText)findViewById(R.id.dni_alumno);
        telefonoAlumno = (EditText)findViewById(R.id.telefono_alumno);
        daoAlu = new DaoAlumno(this);
        editar = (ImageView)findViewById(R.id.imgEditar);
        eliminar =(ImageView)findViewById(R.id.imgEliminar);


        AlumnoModelo aluMode = (AlumnoModelo)getIntent().getExtras().getSerializable("Alumno");


        nombreAumno.setText(aluMode.getNombre());
        domicilioAlumno.setText(aluMode.getDomicilio());
        apellidoAlumno.setText(aluMode.getApellido());
        dniAlumno.setText(String.valueOf(aluMode.getDni()));
        telefonoAlumno.setText(aluMode.getTelefono());


        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = nombreAumno.getText().toString();
                String apellido = apellidoAlumno.getText().toString();
                String domicilio = domicilioAlumno.getText().toString();
                String telefono = telefonoAlumno.getText().toString();
                String dni = dniAlumno.getText().toString();

                int dniAlumno = Integer.parseInt(dni);

                AlumnoModelo alumnoModelo = new AlumnoModelo(nombre,apellido,dniAlumno,domicilio,telefono);
                int result = daoAlu.actualizar(alumnoModelo);

                if(result>0){
                    Toast.makeText(AlumnoUpdate.this,"Alumno modificado",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AlumnoUpdate.this, Alumno.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(AlumnoUpdate.this,"Hubo un problema al modificar",Toast.LENGTH_SHORT).show();
                }

            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dni = dniAlumno.getText().toString();
                int dniAlumno = Integer.parseInt(dni);
                int result = daoAlu.eliminar(dniAlumno);
                if(result>0){
                    Toast.makeText(AlumnoUpdate.this,"Alumno Eliminado",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AlumnoUpdate.this, Alumno.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(AlumnoUpdate.this,"Hubo un problema al eliminar",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }




}

