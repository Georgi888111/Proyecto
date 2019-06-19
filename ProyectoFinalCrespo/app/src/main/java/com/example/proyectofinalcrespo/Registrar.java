package com.example.proyectofinalcrespo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Registrar extends AppCompatActivity implements View.OnClickListener {

 EditText usuario_reg;
 EditText contraseña_reg;
 EditText contraseñaRepe_reg;
 TextView regis;
 DaoUsuario daoUsu = new DaoUsuario(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        usuario_reg = (EditText)findViewById(R.id.usuario_reg);
        contraseña_reg = (EditText)findViewById(R.id.contraseña_reg);
        contraseñaRepe_reg = (EditText)findViewById(R.id.contraseñaRepe_reg);
        regis=(TextView)findViewById(R.id.btn_regis);
        regis.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String nombreUsuario = usuario_reg.getText().toString();
        String contraseña = contraseña_reg.getText().toString();
        String contraseñaRepe = contraseñaRepe_reg.getText().toString();


        if (nombreUsuario.equals("") || contraseña.equals("")) {
            Toast.makeText(this, "Los campos no pueden estar vacios", Toast.LENGTH_SHORT).show();
        } else {
            if (!contraseña.equals(contraseñaRepe)) {
                Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            } else {


                Usuario usu = new Usuario();
                usu.setNombre_usuario(nombreUsuario);
                usu.setContraseña(contraseña);



                daoUsu.InsertarUsuario(usu);


                Intent intent = new Intent(this, Home.class);

                startActivity(intent);
            }
        }
    }


}

