package com.groupone.taskmanagementsystem;

import java.util.Collection;

public class TaskConsoleView implements ITaskConsoleView {

    private static final String PROMPT = "> ";

    private final IConsoleOutput console;

    public TaskConsoleView() {
        this.console = new SystemOutConsoleOutput();
    }

    @Override
    public void printWelcomeMessage() {
        console.print("=== SISTEMA DE GESTIÓN DE TAREAS ===");
    }

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

    @Override
    public void promptTaskName() {
        console.print("Ingrese el nombre de la nueva tarea: ");
    }

    @Override
    public void promptTaskIndexToUpdate() {
        console.print("Ingrese el índice de la tarea a actualizar: ");
    }

    @Override
    public void promptNewTaskName() {
        console.print("Ingrese el nuevo nombre: ");
    }

    @Override
    public void promptTaskIndexToDelete() {
        console.print("Ingrese el índice de la tarea a eliminar: ");
    }

    @Override
    public void printInvalidOption() {
        console.print("Opción no válida.");
    }

    @Override
    public void printInvalidInput() {
        console.print("Entrada inválida. Se espera un número.");
    }

    @Override
    public void printGoodbye() {
        console.print("¡Hasta pronto!");
    }

    @Override
    public void printTaskList(final Collection<TaskItem> tasks) {
        console.print("\nLista de tareas:");
        for (final var task : tasks) {
            console.print(String.format("[%d] %s%n", task.getEntityIndex(), task.getTaskTitle()));
        }
    }
}
