package com.groupone.taskmanagementsystem.domain;

import com.groupone.taskmanagementsystem.models.TaskItem;
import com.groupone.taskmanagementsystem.persistance.ITaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Clase de pruebas unitarias para las operaciones de obtención de tareas en TaskService.
 * <p>
 * Esta clase contiene pruebas que verifican el comportamiento correcto
 * de los métodos getTaskCollection y getTaskByIndex de la clase TaskService,
 * incluyendo casos de éxito y manejo de errores.
 * </p>
 *
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter"})
class TaskServiceGetTest {

    /**
     * Instancia del servicio de tareas bajo prueba.
     */
    private TaskService service;

    /**
     * Mock del repositorio de tareas.
     */
    private ITaskRepository mockRepository;

    /**
     * Mock del validador de tareas.
     */
    private ITaskValidator mockValidator;

    /**
     * Configuración inicial antes de cada prueba.
     * <p>
     * Se crean los mocks necesarios y se inicializa el servicio de tareas
     * con las dependencias mockeadas.
     * </p>
     */
    @BeforeEach
    void setUp() {
        mockRepository = mock(ITaskRepository.class);
        mockValidator = mock(ITaskValidator.class);
        service = new TaskService(mockRepository, mockValidator);
    }

    /**
     * Verifica que se lanza IllegalStateException cuando la colección está vacía.
     */
    @Test
    void taskCollectionWhenEmptyThrowsIllegalStateException() {
        final List<TaskItem> emptyList = List.of();
        when(mockRepository.getAllTasks()).thenReturn(emptyList);
        when(mockValidator.isCollectionEmpty(emptyList)).thenReturn(true);

        assertThrows(IllegalStateException.class, () -> service.getTaskCollection(),
                "Debe lanzar IllegalStateException cuando no hay tareas registradas");
    }

    /**
     * Verifica que el mensaje de error es correcto cuando la colección está vacía.
     */
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

    /**
     * Verifica que se devuelven las tareas cuando la colección no está vacía.
     */
    @Test
    void taskCollectionWhenNotEmptyReturnsTasks() {
        final List<TaskItem> tasks = List.of(new TaskItem(0, "Tarea 1"));
        when(mockRepository.getAllTasks()).thenReturn(tasks);
        when(mockValidator.isCollectionEmpty(tasks)).thenReturn(false);

        final var result = service.getTaskCollection();

        assertEquals(1, result.size(), "Debe retornar una lista con una tarea");
    }

    /**
     * Verifica que se lanza IllegalStateException cuando no se encuentra la tarea por índice.
     */
    @Test
    void taskByIndexWhenNotFoundThrowsIllegalStateException() {
        when(mockRepository.getTaskByIndex(42)).thenReturn(Optional.empty());

        assertThrows(IllegalStateException.class, () -> service.getTaskByIndex(42),
                "Debe lanzar IllegalStateException cuando no se encuentra la tarea");
    }

    /**
     * Verifica que el mensaje de error es correcto cuando no se encuentra la tarea por índice.
     */
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