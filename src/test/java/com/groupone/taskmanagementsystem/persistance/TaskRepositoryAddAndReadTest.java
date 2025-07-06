package com.groupone.taskmanagementsystem.persistance;

import com.groupone.taskmanagementsystem.models.TaskItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para las operaciones de adición y lectura en TaskRepository.
 * <p>
 * Esta clase contiene pruebas que verifican el comportamiento correcto
 * de los métodos addTask, getTaskByIndex y getAllTasks de la clase TaskRepository.
 * Se enfocan en las operaciones de agregar tareas y leer datos del repositorio.
 * </p>
 *
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter"})
class TaskRepositoryAddAndReadTest {

    /**
     * Tarea de ejemplo utilizada en las pruebas.
     */
    private static final TaskItem TASK_SAMPLE = new TaskItem("Tarea A");

    /**
     * Instancia del repositorio de tareas bajo prueba.
     */
    private TaskRepository repository;

    /**
     * Configuración inicial antes de cada prueba.
     * <p>
     * Se crea una nueva instancia del repositorio para cada prueba.
     * </p>
     */
    @BeforeEach
    void setUp() {
        repository = new TaskRepository();
    }

    /**
     * Verifica que addTask retorna true cuando se agrega una tarea correctamente.
     */
    @Test
    void testAddTaskReturnsTrue() {
        final boolean result = repository.addTask(TASK_SAMPLE);
        assertTrue(result, "La tarea debería agregarse correctamente");
    }

    /**
     * Verifica que addTask almacena correctamente el nombre de la tarea.
     */
    @Test
    void testAddTaskStoresCorrectName() {
        repository.addTask(TASK_SAMPLE);
        final String taskName = repository.getTaskByIndex(0)
                .orElseThrow()
                .getTaskTitle();
        assertEquals(TASK_SAMPLE.getTaskTitle(), taskName, "El nombre almacenado no coincide con el esperado");
    }

    /**
     * Verifica que addTask asigna correctamente el índice de la tarea.
     */
    @Test
    void testAddTaskStoresCorrectIndex() {
        repository.addTask(TASK_SAMPLE);
        final int taskIndex = repository.getTaskByIndex(0)
                .orElseThrow()
                .getEntityIndex();
        assertEquals(0, taskIndex, "El índice de la primera tarea debería ser 0");
    }

    /**
     * Verifica que getTaskByIndex retorna Optional presente cuando la tarea existe.
     */
    @Test
    void testGetTaskByIndexWhenExistsReturnsPresent() {
        repository.addTask(TASK_SAMPLE);
        final Optional<TaskItem> result = repository.getTaskByIndex(0);
        assertTrue(result.isPresent(), "La tarea debería estar presente en el índice 0");
    }

    /**
     * Verifica que getTaskByIndex retorna la tarea con el nombre correcto.
     */
    @Test
    void testGetTaskByIndexWhenExistsHasCorrectName() {
        repository.addTask(TASK_SAMPLE);
        final String taskName = repository.getTaskByIndex(0)
                .orElseThrow()
                .getTaskTitle();
        assertEquals(TASK_SAMPLE.getTaskTitle(), taskName, "El nombre de la tarea no coincide con el esperado");
    }

    /**
     * Verifica que getTaskByIndex retorna Optional vacío cuando la tarea no existe.
     */
    @Test
    void testGetTaskByIndexWhenNotExistsReturnsEmpty() {
        final Optional<TaskItem> result = repository.getTaskByIndex(99);
        assertTrue(result.isEmpty(), "No debería encontrarse una tarea en un índice inexistente");
    }

    /**
     * Verifica que getAllTasks retorna una copia que no afecta la lista original.
     */
    @Test
    void testGetAllTasksReturnsCopyDoesNotAffectOriginal() {
        repository.addTask(TASK_SAMPLE);
        final List<TaskItem> copy = repository.getAllTasks();
        copy.clear();
        final int size = repository.getAllTasks().size();
        assertEquals(1, size, "La lista original no debería verse afectada por cambios externos");
    }
}
