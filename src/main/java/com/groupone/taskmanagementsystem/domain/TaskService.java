package com.groupone.taskmanagementsystem.domain;

import com.groupone.taskmanagementsystem.models.TaskItem;
import com.groupone.taskmanagementsystem.persistance.ITaskRepository;
import com.groupone.taskmanagementsystem.persistance.TaskRepository;

import java.util.Collection;

/**
 * Implementación del servicio de gestión de tareas.
 * <p>
 * Esta clase proporciona la lógica de negocio para las operaciones CRUD
 * sobre tareas. Coordina las operaciones entre el repositorio de datos
 * y el validador de tareas para asegurar la integridad de los datos.
 * </p>
 * 
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings({"PMD.TooManyMethods", "PMD.LawOfDemeter"})
public class TaskService implements ITaskService {

    /**
     * Repositorio para la persistencia de tareas.
     */
    private final ITaskRepository taskRepository;
    
    /**
     * Validador para verificar la integridad de las operaciones sobre tareas.
     */
    private final ITaskValidator taskValidator;

    /**
     * Construye un nuevo servicio de tareas con dependencias por defecto.
     * <p>
     * Se inicializan el repositorio y validador con sus implementaciones por defecto.
     * </p>
     */
    public TaskService() {
        this.taskRepository = new TaskRepository();
        this.taskValidator = new TaskValidator();
    }

    /**
     * Construye un nuevo servicio de tareas con dependencias específicas.
     * <p>
     * Este constructor permite la inyección de dependencias para facilitar
     * las pruebas unitarias y proporcionar flexibilidad en la configuración.
     * </p>
     * 
     * @param repository el repositorio de tareas a utilizar
     * @param validator el validador de tareas a utilizar
     */
    public TaskService(final ITaskRepository repository, final ITaskValidator validator) {
        this.taskRepository = repository;
        this.taskValidator = validator;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<TaskItem> getTaskCollection() {
        final Collection<TaskItem> tasks = taskRepository.getAllTasks();
        if (taskValidator.isCollectionEmpty(tasks)) {
            throwCollectionEmpty();
        }
        return tasks;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskItem getTaskByIndex(final int taskIndex) {
        return taskRepository.getTaskByIndex(taskIndex)
                .orElseThrow(() -> throwNotFound(taskIndex));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addTask(final TaskItem newTask) {
        if (!taskValidator.isValidForCreate(newTask)) {
            throwInvalidCreate();
        }
        taskRepository.addTask(newTask);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TaskItem updateTaskByIndex(final int taskIndex, final String newTaskName) {
        if (!taskValidator.isValidForUpdate(taskIndex, newTaskName)) {
            throwInvalidUpdate();
        }

        return taskRepository.updateTaskByIndex(taskIndex, newTaskName)
                .orElseThrow(() -> throwUpdateFailed(taskIndex));
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * Lanza una excepción cuando una tarea no es válida para ser creada.
     * 
     * @throws IllegalArgumentException siempre se lanza esta excepción
     */
    private void throwInvalidCreate() {
        throw new IllegalArgumentException("La tarea no es válida para ser creada.");
    }

    /**
     * Lanza una excepción cuando los datos para actualizar una tarea no son válidos.
     * 
     * @throws IllegalArgumentException siempre se lanza esta excepción
     */
    private void throwInvalidUpdate() {
        throw new IllegalArgumentException("Los datos para actualizar la tarea no son válidos.");
    }

    /**
     * Lanza una excepción cuando el índice para eliminar una tarea no es válido.
     * 
     * @throws IllegalArgumentException siempre se lanza esta excepción
     */
    private void throwInvalidRemove() {
        throw new IllegalArgumentException("El índice proporcionado no es válido para eliminar una tarea.");
    }

    /**
     * Lanza una excepción cuando no hay tareas en el sistema.
     * 
     * @throws IllegalStateException siempre se lanza esta excepción
     */
    private void throwCollectionEmpty() {
        throw new IllegalStateException("No hay tareas registradas.");
    }

    /**
     * Crea una excepción cuando no se encuentra una tarea con el índice especificado.
     * 
     * @param index el índice de la tarea no encontrada
     * @return la excepción a lanzar
     */
    private IllegalStateException throwNotFound(final int index) {
        return new IllegalStateException("No se encontró ninguna tarea en el índice " + index + ".");
    }

    /**
     * Crea una excepción cuando falla la actualización de una tarea.
     * 
     * @param index el índice de la tarea que no se pudo actualizar
     * @return la excepción a lanzar
     */
    private IllegalStateException throwUpdateFailed(final int index) {
        return new IllegalStateException("No se pudo actualizar la tarea con índice " + index + ".");
    }

    /**
     * Lanza una excepción cuando falla la eliminación de una tarea.
     * 
     * @param index el índice de la tarea que no se pudo eliminar
     * @throws IllegalStateException siempre se lanza esta excepción
     */
    private void throwDeleteFailed(final int index) {
        throw new IllegalStateException("No se pudo eliminar la tarea con índice " + index + ".");
    }
}
