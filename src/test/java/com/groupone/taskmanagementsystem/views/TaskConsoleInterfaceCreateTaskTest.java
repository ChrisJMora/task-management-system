package com.groupone.taskmanagementsystem.views;

import com.groupone.taskmanagementsystem.models.TaskItem;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter"})
class TaskConsoleInterfaceCreateTaskTest extends TaskConsoleInterfaceTestBase {

    @Test
    void createTaskShouldPromptForTaskName() {
        setInput("Test Task\n");
        consoleInterface.createTask();
        verify(view).promptTaskName();
    }

    @Test
    void createTaskShouldCallServiceWithNewTask() {
        setInput("Test Task\n");
        consoleInterface.createTask();
        verify(taskService).addTask(any(TaskItem.class));
    }

    @Test
    void createTaskShouldPrintSuccessOnValidCreation() {
        setInput("Valid Task\n");
        consoleInterface.createTask();
        verify(notification).printCreateSuccess();
    }
}