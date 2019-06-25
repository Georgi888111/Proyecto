package com.example.proyectofinalcrespo.Profesor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.proyectofinalcrespo.R;

import java.util.ArrayList;

public class ProfesoresAdapter extends ArrayAdapter {

    private Context context;
    private ArrayList <ProfesorModelo> profesores;
    private DaoProfesor daoProfe;

    public ProfesoresAdapter(Context context, ArrayList <ProfesorModelo> profesores) {
        super(context, R.layout.titulo_listas, profesores);

        this.context = context;
        this.profesores = profesores;
        daoProfe = new DaoProfesor(context);

    }


    public View getView(int position, View convertView, ViewGroup parent) {

        profesores = daoProfe.mostrarTodos();
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.titulo_listas, null);



        TextView titulo = (TextView) item.findViewById(R.id.tituloItem);
        titulo.setText("     " + profesores.get(position).getNombre() + " "+ profesores.get(position).getApellido());
        TextView codigo = (TextView)item.findViewById(R.id.codigoItem);
        codigo.setText("" + profesores.get(position).getDni());




        return item;
    }

}