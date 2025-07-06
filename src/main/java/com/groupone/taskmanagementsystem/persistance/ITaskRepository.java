package com.groupone.taskmanagementsystem.persistance;

import com.groupone.taskmanagementsystem.models.TaskItem;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define el contrato para el repositorio de tareas.
 * <p>
 * Esta interfaz proporciona métodos para la persistencia y recuperación
 * de tareas en el sistema. Actúa como la capa de acceso a datos para
 * las operaciones CRUD sobre tareas.
 * </p>
 * 
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
public interface ITaskRepository {

    /**
     * Obtiene una tarea por su índice.
     * 
     * @param index el índice de la tarea a buscar
     * @return un Optional que contiene la tarea si existe, vacío en caso contrario
     */
    Optional<TaskItem> getTaskByIndex(int index);

    /**
     * Obtiene todas las tareas almacenadas.
     * 
     * @return una lista con todas las tareas
     */
    List<TaskItem> getAllTasks();

    /**
     * Añade una nueva tarea al repositorio.
     * <p>
     * La tarea se añade al final de la lista y se le asigna automáticamente
     * un índice basado en su posición.
     * </p>
     * 
     * @param newTask la nueva tarea a añadir
     * @return true si la tarea se añadió correctamente, false en caso contrario
     */
    boolean addTask(TaskItem newTask);

    /**
     * Actualiza el título de una tarea existente.
     * 
     * @param index el índice de la tarea a actualizar
     * @param updatedTitle el nuevo título de la tarea
     * @return un Optional que contiene la tarea actualizada si existe, vacío en caso contrario
     */
    Optional<TaskItem> updateTaskByIndex(int index, String updatedTitle);

    /**
     * Elimina una tarea del repositorio por su índice.
     * 
     * @param index el índice de la tarea a eliminar
     * @return true si la tarea se eliminó correctamente, false en caso contrario
     */
    boolean removeTaskByIndex(int index);

}
