package com.groupone.taskmanagementsystem.views;

import com.groupone.taskmanagementsystem.models.TaskItem;
import com.groupone.taskmanagementsystem.utils.IConsoleOutput;
import com.groupone.taskmanagementsystem.utils.SystemOutConsoleOutput;

import java.util.Collection;

/**
 * Implementación de la vista de consola para tareas.
 * <p>
 * Esta clase proporciona la interfaz de usuario por consola para la aplicación
 * de gestión de tareas. Maneja todos los mensajes y prompts que se muestran
 * al usuario durante la interacción con el sistema.
 * </p>
 *
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
public class TaskConsoleView implements ITaskConsoleView {

    /**
     * Cadena utilizada como prompt para las entradas del usuario.
     */
    private static final String PROMPT = "> ";

    /**
     * Objeto para manejar la salida de consola.
     */
    private final IConsoleOutput console;

    /**
     * Construye una nueva vista de consola con salida por defecto.
     */
    public TaskConsoleView() {
        this.console = new SystemOutConsoleOutput();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printWelcomeMessage() {
        console.print("=== SISTEMA DE GESTIÓN DE TAREAS [CAMBIO] ===");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printMenu() {
        console.print("\nSeleccione una opción:");
        console.print("1. Crear tarea");
        console.print("2. Listar tareas");
        console.print("3. Actualizar tarea");
        console.print("4. Eliminar tarea");
        console.print("5. Salir");
        console.print(PROMPT);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void promptTaskName() {
        console.print("Ingrese el nombre de la nueva tarea: ");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void promptTaskIndexToUpdate() {
        console.print("Ingrese el índice de la tarea a actualizar: ");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void promptNewTaskName() {
        console.print("Ingrese el nuevo nombre: ");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void promptTaskIndexToDelete() {
        console.print("Ingrese el índice de la tarea a eliminar: ");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printInvalidOption() {
        console.print("Opción no válida.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printInvalidInput() {
        console.print("Entrada inválida. Se espera un número.");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printGoodbye() {
        console.print("¡Hasta pronto!");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void printTaskList(final Collection<TaskItem> tasks) {
        console.print("\nLista de tareas:");
        for (final var task : tasks) {
            console.print(String.format("[%d] %s%n", task.getEntityIndex(), task.getTaskTitle()));
        }
    }
}
