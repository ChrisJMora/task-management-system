package com.groupone.taskmanagementsystem;

public class TaskItem implements Identifiable {

    private final int taskIndex;

    private String taskName;

    public TaskItem(final int taskIndex, final String taskName) {
        this.taskIndex = taskIndex;
        this.taskName = taskName;
    }

    @Override
    public int getIndex() {
        return taskIndex;
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
                "id='" + taskIndex + '\'' +
                "nombre='" + taskName + '\'' +
                '}';
    }
}