package com.groupone.taskmanagementsystem.domain;

import com.groupone.taskmanagementsystem.persistance.ITaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Clase de pruebas unitarias para las operaciones de eliminación de tareas en TaskService.
 * <p>
 * Esta clase contiene pruebas que verifican el comportamiento correcto
 * del método removeTaskByIndex de la clase TaskService, incluyendo casos
 * de validación y manejo de errores.
 * </p>
 *
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter"})
class TaskServiceRemoveTest {

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
     * Verifica que se lanza IllegalArgumentException cuando el índice no es válido.
     */
    @Test
    void removeTaskByIndexWhenInvalidThrowsIllegalArgumentException() {
        when(mockValidator.isValidForRemove(0)).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> service.removeTaskByIndex(0),
                "Debe lanzar IllegalArgumentException cuando el índice no es válido");
    }

    /**
     * Verifica que el mensaje de error es correcto cuando el índice no es válido.
     */
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

    /**
     * Verifica que se lanza IllegalStateException cuando no se puede eliminar la tarea.
     */
    @Test
    void removeTaskByIndexWhenNotFoundThrowsIllegalStateException() {
        when(mockValidator.isValidForRemove(0)).thenReturn(true);
        when(mockRepository.removeTaskByIndex(0)).thenReturn(false);

        assertThrows(IllegalStateException.class, () -> service.removeTaskByIndex(0),
                "Debe lanzar IllegalStateException cuando no se encuentra la tarea");
    }

    /**
     * Verifica que el mensaje de error es correcto cuando no se puede eliminar la tarea.
     */
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