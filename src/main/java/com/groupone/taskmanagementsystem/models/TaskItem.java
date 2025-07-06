package com.groupone.taskmanagementsystem.models;

public class TaskItem implements Identifiable {

    public static final String ENTITY_NAME = "tarea";

    private int entityIndex;

    private String taskTitle;

    public TaskItem(final int entityIndex, final String taskTitle) {
        this.entityIndex = entityIndex;
        this.taskTitle = taskTitle;
    }

    public TaskItem(final String taskTitle) {
        this.entityIndex = 0;
        this.taskTitle = taskTitle;
    }

    @Override
    public int getEntityIndex() {
        return entityIndex;
    }

    public void setEntityIndex(final int entityIndex) {
        this.entityIndex = entityIndex;
    }

    @Override
    public String getEntityName() {
        return ENTITY_NAME;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTitle(final String taskTitle) {
        this.taskTitle = taskTitle;
    }

    @Override
    public String toString() {
        return "TaskItem{" +
                "id='" + entityIndex + '\'' +
                "nombre='" + ENTITY_NAME + '\'' +
                "título='" + taskTitle + '\'' +
                '}';
    }
}