package com.example.proyectofinalcrespo.Nota;

import android.widget.AdapterView;

import java.io.Serializable;

public class NotaModelo implements Serializable {
    private int nota;
    private int dniAlu;
    private String materia;
    private int codigo;


    public NotaModelo() {
    }

    public NotaModelo(int nota, int dniAlu, String materia, int codigo) {
        this.nota = nota;
        this.dniAlu = dniAlu;
        this.materia = materia;
        this.codigo = codigo;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getDniAlu() {
        return dniAlu;
    }

    public void setDniAlu(int dniAlu) {
        this.dniAlu = dniAlu;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Alumno: " + dniAlu + " - " + "Nota: " + nota;

    }
}
