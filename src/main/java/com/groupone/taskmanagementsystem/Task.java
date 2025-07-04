package com.groupone.taskmanagementsystem;

public class Task {
    private String nombre;

    public Task(final String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Task{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
