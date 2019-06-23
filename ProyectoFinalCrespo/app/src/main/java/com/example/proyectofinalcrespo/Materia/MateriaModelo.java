package com.example.proyectofinalcrespo.Materia;

import com.example.proyectofinalcrespo.Profesor.ProfesorModelo;

public class MateriaModelo {

    private int codigo;
    private String descripcion;
    private int cantHoras;
    private ProfesorModelo profeMode;


    public MateriaModelo() {
    }

    public MateriaModelo(int codigo, String descripcion, int cantHoras, ProfesorModelo profeMode) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantHoras = cantHoras;
        this.profeMode = profeMode;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantHoras() {
        return cantHoras;
    }

    public void setCantHoras(int cantHoras) {
        this.cantHoras = cantHoras;
    }

    public ProfesorModelo getProfeMode() {
        return profeMode;
    }

    public void setProfeMode(ProfesorModelo profeMode) {
        this.profeMode = profeMode;
    }
}
