package com.groupone.taskmanagementsystem;

public class TaskItem {

    private int taskId;

    private String nombre;

    public TaskItem(final String nombre) {
        this.nombre = nombre;
    }

    public int getTaskId() {
        return taskId;
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
                "id='" + taskId + '\'' +
                "nombre='" + nombre + '\'' +
                '}';
    }
}