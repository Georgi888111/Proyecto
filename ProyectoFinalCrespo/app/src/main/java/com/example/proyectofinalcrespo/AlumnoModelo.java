package com.example.proyectofinalcrespo;

public class AlumnoModelo {
    private String Nombre;
    private String apellido;
    private int dni;

    public AlumnoModelo() {

    }

    public AlumnoModelo(String nombre, String apellido, int dni) {
        Nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
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
}
