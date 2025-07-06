package com.groupone.taskmanagementsystem.views;

import com.groupone.taskmanagementsystem.models.TaskItem;

import java.util.Collection;

/**
 * Interfaz que define el contrato para la vista de consola de tareas.
 * <p>
 * Esta interfaz proporciona métodos para mostrar información y prompts
 * en la consola relacionados con la gestión de tareas. Define todas las
 * interacciones visuales que el usuario puede ver.
 * </p>
 *
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
public interface ITaskConsoleView {

    /**
     * Imprime el mensaje de bienvenida de la aplicación.
     */
    void printWelcomeMessage();

    /**
     * Imprime el menú principal de opciones.
     */
    void printMenu();

    /**
     * Solicita al usuario que ingrese el nombre de una nueva tarea.
     */
    void promptTaskName();

    /**
     * Solicita al usuario que ingrese el índice de la tarea a actualizar.
     */
    void promptTaskIndexToUpdate();

    /**
     * Solicita al usuario que ingrese el nuevo nombre de la tarea.
     */
    void promptNewTaskName();

    /**
     * Solicita al usuario que ingrese el índice de la tarea a eliminar.
     */
    void promptTaskIndexToDelete();

    /**
     * Imprime un mensaje de opción no válida.
     */
    void printInvalidOption();

    /**
     * Imprime un mensaje de entrada inválida.
     */
    void printInvalidInput();

    /**
     * Imprime el mensaje de despedida.
     */
    void printGoodbye();

    /**
     * Imprime la lista de tareas.
     *
     * @param tasks la colección de tareas a mostrar
     */
    void printTaskList(Collection<TaskItem> tasks);
}
