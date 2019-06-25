package com.example.proyectofinalcrespo.Nota;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.proyectofinalcrespo.Materia.DaoMateria;
import com.example.proyectofinalcrespo.Materia.MateriaModelo;
import com.example.proyectofinalcrespo.R;

import java.util.ArrayList;

public class NotasSpinnerAdapterDos extends ArrayAdapter {

    private Context context;
    private ArrayList<MateriaModelo> materias;
    private DaoMateria daoMateria;

    public NotasSpinnerAdapterDos(Context context, ArrayList <MateriaModelo> materias) {
        super(context, R.layout.spinner_item, materias);

        this.context = context;
        this.materias = materias;
        daoMateria = new DaoMateria(context);

    }



    public View getView(int position, View convertView, ViewGroup parent) {
        materias = daoMateria.mostrarTodos();
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.spinner_item, null);



        TextView titulo = (TextView) item.findViewById(R.id.tituloItemSpinner);
        titulo.setText(materias.get(position).getDescripcion());



        return item;
    }



}
