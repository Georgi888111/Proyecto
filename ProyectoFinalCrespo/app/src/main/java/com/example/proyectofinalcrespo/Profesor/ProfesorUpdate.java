package com.example.proyectofinalcrespo.Profesor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.proyectofinalcrespo.R;

public class ProfesorUpdate extends AppCompatActivity {

    private EditText nombreProfesor,domicilioProfesor,apellidoProfesor,telefonoProfesor,dniProfesor;
    private DaoProfesor daoProf;
    private ImageView editar,eliminar, volver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesor_update);

        nombreProfesor = (EditText)findViewById(R.id.nombre_prof);
        domicilioProfesor = (EditText)findViewById(R.id.domicilio_prof);
        apellidoProfesor = (EditText)findViewById(R.id.apellido_prof);
        dniProfesor = (EditText)findViewById(R.id.dni_prof);
        telefonoProfesor = (EditText)findViewById(R.id.telefono_prof);
        daoProf = new DaoProfesor(this);
        editar = (ImageView)findViewById(R.id.imgEditar);
        eliminar =(ImageView)findViewById(R.id.imgEliminar);
        volver = (ImageView) findViewById(R.id.volver);

        ProfesorModelo profMode = (ProfesorModelo)getIntent().getExtras().getSerializable("Profesor");
        nombreProfesor.setText(profMode.getNombre());
        domicilioProfesor.setText(profMode.getDomicilio());
        apellidoProfesor.setText(profMode.getApellido());
        dniProfesor.setText(String.valueOf(profMode.getDni()));
        telefonoProfesor.setText(profMode.getTelefono());


        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = nombreProfesor.getText().toString();
                String apellido = apellidoProfesor.getText().toString();
                String domicilio = domicilioProfesor.getText().toString();
                String telefono = telefonoProfesor.getText().toString();
                String dni = dniProfesor.getText().toString();

                int dniProfe = Integer.parseInt(dni);

                ProfesorModelo profesorModelo = new ProfesorModelo(nombre,apellido,dniProfe,domicilio,telefono);
                int result = daoProf.actualizar(profesorModelo);

                if(result>0){
                    Toast.makeText(ProfesorUpdate.this,"Profesor modificado",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ProfesorUpdate.this, Profesor.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(ProfesorUpdate.this,"Hubo un problema al modificar",Toast.LENGTH_SHORT).show();
                }

            }
        });

        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dni = dniProfesor.getText().toString();
                int dniProf = Integer.parseInt(dni);
                int result = daoProf.eliminar(dniProf);
                if(result>0){
                    Toast.makeText(ProfesorUpdate.this,"Profesor Eliminado",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ProfesorUpdate.this, Profesor.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(ProfesorUpdate.this,"Hubo un problema al eliminar",Toast.LENGTH_SHORT).show();
                }


            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volverProfesor = new Intent(ProfesorUpdate.this,Profesor.class);
                startActivity(volverProfesor);
            }
        });
    }
}
