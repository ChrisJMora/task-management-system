package com.groupone.taskmanagementsystem.views;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

/**
 * Clase de pruebas unitarias para la operación de eliminación de tareas en TaskConsoleInterface.
 * <p>
 * Esta clase contiene pruebas que verifican el comportamiento correcto
 * del método deleteTask de TaskConsoleInterface, incluyendo la interacción
 * con la vista, el servicio y las notificaciones para casos exitosos y de error.
 * </p>
 * 
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter"})
class TaskConsoleInterfaceDeleteTaskTest extends TaskConsoleInterfaceTestBase {

    /**
     * Verifica que deleteTask solicita el índice de la tarea a eliminar.
     */
    @Test
    void deleteTaskShouldPromptForIndex() {
        setInput("1\n");
        consoleInterface.deleteTask();
        verify(view).promptTaskIndexToDelete();
    }

    /**
     * Verifica que deleteTask llama al servicio con el índice correcto.
     */
    @Test
    void deleteTaskShouldCallServiceWithCorrectIndex() {
        setInput("2\n");
        consoleInterface.deleteTask();
        verify(taskService).removeTaskByIndex(2);
    }

    /**
     * Verifica que deleteTask imprime mensaje de éxito cuando la eliminación es exitosa.
     */
    @Test
    void deleteTaskShouldPrintSuccessOnValidDeletion() {
        setInput("1\n");
        consoleInterface.deleteTask();
        verify(notification).printDeleteSuccess(1);
    }

    /**
     * Verifica que deleteTask imprime mensaje de error cuando el índice es inválido.
     */
    @Test
    void deleteTaskShouldPrintFailureOnInvalidIndex() {
        setInput("99\n");
        doThrow(new IllegalStateException("Índice inválido"))
                .when(taskService).removeTaskByIndex(anyInt());
        consoleInterface.deleteTask();
        verify(notification).printDeleteFailure(eq(99), anyString());
    }
}