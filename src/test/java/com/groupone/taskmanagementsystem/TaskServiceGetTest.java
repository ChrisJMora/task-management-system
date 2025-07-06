package com.groupone.taskmanagementsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter"})
class TaskServiceGetTest {

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
    void taskCollectionWhenEmptyThrowsIllegalStateException() {
        final List<TaskItem> emptyList = List.of();
        when(mockRepository.getAllTasks()).thenReturn(emptyList);
        when(mockValidator.isCollectionEmpty(emptyList)).thenReturn(true);

        assertThrows(IllegalStateException.class, () -> service.getTaskCollection(),
                "Debe lanzar IllegalStateException cuando no hay tareas registradas");
    }

    @Test
    void taskCollectionWhenEmptyHasCorrectErrorMessage() {
        final List<TaskItem> emptyList = List.of();
        when(mockRepository.getAllTasks()).thenReturn(emptyList);
        when(mockValidator.isCollectionEmpty(emptyList)).thenReturn(true);

        try {
            service.getTaskCollection();
            fail("Debería haber lanzado IllegalStateException");
        } catch (IllegalStateException exception) {
            assertEquals("No hay tareas registradas.", exception.getMessage(),
                    "El mensaje debe indicar que no hay tareas registradas");
        }
    }

    @Test
    void taskCollectionWhenNotEmptyReturnsTasks() {
        final List<TaskItem> tasks = List.of(new TaskItem(0, "Tarea 1"));
        when(mockRepository.getAllTasks()).thenReturn(tasks);
        when(mockValidator.isCollectionEmpty(tasks)).thenReturn(false);

        final var result = service.getTaskCollection();

        assertEquals(1, result.size(), "Debe retornar una lista con una tarea");
    }

    @Test
    void taskByIndexWhenNotFoundThrowsIllegalStateException() {
        when(mockRepository.getTaskByIndex(42)).thenReturn(Optional.empty());

        assertThrows(IllegalStateException.class, () -> service.getTaskByIndex(42),
                "Debe lanzar IllegalStateException cuando no se encuentra la tarea");
    }

    @Test
    void taskByIndexWhenNotFoundHasCorrectErrorMessage() {
        when(mockRepository.getTaskByIndex(42)).thenReturn(Optional.empty());

        try {
            service.getTaskByIndex(42);
            fail("Debería haber lanzado IllegalStateException");
        } catch (IllegalStateException exception) {
            assertEquals("No se encontró ninguna tarea en el índice 42.", exception.getMessage(),
                    "El mensaje debe indicar que no se encontró la tarea en el índice 42");
        }
    }
}