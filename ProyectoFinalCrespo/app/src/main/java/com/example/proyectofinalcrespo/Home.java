package com.example.proyectofinalcrespo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Home extends AppCompatActivity {
    TextView btn_alumno,btn_profesor,btn_materia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btn_alumno=(TextView)findViewById(R.id.btn_alumno);
        btn_profesor=(TextView)findViewById(R.id.btn_profesor);
        btn_materia=(TextView)findViewById(R.id.btn_materia);

        btn_alumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAlu = new Intent(Home.this,Alumno.class);
                startActivity(intentAlu);
            }
        });

    }

}
