package com.groupone.taskmanagementsystem.views;

import com.groupone.taskmanagementsystem.models.TaskItem;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

/**
 * Clase de pruebas unitarias para la operación de creación de tareas en TaskConsoleInterface.
 * <p>
 * Esta clase contiene pruebas que verifican el comportamiento correcto
 * del método createTask de TaskConsoleInterface, incluyendo la interacción
 * con la vista, el servicio y las notificaciones.
 * </p>
 *
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter"})
class TaskConsoleInterfaceCreateTaskTest extends TaskConsoleInterfaceTestBase {

    /**
     * Verifica que createTask solicita el nombre de la tarea al usuario.
     */
    @Test
    void createTaskShouldPromptForTaskName() {
        setInput("Test Task\n");
        consoleInterface.createTask();
        verify(view).promptTaskName();
    }

    /**
     * Verifica que createTask llama al servicio para añadir la nueva tarea.
     */
    @Test
    void createTaskShouldCallServiceWithNewTask() {
        setInput("Test Task\n");
        consoleInterface.createTask();
        verify(taskService).addTask(any(TaskItem.class));
    }

    /**
     * Verifica que createTask imprime mensaje de éxito cuando la creación es válida.
     */
    @Test
    void createTaskShouldPrintSuccessOnValidCreation() {
        setInput("Valid Task\n");
        consoleInterface.createTask();
        verify(notification).printCreateSuccess();
    }
}