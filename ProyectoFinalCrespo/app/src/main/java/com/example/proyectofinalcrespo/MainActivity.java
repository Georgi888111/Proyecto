package com.example.proyectofinalcrespo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView regis;
    TextView inicia;
    EditText usuario_log;
    EditText contraseña_log;
    TextView olvidoPassword;
    DaoUsuario daoUsu = new DaoUsuario(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        regis = (TextView) findViewById(R.id.regis);
        inicia=(TextView) findViewById(R.id.inicia);
        usuario_log = (EditText)findViewById(R.id.usuario_log);
        contraseña_log=(EditText)findViewById(R.id.contraseña_log);
        olvidoPassword=(TextView)findViewById(R.id.olvidoPassword);

        inicia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreUsuario = usuario_log.getText().toString();
                String contraseña = contraseña_log.getText().toString();

                String bdPassword = daoUsu.LoginIn(nombreUsuario);

                if (!bdPassword.equals(contraseña)) {
                    Toast.makeText(MainActivity.this, "El usuario y la contraseña no concuerdan", Toast.LENGTH_SHORT).show();

                } else {
                    Intent loginIntent = new Intent(MainActivity.this, Home.class);
                    startActivity(loginIntent);
                }

            }
        });

        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegis = new Intent(MainActivity.this,Registrar.class);
                MainActivity.this.startActivity(intentRegis);
            }
        });

    }
}