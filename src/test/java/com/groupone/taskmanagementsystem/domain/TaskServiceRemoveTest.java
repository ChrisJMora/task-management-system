package com.groupone.taskmanagementsystem.domain;

import com.groupone.taskmanagementsystem.persistance.ITaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter"})
class TaskServiceRemoveTest {

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
    void removeTaskByIndexWhenInvalidThrowsIllegalArgumentException() {
        when(mockValidator.isValidForRemove(0)).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> service.removeTaskByIndex(0),
                "Debe lanzar IllegalArgumentException cuando el índice no es válido");
    }

    @Test
    void removeTaskByIndexWhenInvalidHasCorrectErrorMessage() {
        when(mockValidator.isValidForRemove(0)).thenReturn(false);

        try {
            service.removeTaskByIndex(0);
            fail("Debería haber lanzado IllegalArgumentException");
        } catch (IllegalArgumentException exception) {
            assertEquals("El índice proporcionado no es válido para eliminar una tarea.", exception.getMessage(),
                    "El mensaje debe indicar que el índice no es válido para eliminar una tarea");
        }
    }

    @Test
    void removeTaskByIndexWhenNotFoundThrowsIllegalStateException() {
        when(mockValidator.isValidForRemove(0)).thenReturn(true);
        when(mockRepository.removeTaskByIndex(0)).thenReturn(false);

        assertThrows(IllegalStateException.class, () -> service.removeTaskByIndex(0),
                "Debe lanzar IllegalStateException cuando no se encuentra la tarea");
    }

    @Test
    void removeTaskByIndexWhenNotFoundHasCorrectErrorMessage() {
        when(mockValidator.isValidForRemove(0)).thenReturn(true);
        when(mockRepository.removeTaskByIndex(0)).thenReturn(false);

        try {
            service.removeTaskByIndex(0);
            fail("Debería haber lanzado IllegalStateException");
        } catch (IllegalStateException exception) {
            assertEquals("No se pudo eliminar la tarea con índice 0.", exception.getMessage(),
                    "El mensaje debe indicar que no se pudo eliminar la tarea con índice 0");
        }
    }
}