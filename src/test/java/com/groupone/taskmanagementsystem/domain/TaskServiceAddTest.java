package com.groupone.taskmanagementsystem.domain;

import com.groupone.taskmanagementsystem.models.TaskItem;
import com.groupone.taskmanagementsystem.persistance.ITaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter"})
class TaskServiceAddTest {

    private TaskService service;
    private ITaskValidator mockValidator;

    @BeforeEach
    void setUp() {
        final ITaskRepository mockRepository = mock(ITaskRepository.class);
        mockValidator = mock(ITaskValidator.class);
        service = new TaskService(mockRepository, mockValidator);
    }

    @Test
    void addTaskWhenInvalidThrowsIllegalArgumentException() {
        final TaskItem newTask = new TaskItem(0, "Invalida");
        when(mockValidator.isValidForCreate(newTask)).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> service.addTask(newTask),
                "Debe lanzar IllegalArgumentException cuando la tarea no es válida");
    }

    @Test
    void addTaskWhenInvalidThrowsException() {
        final TaskItem newTask = new TaskItem(0, "Invalida");
        when(mockValidator.isValidForCreate(newTask)).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> service.addTask(newTask),
                "Debe lanzar IllegalArgumentException para tarea inválida");
    }

    @Test
    void addTaskWhenInvalidExceptionMessageIsCorrect() {
        final TaskItem newTask = new TaskItem(0, "Invalida");
        when(mockValidator.isValidForCreate(newTask)).thenReturn(false);

        try {
            service.addTask(newTask);
            fail("Debería haber lanzado IllegalArgumentException");
        } catch (IllegalArgumentException exception) {
            assertEquals("La tarea no es válida para ser creada.", exception.getMessage(),
                    "El mensaje debe indicar que la tarea no es válida para ser creada");
        }
    }
}