package com.groupone.taskmanagementsystem.domain;

import com.groupone.taskmanagementsystem.models.TaskItem;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Optional;

/**
 * Implementación del validador de tareas.
 * <p>
 * Esta clase proporciona la lógica de validación para todas las operaciones
 * sobre tareas en el sistema. Verifica que los datos cumplan con las reglas
 * de negocio antes de permitir que las operaciones se ejecuten.
 * </p>
 * 
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings("PMD.AtLeastOneConstructor")
public class TaskValidator implements ITaskValidator {

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isValidForCreate(final TaskItem newtask) {
        return isTitleValid(newtask.getTaskTitle());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isValidForUpdate(final int taskIndex, final String newTaskName) {
        return isTitleValid(newTaskName) && isIndexValid(taskIndex);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isValidForRemove(final int taskIndex) {
        return isIndexValid(taskIndex);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isCollectionEmpty(final Collection<TaskItem> taskCollection) {
        return taskCollection.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isOptionalEmpty(final Optional<TaskItem> optionalTaskItem) {
        return optionalTaskItem.isEmpty();
    }

    /**
     * Valida si un título de tarea es válido.
     * <p>
     * Un título es válido si no es null y no está vacío o compuesto solo por espacios.
     * </p>
     * 
     * @param taskTitle el título de la tarea a validar
     * @return true si el título es válido, false en caso contrario
     */
    private boolean isTitleValid(final String taskTitle) {
        return taskTitle != null && !StringUtils.isBlank(taskTitle);
    }

    /**
     * Valida si un índice de tarea es válido.
     * <p>
     * Un índice es válido si es mayor o igual a cero.
     * </p>
     * 
     * @param taskIndex el índice de la tarea a validar
     * @return true si el índice es válido, false en caso contrario
     */
    private boolean isIndexValid(final int taskIndex) {
        return taskIndex >= 0;
    }
}