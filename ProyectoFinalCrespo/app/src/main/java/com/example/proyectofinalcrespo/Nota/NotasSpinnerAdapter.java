package com.example.proyectofinalcrespo.Nota;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.proyectofinalcrespo.Alumno.AlumnoModelo;
import com.example.proyectofinalcrespo.Alumno.DaoAlumno;
import com.example.proyectofinalcrespo.R;
import java.util.ArrayList;


public class NotasSpinnerAdapter extends ArrayAdapter {




        private Context context;
        private ArrayList<AlumnoModelo> alumnos;
        private DaoAlumno daoAlumno;

        public NotasSpinnerAdapter(Context context, ArrayList <AlumnoModelo> alumnos) {
            super(context, R.layout.spinner_item, alumnos);

            this.context = context;
            this.alumnos = alumnos;
            daoAlumno = new DaoAlumno(context);

        }



        public View getView(int position, View convertView, ViewGroup parent) {
            alumnos = daoAlumno.mostrarTodos();
            LayoutInflater inflater = LayoutInflater.from(context);
            View item = inflater.inflate(R.layout.spinner_item, null);



            TextView titulo = (TextView) item.findViewById(R.id.tituloItemSpinner);
            titulo.setText(String.valueOf(alumnos.get(position).getDni()));



            return item;
        }



    }


