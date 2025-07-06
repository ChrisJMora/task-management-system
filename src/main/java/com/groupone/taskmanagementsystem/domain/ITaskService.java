package com.groupone.taskmanagementsystem.domain;

import com.groupone.taskmanagementsystem.models.TaskItem;

import java.util.Collection;

/**
 * Interfaz que define el contrato para los servicios de gestión de tareas.
 * <p>
 * Esta interfaz proporciona operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * para la gestión de tareas en el sistema. Actúa como la capa de servicio que
 * coordina las operaciones de negocio relacionadas con las tareas.
 * </p>
 *
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
public interface ITaskService {

    /**
     * Obtiene todas las tareas del sistema.
     * <p>
     * Este método retorna una colección con todas las tareas almacenadas.
     * Si no hay tareas, puede lanzar una excepción según la implementación.
     * </p>
     *
     * @return colección de todas las tareas
     * @throws IllegalStateException si no hay tareas registradas
     */
    Collection<TaskItem> getTaskCollection();

    /**
     * Obtiene una tarea específica por su índice.
     *
     * @param taskIndex el índice de la tarea a buscar
     * @return la tarea encontrada
     * @throws IllegalStateException si no se encuentra la tarea con el índice especificado
     */
    TaskItem getTaskByIndex(int taskIndex);

    /**
     * Añade una nueva tarea al sistema.
     *
     * @param newTask la nueva tarea a añadir
     * @throws IllegalArgumentException si la tarea no es válida para ser creada
     */
    void addTask(TaskItem newTask);

    /**
     * Actualiza el título de una tarea existente.
     *
     * @param taskIndex  el índice de la tarea a actualizar
     * @param newTaskName el nuevo título de la tarea
     * @return la tarea actualizada
     * @throws IllegalArgumentException si los datos para actualizar no son válidos
     * @throws IllegalStateException    si no se puede actualizar la tarea
     */
    TaskItem updateTaskByIndex(int taskIndex, String newTaskName);

    /**
     * Elimina una tarea del sistema por su índice.
     *
     * @param taskIndex el índice de la tarea a eliminar
     * @throws IllegalArgumentException si el índice no es válido
     * @throws IllegalStateException    si no se puede eliminar la tarea
     */
    void removeTaskByIndex(int taskIndex);

}