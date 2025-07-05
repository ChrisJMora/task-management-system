package com.groupone.taskmanagementsystem;

public class TaskItem implements Identifiable {

    private int taskId;

    private String taskName;

    public TaskItem(final String nombre) {
        this.taskName = nombre;
    }

    @Override
    public int getId() {
        return taskId;
    }

    @Override
    public String getName() {
        return taskName;
    }

    public void setName(final String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String toString() {
        return "TaskItem{" +
                "id='" + taskId + '\'' +
                "nombre='" + taskName + '\'' +
                '}';
    }
}