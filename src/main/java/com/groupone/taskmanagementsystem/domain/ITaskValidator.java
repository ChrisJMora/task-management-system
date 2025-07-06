package com.groupone.taskmanagementsystem.domain;

import com.groupone.taskmanagementsystem.models.TaskItem;

import java.util.Collection;
import java.util.Optional;

/**
 * Interfaz que define el contrato para la validación de operaciones sobre tareas.
 * <p>
 * Esta interfaz proporciona métodos para validar que las operaciones CRUD
 * sobre tareas puedan realizarse de manera segura y cumplan con las reglas
 * de negocio del sistema.
 * </p>
 * 
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
public interface ITaskValidator {

    /**
     * Valida si una tarea es válida para ser creada.
     * <p>
     * Verifica que la tarea tenga todos los datos necesarios y cumple
     * con las reglas de negocio para la creación.
     * </p>
     * 
     * @param newtask la tarea a validar para creación
     * @return true si la tarea es válida para crear, false en caso contrario
     */
    boolean isValidForCreate(TaskItem newtask);

    /**
     * Valida si los datos son válidos para actualizar una tarea.
     * <p>
     * Verifica que el índice de la tarea y el nuevo nombre sean válidos
     * según las reglas de negocio.
     * </p>
     * 
     * @param taskIndex el índice de la tarea a actualizar
     * @param newTaskName el nuevo nombre de la tarea
     * @return true si los datos son válidos para actualizar, false en caso contrario
     */
    boolean isValidForUpdate(int taskIndex, String newTaskName);

    /**
     * Valida si un índice es válido para eliminar una tarea.
     * 
     * @param taskIndex el índice de la tarea a eliminar
     * @return true si el índice es válido para eliminar, false en caso contrario
     */
    boolean isValidForRemove(int taskIndex);

    /**
     * Verifica si una colección de tareas está vacía.
     * 
     * @param taskCollection la colección de tareas a verificar
     * @return true si la colección está vacía, false en caso contrario
     */
    boolean isCollectionEmpty(Collection<TaskItem> taskCollection);

    /**
     * Verifica si un Optional de TaskItem está vacío.
     * 
     * @param optionalTaskItem el Optional a verificar
     * @return true si el Optional está vacío, false en caso contrario
     */
    boolean isOptionalEmpty(Optional<TaskItem> optionalTaskItem);
}