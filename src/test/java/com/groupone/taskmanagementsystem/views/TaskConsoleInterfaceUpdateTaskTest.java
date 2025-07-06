package com.groupone.taskmanagementsystem.views;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

/**
 * Clase de pruebas unitarias para la operación de actualización de tareas en TaskConsoleInterface.
 * <p>
 * Esta clase contiene pruebas que verifican el comportamiento correcto
 * del método updateTask de TaskConsoleInterface, incluyendo la interacción
 * con la vista, el servicio y las notificaciones para casos exitosos y de error.
 * </p>
 * 
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter"})
class TaskConsoleInterfaceUpdateTaskTest extends TaskConsoleInterfaceTestBase {

    /**
     * Verifica que updateTask solicita el índice y el nuevo nombre de la tarea.
     */
    @Test
    void updateTaskShouldPromptForIndexAndNewName() {
        setInput("1\nNew Name\n");
        consoleInterface.updateTask();
        verify(view).promptTaskIndexToUpdate();
        verify(view).promptNewTaskName();
    }

    /**
     * Verifica que updateTask llama al servicio con los parámetros correctos.
     */
    @Test
    void updateTaskShouldCallServiceWithCorrectParameters() {
        setInput("1\nUpdated Task\n");
        consoleInterface.updateTask();
        verify(taskService).updateTaskByIndex(eq(1), eq("Updated Task"));
    }

    /**
     * Verifica que updateTask imprime mensaje de éxito cuando la actualización es exitosa.
     */
    @Test
    void updateTaskShouldPrintSuccessOnValidUpdate() {
        setInput("1\nValid Update\n");
        consoleInterface.updateTask();
        verify(notification).printUpdateSuccess(1);
    }

    /**
     * Verifica que updateTask imprime mensaje de error cuando el índice es inválido.
     */
    @Test
    void updateTaskShouldPrintFailureOnInvalidIndex() {
        setInput("99\nInvalid\n");
        doThrow(new IllegalStateException("Índice inválido"))
                .when(taskService).updateTaskByIndex(anyInt(), anyString());
        consoleInterface.updateTask();
        verify(notification).printUpdateFailure(eq(99), anyString());
    }
}