package com.groupone.taskmanagementsystem;

import java.util.Collection;

@SuppressWarnings({"PMD.TooManyMethods", "PMD.LawOfDemeter"})
public class TaskService implements ITaskService {

    private final ITaskRepository taskRepository;
    private final ITaskValidator taskValidator;

    public TaskService() {
        this.taskRepository = new TaskRepository();
        this.taskValidator = new TaskValidator();
    }

    public TaskService(final ITaskRepository repository, final ITaskValidator validator) {
        this.taskRepository = repository;
        this.taskValidator = validator;
    }

    @Override
    public Collection<TaskItem> getTaskCollection() {
        final Collection<TaskItem> tasks = taskRepository.getAllTasks();
        if (taskValidator.isCollectionEmpty(tasks)) {
            throwCollectionEmpty();
        }
        return tasks;
    }

    @Override
    public TaskItem getTaskByIndex(final int taskIndex) {
        return taskRepository.getTaskByIndex(taskIndex)
                .orElseThrow(() -> throwNotFound(taskIndex));
    }

    @Override
    public void addTask(final TaskItem newTask) {
        if (!taskValidator.isValidForCreate(newTask)) {
            throwInvalidCreate();
        }
        taskRepository.addTask(newTask);
    }

    @Override
    public TaskItem updateTaskByIndex(final int taskIndex, final String newTaskName) {
        if (!taskValidator.isValidForUpdate(taskIndex, newTaskName)) {
            throwInvalidUpdate();
        }

        return taskRepository.updateTaskByIndex(taskIndex, newTaskName)
                .orElseThrow(() -> throwUpdateFailed(taskIndex));
    }

    @Override
    public void removeTaskByIndex(final int taskIndex) {
        if (!taskValidator.isValidForRemove(taskIndex)) {
            throwInvalidRemove();
        }

        final boolean removed = taskRepository.removeTaskByIndex(taskIndex);
        if (!removed) {
            throwDeleteFailed(taskIndex);
        }
    }

    private void throwInvalidCreate() {
        throw new IllegalArgumentException("La tarea no es válida para ser creada.");
    }

    private void throwInvalidUpdate() {
        throw new IllegalArgumentException("Los datos para actualizar la tarea no son válidos.");
    }

    private void throwInvalidRemove() {
        throw new IllegalArgumentException("El índice proporcionado no es válido para eliminar una tarea.");
    }

    private void throwCollectionEmpty() {
        throw new IllegalStateException("No hay tareas registradas.");
    }

    private IllegalStateException throwNotFound(final int index) {
        return new IllegalStateException("No se encontró ninguna tarea en el índice " + index + ".");
    }

    private IllegalStateException throwUpdateFailed(final int index) {
        return new IllegalStateException("No se pudo actualizar la tarea con índice " + index + ".");
    }

    private void throwDeleteFailed(final int index) {
        throw new IllegalStateException("No se pudo eliminar la tarea con índice " + index + ".");
    }
}
