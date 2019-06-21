package com.example.proyectofinalcrespo.Usuario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectofinalcrespo.Home;
import com.example.proyectofinalcrespo.R;

public class Registrar extends AppCompatActivity implements  View.OnClickListener {

    EditText usuario_reg;
    EditText contraseña_reg;
    EditText contraseñaRepe_reg;
    TextView regis;
    DaoUsuario daoUsu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        usuario_reg = (EditText) findViewById(R.id.usuario_reg);
        contraseña_reg = (EditText) findViewById(R.id.contraseña_reg);
        contraseñaRepe_reg = (EditText) findViewById(R.id.contraseñaRepe_reg);
        regis = (TextView) findViewById(R.id.btn_regis);
        daoUsu= new DaoUsuario(this);
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
                daoUsu.crearUsuario(nombreUsuario, contraseña);
                Intent intentRegis = new Intent(this, Home.class);
                startActivity(intentRegis);


            }
        }
    }

}