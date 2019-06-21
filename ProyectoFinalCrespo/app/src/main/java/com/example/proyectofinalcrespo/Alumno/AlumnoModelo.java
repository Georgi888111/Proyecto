package com.example.proyectofinalcrespo.Alumno;

import java.io.Serializable;

public class AlumnoModelo implements Serializable {
    private String nombre;
    private String apellido;
    private int dni;
    private String domicilio;
    private String telefono;

    public AlumnoModelo() {

    }

    public AlumnoModelo(String nombre, String apellido, int dni, String domicilio, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.domicilio = domicilio;
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return nombre + " DNI: " + dni;
    }
}
