package com.groupone.taskmanagementsystem.persistance;

import com.groupone.taskmanagementsystem.models.TaskItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Implementación del repositorio de tareas usando una lista en memoria.
 * <p>
 * Esta clase proporciona persistencia temporal para las tareas usando
 * una ArrayList como almacén de datos. Los datos se pierden cuando la
 * aplicación se cierra.
 * </p>
 *
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings({"PMD.LawOfDemeter"})
public class TaskRepository implements ITaskRepository {

    /**
     * Lista que almacena todas las tareas del sistema.
     */
    private final List<TaskItem> tasks;

    /**
     * Construye un nuevo repositorio de tareas.
     * <p>
     * Se inicializa con una lista vacía de tareas.
     * </p>
     */
    public TaskRepository() {
        this.tasks = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public List<TaskItem> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean addTask(final TaskItem newTask) {
        final int taskIndex = tasks.size();
        newTask.setEntityIndex(taskIndex);
        return tasks.add(newTask);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<TaskItem> updateTaskByIndex(final int index, final String updatedTitle) {
        return getTaskByIndex(index).map(task -> {
            task.setTitle(updatedTitle);
            return task;
        });
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removeTaskByIndex(final int index) {
        return getTaskByIndex(index).map(tasks::remove).orElse(false);
    }
}
