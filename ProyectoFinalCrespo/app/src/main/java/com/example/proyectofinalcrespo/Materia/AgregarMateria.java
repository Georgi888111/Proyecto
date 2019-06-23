package com.example.proyectofinalcrespo.Materia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import com.example.proyectofinalcrespo.Profesor.ProfesorModelo;
import com.example.proyectofinalcrespo.R;

import java.util.ArrayList;

public class AgregarMateria extends AppCompatActivity {

    Spinner muestraDniProf;

    ArrayList<ProfesorModelo>modeProfe;
    DaoMateria daoMate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_materia);
        daoMate = new DaoMateria(this);
        muestraDniProf =(Spinner) findViewById(R.id.dniProf);
        modeProfe = daoMate.retornaArrayProfesor();




    }
}
