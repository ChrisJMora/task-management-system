package com.groupone.taskmanagementsystem;

import com.groupone.taskmanagementsystem.views.TaskConsoleInterface;

/**
 * Clase principal de la aplicación de gestión de tareas.
 * <p>
 * Esta clase contiene el punto de entrada de la aplicación y es responsable de
 * inicializar e iniciar la interfaz de consola del sistema de gestión de tareas.
 * </p>
 * 
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.UseUtilityClass"})
public final class MainApp {

    /**
     * Punto de entrada principal de la aplicación.
     * <p>
     * Este método crea una instancia de la interfaz de consola de tareas
     * y la inicia para permitir la interacción del usuario con el sistema.
     * </p>
     * 
     * @param args argumentos de línea de comandos (no utilizados en esta aplicación)
     */
    public static void main(final String[] args) {
        final TaskConsoleInterface consoleInterface = new TaskConsoleInterface();
        consoleInterface.start();
    }

}