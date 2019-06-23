package com.example.proyectofinalcrespo.Materia;


import java.io.Serializable;

public class MateriaModelo implements Serializable {

    private int codigo;
    private String descripcion;
    private int cantHoras;
    private int dniProf;


    public MateriaModelo() {
    }

    public MateriaModelo(int codigo, String descripcion, int cantHoras,int dniProf) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.cantHoras = cantHoras;
        this.dniProf = dniProf;

    }

    public MateriaModelo(String descripcion, int cantHoras,int dniProf, int codigo) {
        this.descripcion = descripcion;
        this.cantHoras = cantHoras;
        this.dniProf = dniProf;
        this.codigo = codigo;


    }

    public int getDniProf() {
        return dniProf;
    }

    public void setDniProf(int dniProf) {
        this.dniProf = dniProf;
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



    @Override
    public String toString() {
        return descripcion;
    }
}
