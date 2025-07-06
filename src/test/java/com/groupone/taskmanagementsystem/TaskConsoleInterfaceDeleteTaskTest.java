package com.groupone.taskmanagementsystem;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter"})
class TaskConsoleInterfaceDeleteTaskTest extends TaskConsoleInterfaceTestBase {

    @Test
    void deleteTaskShouldPromptForIndex() {
        setInput("1\n");
        consoleInterface.deleteTask();
        verify(view).promptTaskIndexToDelete();
    }

    @Test
    void deleteTaskShouldCallServiceWithCorrectIndex() {
        setInput("2\n");
        consoleInterface.deleteTask();
        verify(taskService).removeTaskByIndex(2);
    }

    @Test
    void deleteTaskShouldPrintSuccessOnValidDeletion() {
        setInput("1\n");
        consoleInterface.deleteTask();
        verify(notification).printDeleteSuccess(1);
    }

    @Test
    void deleteTaskShouldPrintFailureOnInvalidIndex() {
        setInput("99\n");
        doThrow(new IllegalStateException("Índice inválido"))
                .when(taskService).removeTaskByIndex(anyInt());
        consoleInterface.deleteTask();
        verify(notification).printDeleteFailure(eq(99), anyString());
    }
}