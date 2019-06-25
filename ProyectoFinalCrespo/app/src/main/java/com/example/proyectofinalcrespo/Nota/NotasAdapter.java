package com.example.proyectofinalcrespo.Nota;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.proyectofinalcrespo.R;
import java.util.ArrayList;

public class NotasAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList <NotaModelo> notas;


    DaoNota daoNota;



    public NotasAdapter(Context context, ArrayList <NotaModelo> notas) {
        super(context, R.layout.titulo_listas, notas);

        this.context = context;
        this.notas = notas;
        daoNota = new DaoNota(context);

    }


    public View getView(int position, View convertView, ViewGroup parent) {
        notas = daoNota.mostrarTodos();


        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.titulo_listas, null);



        TextView titulo = (TextView) item.findViewById(R.id.tituloItem);
        titulo.setText("     " + notas.get(position).getMateria()+ " Nota: "+ notas.get(position).getNota() + " Dni: " +notas.get(position).getDniAlu());
        TextView codigo = (TextView) item.findViewById(R.id.codigoItem);
        codigo.setText("Cod: " + notas.get(position).getCodigo());



        return item;
    }

}