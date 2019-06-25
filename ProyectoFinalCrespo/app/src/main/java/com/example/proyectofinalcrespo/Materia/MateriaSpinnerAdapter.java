package com.example.proyectofinalcrespo.Materia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.proyectofinalcrespo.Alumno.AlumnoModelo;
import com.example.proyectofinalcrespo.Alumno.DaoAlumno;
import com.example.proyectofinalcrespo.Profesor.DaoProfesor;
import com.example.proyectofinalcrespo.Profesor.ProfesorModelo;
import com.example.proyectofinalcrespo.R;

import java.util.ArrayList;

public class MateriaSpinnerAdapter extends ArrayAdapter {

    private Context context;
    private ArrayList<ProfesorModelo> profesores;
    private DaoProfesor daoProfesor;

    public MateriaSpinnerAdapter(Context context, ArrayList <ProfesorModelo> profesores) {
        super(context, R.layout.spinner_item, profesores);

        this.context = context;
        this.profesores = profesores;
        daoProfesor = new DaoProfesor(context);

    }



    public View getView(int position, View convertView, ViewGroup parent) {
        profesores = daoProfesor.mostrarTodos();
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.spinner_item, null);



        TextView tituloItemSpinner = (TextView) item.findViewById(R.id.tituloItemSpinner);
        tituloItemSpinner.setText(String.valueOf(profesores.get(position).getDni()));



        return item;
    }
}
