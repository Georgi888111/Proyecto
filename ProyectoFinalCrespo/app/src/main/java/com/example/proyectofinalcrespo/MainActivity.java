package com.example.proyectofinalcrespo;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectofinalcrespo.Usuario.DaoUsuario;
import com.example.proyectofinalcrespo.Usuario.Registrar;


public class MainActivity extends AppCompatActivity {
    private TextView regis;
    private TextView inicia;
    private EditText usuario_log;
    private EditText contraseña_log;
    private TextView olvidoPassword;
    private DaoUsuario daoUsu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        regis = (TextView) findViewById(R.id.regis);
        inicia = (TextView) findViewById(R.id.inicia);
        usuario_log = (EditText) findViewById(R.id.apellido_alumno);
        contraseña_log = (EditText) findViewById(R.id.contraseña_log);
        olvidoPassword = (TextView) findViewById(R.id.olvidoPassword);
        daoUsu = new DaoUsuario(this);

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegis = new Intent(MainActivity.this, Registrar.class);

                MainActivity.this.startActivity(intentRegis);
            }

        });


        inicia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreUsuario = usuario_log.getText().toString();
                String contrase = contraseña_log.getText().toString();
                String bdPassword = daoUsu.LoginIn(nombreUsuario);


                if (!bdPassword.equals(contrase)) {
                    Toast.makeText(MainActivity.this, "El usuario y la contraseña no concuerdan", Toast.LENGTH_SHORT).show();

                } else {
                    Intent loginIntent = new Intent(MainActivity.this, Home.class);
                    startActivity(loginIntent);
                }

            }
        });

    }



}