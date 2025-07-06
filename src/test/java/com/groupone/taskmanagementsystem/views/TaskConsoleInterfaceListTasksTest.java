package com.groupone.taskmanagementsystem.views;

import com.groupone.taskmanagementsystem.models.TaskItem;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import static org.mockito.Mockito.*;

@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter"})
class TaskConsoleInterfaceListTasksTest extends TaskConsoleInterfaceTestBase {

    @Test
    void listTasksShouldCallServiceToGetTasks() {
        when(taskService.getTaskCollection()).thenReturn(Collections.emptyList());
        consoleInterface.listTasks();
        verify(taskService).getTaskCollection();
    }

    @Test
    void listTasksShouldPrintTaskListWhenNotEmpty() {
        final TaskItem task = new TaskItem("Test");
        when(taskService.getTaskCollection()).thenReturn(Collections.singletonList(task));
        consoleInterface.listTasks();
        verify(view).printTaskList(anyCollection());
    }

    @Test
    void listTasksShouldPrintEmptyMessageWhenNoTasks() {
        when(taskService.getTaskCollection()).thenThrow(new IllegalStateException("No hay tareas"));
        consoleInterface.listTasks();
        verify(notification).printListEmpty();
    }
}