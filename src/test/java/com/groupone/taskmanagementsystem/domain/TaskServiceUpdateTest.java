package com.groupone.taskmanagementsystem.domain;

import com.groupone.taskmanagementsystem.models.TaskItem;
import com.groupone.taskmanagementsystem.persistance.ITaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Clase de pruebas unitarias para las operaciones de actualización de tareas en TaskService.
 * <p>
 * Esta clase contiene pruebas que verifican el comportamiento correcto
 * del método updateTaskByIndex de la clase TaskService, incluyendo casos
 * de validación, manejo de errores y operaciones exitosas.
 * </p>
 *
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter"})
class TaskServiceUpdateTest {

    /**
     * Constante que representa un nombre de tarea válido para las pruebas.
     */
    private static final String VALID_TASK_NAME = "Nuevo nombre";

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
     * Verifica que se lanza IllegalArgumentException cuando los datos no son válidos.
     */
    @Test
    void updateTaskByIndexWhenInvalidThrowsIllegalArgumentException() {
        when(mockValidator.isValidForUpdate(0, VALID_TASK_NAME)).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> service.updateTaskByIndex(0, VALID_TASK_NAME),
                "Debe lanzar IllegalArgumentException cuando los datos no son válidos");
    }

    /**
     * Verifica que el mensaje de error es correcto cuando los datos no son válidos.
     */
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

    /**
     * Verifica que se lanza IllegalStateException cuando no se encuentra la tarea.
     */
    @Test
    void updateTaskByIndexWhenNotFoundThrowsIllegalStateException() {
        when(mockValidator.isValidForUpdate(0, VALID_TASK_NAME)).thenReturn(true);
        when(mockRepository.updateTaskByIndex(0, VALID_TASK_NAME)).thenReturn(Optional.empty());

        assertThrows(IllegalStateException.class, () -> service.updateTaskByIndex(0, VALID_TASK_NAME),
                "Debe lanzar IllegalStateException cuando no se encuentra la tarea");
    }

    /**
     * Verifica que el mensaje de error es correcto cuando no se encuentra la tarea.
     */
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

    /**
     * Verifica que se devuelve la tarea actualizada cuando la operación es exitosa.
     */
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