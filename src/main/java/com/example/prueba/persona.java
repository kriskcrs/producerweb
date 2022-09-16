package com.example.prueba;

public class persona {

    private int id;
    private String nombre;
    private int edad;
    private int cantidad;

    public persona() {
    }

    public persona(int id, String nombre, int edad, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.cantidad = cantidad;
    }

    public int getCantidad(){return cantidad;}

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
