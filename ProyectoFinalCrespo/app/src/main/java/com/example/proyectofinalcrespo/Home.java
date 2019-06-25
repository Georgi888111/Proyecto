package com.example.proyectofinalcrespo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.proyectofinalcrespo.Alumno.Alumno;
import com.example.proyectofinalcrespo.Materia.Materia;
import com.example.proyectofinalcrespo.Nota.Nota;
import com.example.proyectofinalcrespo.Profesor.Profesor;

public class Home extends AppCompatActivity {

    private TextView btn_alumno,btn_profesor,btn_materia,btn_nota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_alumno=(TextView)findViewById(R.id.btn_alumno);
        btn_profesor=(TextView)findViewById(R.id.btn_profesor);
        btn_materia=(TextView)findViewById(R.id.btn_materia);
        btn_nota = (TextView)findViewById(R.id.btn_nota);


        btn_alumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAlu = new Intent(Home.this, Alumno.class);
                startActivity(intentAlu);
            }
        });

        btn_profesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentProf = new Intent(Home.this, Profesor.class);
                startActivity(intentProf);
            }
        });

        btn_materia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMate = new Intent(Home.this, Materia.class);
                startActivity(intentMate);
            }
        });

        btn_nota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNota = new Intent(Home.this, Nota.class);
                startActivity(intentNota);
            }
        });
    }

}
