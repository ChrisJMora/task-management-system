package com.groupone.taskmanagementsystem;

public class TaskItem {
    private String nombre;

    public TaskItem(final String nombre) {
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
        return "TaskItem{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
