package com.groupone.taskmanagementsystem.domain;

import com.groupone.taskmanagementsystem.models.TaskItem;
import com.groupone.taskmanagementsystem.persistance.ITaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Clase de pruebas unitarias para las operaciones de adición de tareas en TaskService.
 * <p>
 * Esta clase contiene pruebas que verifican el comportamiento correcto
 * del método addTask de la clase TaskService, incluyendo casos de éxito
 * y manejo de errores.
 * </p>
 *
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter"})
class TaskServiceAddTest {

    /**
     * Instancia del servicio de tareas bajo prueba.
     */
    private TaskService service;

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
        final ITaskRepository mockRepository = mock(ITaskRepository.class);
        mockValidator = mock(ITaskValidator.class);
        service = new TaskService(mockRepository, mockValidator);
    }

    /**
     * Verifica que se lanza IllegalArgumentException cuando la tarea no es válida.
     */
    @Test
    void addTaskWhenInvalidThrowsIllegalArgumentException() {
        final TaskItem newTask = new TaskItem(0, "Invalida");
        when(mockValidator.isValidForCreate(newTask)).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> service.addTask(newTask),
                "Debe lanzar IllegalArgumentException cuando la tarea no es válida");
    }

    /**
     * Verifica que se lanza una excepción cuando la tarea no es válida.
     */
    @Test
    void addTaskWhenInvalidThrowsException() {
        final TaskItem newTask = new TaskItem(0, "Invalida");
        when(mockValidator.isValidForCreate(newTask)).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> service.addTask(newTask),
                "Debe lanzar IllegalArgumentException para tarea inválida");
    }

    /**
     * Verifica que el mensaje de excepción es correcto cuando la tarea no es válida.
     */
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