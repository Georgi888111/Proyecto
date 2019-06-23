package com.example.proyectofinalcrespo.Alumno;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.proyectofinalcrespo.R;

import java.util.ArrayList;



    public class AlumnosAdapter extends ArrayAdapter {
        private Context context;
        private ArrayList<AlumnoModelo> alumnos;
        DaoAlumno daoAlumno;

        public AlumnosAdapter(Context context, ArrayList <AlumnoModelo> alumnos) {
            super(context, R.layout.titulo_listas, alumnos);

            this.context = context;
            this.alumnos = alumnos;
            daoAlumno = new DaoAlumno(context);

        }


        public View getView(int position, View convertView, ViewGroup parent) {
            alumnos = daoAlumno.mostrarTodos();
            LayoutInflater inflater = LayoutInflater.from(context);
            View item = inflater.inflate(R.layout.titulo_listas, null);



            TextView titulo = (TextView) item.findViewById(R.id.tituloItem);
            titulo.setText(alumnos.get(position).getNombre() + " "+ alumnos.get(position).getApellido());




            return item;
        }

    }

