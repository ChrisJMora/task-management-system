package com.groupone.taskmanagementsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter"})
class TaskServiceUpdateTest {

    private static final String VALID_TASK_NAME = "Nuevo nombre";

    private TaskService service;
    private ITaskRepository mockRepository;
    private ITaskValidator mockValidator;

    @BeforeEach
    void setUp() {
        mockRepository = mock(ITaskRepository.class);
        mockValidator = mock(ITaskValidator.class);
        service = new TaskService(mockRepository, mockValidator);
    }

    @Test
    void updateTaskByIndexWhenInvalidThrowsIllegalArgumentException() {
        when(mockValidator.isValidForUpdate(0, VALID_TASK_NAME)).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> service.updateTaskByIndex(0, VALID_TASK_NAME),
                "Debe lanzar IllegalArgumentException cuando los datos no son válidos");
    }

    @Test
    void updateTaskByIndexWhenInvalidHasCorrectErrorMessage() {
        when(mockValidator.isValidForUpdate(0, VALID_TASK_NAME)).thenReturn(false);

        try {
            service.updateTaskByIndex(0, VALID_TASK_NAME);
            fail("Debería haber lanzado IllegalArgumentException");
        } catch (IllegalArgumentException exception) {
            assertEquals("Los datos para actualizar la tarea no son válidos.", exception.getMessage(),
                    "El mensaje debe indicar que los datos no son válidos para actualizar la tarea");
        }
    }

    @Test
    void updateTaskByIndexWhenNotFoundThrowsIllegalStateException() {
        when(mockValidator.isValidForUpdate(0, VALID_TASK_NAME)).thenReturn(true);
        when(mockRepository.updateTaskByIndex(0, VALID_TASK_NAME)).thenReturn(Optional.empty());

        assertThrows(IllegalStateException.class, () -> service.updateTaskByIndex(0, VALID_TASK_NAME),
                "Debe lanzar IllegalStateException cuando no se encuentra la tarea");
    }

    @Test
    void updateTaskByIndexWhenNotFoundHasCorrectErrorMessage() {
        when(mockValidator.isValidForUpdate(0, VALID_TASK_NAME)).thenReturn(true);
        when(mockRepository.updateTaskByIndex(0, VALID_TASK_NAME)).thenReturn(Optional.empty());

        try {
            service.updateTaskByIndex(0, VALID_TASK_NAME);
            fail("Debería haber lanzado IllegalStateException");
        } catch (IllegalStateException exception) {
            assertEquals("No se pudo actualizar la tarea con índice 0.", exception.getMessage(),
                    "El mensaje debe indicar que no se pudo actualizar la tarea con índice 0");
        }
    }

    @Test
    void updateTaskByIndexWhenValidReturnsUpdatedTask() {
        final TaskItem updatedTask = new TaskItem(0, VALID_TASK_NAME);
        when(mockValidator.isValidForUpdate(0, VALID_TASK_NAME)).thenReturn(true);
        when(mockRepository.updateTaskByIndex(0, VALID_TASK_NAME)).thenReturn(Optional.of(updatedTask));

        final TaskItem result = service.updateTaskByIndex(0, VALID_TASK_NAME);

        assertEquals(VALID_TASK_NAME, result.getTaskTitle(),
                "Debe retornar la tarea actualizada con el título correcto");
    }
}