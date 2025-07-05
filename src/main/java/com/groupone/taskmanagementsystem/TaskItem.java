package com.groupone.taskmanagementsystem;

public class TaskItem {

    private int taskId;

    private String name;

    public TaskItem(final String nombre) {
        this.name = nombre;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TaskItem{" +
                "id='" + taskId + '\'' +
                "nombre='" + name + '\'' +
                '}';
    }
}