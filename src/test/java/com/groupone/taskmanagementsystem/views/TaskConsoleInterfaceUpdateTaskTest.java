package com.groupone.taskmanagementsystem.views;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter"})
class TaskConsoleInterfaceUpdateTaskTest extends TaskConsoleInterfaceTestBase {

    @Test
    void updateTaskShouldPromptForIndexAndNewName() {
        setInput("1\nNew Name\n");
        consoleInterface.updateTask();
        verify(view).promptTaskIndexToUpdate();
        verify(view).promptNewTaskName();
    }

    @Test
    void updateTaskShouldCallServiceWithCorrectParameters() {
        setInput("1\nUpdated Task\n");
        consoleInterface.updateTask();
        verify(taskService).updateTaskByIndex(eq(1), eq("Updated Task"));
    }

    @Test
    void updateTaskShouldPrintSuccessOnValidUpdate() {
        setInput("1\nValid Update\n");
        consoleInterface.updateTask();
        verify(notification).printUpdateSuccess(1);
    }

    @Test
    void updateTaskShouldPrintFailureOnInvalidIndex() {
        setInput("99\nInvalid\n");
        doThrow(new IllegalStateException("Índice inválido"))
                .when(taskService).updateTaskByIndex(anyInt(), anyString());
        consoleInterface.updateTask();
        verify(notification).printUpdateFailure(eq(99), anyString());
    }
}