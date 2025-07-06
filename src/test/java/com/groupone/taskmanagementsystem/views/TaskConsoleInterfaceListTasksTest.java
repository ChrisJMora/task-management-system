package com.groupone.taskmanagementsystem.views;

import com.groupone.taskmanagementsystem.models.TaskItem;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import static org.mockito.Mockito.*;

/**
 * Clase de pruebas unitarias para la operación de listado de tareas en TaskConsoleInterface.
 * <p>
 * Esta clase contiene pruebas que verifican el comportamiento correcto
 * del método listTasks de TaskConsoleInterface, incluyendo casos
 * con tareas disponibles y lista vacía.
 * </p>
 *
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter"})
class TaskConsoleInterfaceListTasksTest extends TaskConsoleInterfaceTestBase {

    /**
     * Verifica que listTasks llama al servicio para obtener las tareas.
     */
    @Test
    void listTasksShouldCallServiceToGetTasks() {
        when(taskService.getTaskCollection()).thenReturn(Collections.emptyList());
        consoleInterface.listTasks();
        verify(taskService).getTaskCollection();
    }

    /**
     * Verifica que listTasks imprime la lista de tareas cuando no está vacía.
     */
    @Test
    void listTasksShouldPrintTaskListWhenNotEmpty() {
        final TaskItem task = new TaskItem("Test");
        when(taskService.getTaskCollection()).thenReturn(Collections.singletonList(task));
        consoleInterface.listTasks();
        verify(view).printTaskList(anyCollection());
    }

    /**
     * Verifica que listTasks imprime mensaje vacío cuando no hay tareas.
     */
    @Test
    void listTasksShouldPrintEmptyMessageWhenNoTasks() {
        when(taskService.getTaskCollection()).thenThrow(new IllegalStateException("No hay tareas"));
        consoleInterface.listTasks();
        verify(notification).printListEmpty();
    }
}