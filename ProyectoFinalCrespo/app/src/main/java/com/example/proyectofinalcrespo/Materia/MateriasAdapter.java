package com.example.proyectofinalcrespo.Materia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.proyectofinalcrespo.R;

import java.util.ArrayList;


public class MateriasAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<MateriaModelo> materias;
    DaoMateria daoMateria;

    public MateriasAdapter(Context context, ArrayList<MateriaModelo> materias) {
        super(context, R.layout.titulo_listas, materias);

        this.context = context;
        this.materias = materias;
        daoMateria = new DaoMateria(context);

    }


    public View getView(int position, View convertView, ViewGroup parent) {
        materias = daoMateria.mostrarTodos();
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.titulo_listas, null);


        TextView titulo = (TextView) item.findViewById(R.id.tituloItem);
        titulo.setText(materias.get(position).getDescripcion());


        return item;
    }

}