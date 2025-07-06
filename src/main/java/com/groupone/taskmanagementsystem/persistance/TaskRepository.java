package com.groupone.taskmanagementsystem.persistance;

import com.groupone.taskmanagementsystem.models.TaskItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SuppressWarnings({"PMD.LawOfDemeter"})
public class TaskRepository implements ITaskRepository {

    private final List<TaskItem> tasks;

    public TaskRepository() {
        this.tasks = new ArrayList<>();
    }

    @Override
    public Optional<TaskItem> getTaskByIndex(final int index) {
        Optional<TaskItem> existingTask;
        if (index >= 0 && index < tasks.size()) {
            existingTask = Optional.of(tasks.get(index));
        } else {
            existingTask = Optional.empty();
        }
        return existingTask;
    }

    @Override
    public List<TaskItem> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    @Override
    public boolean addTask(final TaskItem newTask) {
        final int taskIndex = tasks.size();
        newTask.setEntityIndex(taskIndex);
        return tasks.add(newTask);
    }

    @Override
    public Optional<TaskItem> updateTaskByIndex(final int index, final String updatedTitle) {
        return getTaskByIndex(index).map(task -> {
            task.setTitle(updatedTitle);
            return task;
        });
    }

    @Override
    public boolean removeTaskByIndex(final int index) {
        return getTaskByIndex(index).map(tasks::remove).orElse(false);
    }
}
