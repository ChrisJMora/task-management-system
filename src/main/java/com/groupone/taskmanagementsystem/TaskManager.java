package com.groupone.taskmanagementsystem;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("PMD.AtLeastOneConstructor")
public class TaskManager {
    private final List tasks = new ArrayList<>();

    public void addTask(final String task) {
        tasks.add(task);
        System.out.println("Task added.");
    }

    public void listTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("Task " + (i + 1) + ": " + tasks.get(i));
        }
    }

    public void removeTask(final int taskId) {
        tasks.remove(taskId - 1);
        System.out.println("Task removed.");
    }

    public static void main(final String[] args) {
        final TaskManager taskManager = new TaskManager();
        taskManager.addTask("Complete project");
        taskManager.listTasks();
        taskManager.removeTask(1);
    }
}

