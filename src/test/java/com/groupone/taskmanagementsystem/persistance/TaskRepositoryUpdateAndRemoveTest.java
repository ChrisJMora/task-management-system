package com.groupone.taskmanagementsystem.persistance;

import com.groupone.taskmanagementsystem.models.TaskItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para las operaciones de actualización y eliminación en TaskRepository.
 * <p>
 * Esta clase contiene pruebas que verifican el comportamiento correcto
 * de los métodos updateTaskByIndex y removeTaskByIndex de la clase TaskRepository.
 * Se enfocan en las operaciones de modificar y eliminar tareas del repositorio.
 * </p>
 *
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter"})
class TaskRepositoryUpdateAndRemoveTest {

    /**
     * Tarea de ejemplo utilizada en las pruebas.
     */
    private static final TaskItem TASK = new TaskItem("Tarea de prueba");

    /**
     * Instancia del repositorio de tareas bajo prueba.
     */
    private TaskRepository repository;

    /**
     * Configuración inicial antes de cada prueba.
     * <p>
     * Se crea una nueva instancia del repositorio y se prepara la tarea
     * de ejemplo para cada prueba.
     * </p>
     */
    @BeforeEach
    void setUp() {
        repository = new TaskRepository();
        TASK.setTitle("Tarea de prueba");
        TASK.setEntityIndex(0); // Por si se modifica en algún momento
    }

    /**
     * Verifica que updateTaskByIndex retorna Optional presente cuando la tarea existe.
     */
    @Test
    void testUpdateTaskByIndexReturnsPresent() {
        repository.addTask(TASK);
        final Optional<TaskItem> result = repository.updateTaskByIndex(0, "Actualizada");
        assertTrue(result.isPresent(), "La tarea debería actualizarse si el índice existe");
    }

    /**
     * Verifica que updateTaskByIndex cambia correctamente el nombre de la tarea.
     */
    @Test
    void testUpdateTaskByIndexChangesName() {
        repository.addTask(TASK);
        repository.updateTaskByIndex(0, "Actualizada");
        final String updatedName = repository.getTaskByIndex(0)
                .orElseThrow()
                .getTaskTitle();
        assertEquals("Actualizada", updatedName, "El nombre de la tarea no se actualizó correctamente");
    }

    /**
     * Verifica que updateTaskByIndex retorna Optional vacío cuando la tarea no existe.
     */
    @Test
    void testUpdateTaskByIndexWhenNotExistsReturnsEmpty() {
        final Optional<TaskItem> result = repository.updateTaskByIndex(10, "Nada");
        assertTrue(result.isEmpty(), "No debería actualizarse ninguna tarea si el índice no existe");
    }

    /**
     * Verifica que removeTaskByIndex retorna true cuando la tarea existe.
     */
    @Test
    void testRemoveTaskByIndexReturnsTrueIfExists() {
        repository.addTask(TASK);
        final boolean result = repository.removeTaskByIndex(0);
        assertTrue(result, "La tarea debería eliminarse correctamente si existe");
    }

    /**
     * Verifica que removeTaskByIndex realmente elimina la tarea de la lista.
     */
    @Test
    void testRemoveTaskByIndexActuallyRemoves() {
        repository.addTask(TASK);
        repository.removeTaskByIndex(0);
        final boolean isEmpty = repository.getAllTasks().isEmpty();
        assertTrue(isEmpty, "La tarea no fue eliminada de la lista");
    }

    /**
     * Verifica que removeTaskByIndex retorna false cuando la tarea no existe.
     */
    @Test
    void testRemoveTaskByIndexReturnsFalseIfNotExists() {
        final boolean result = repository.removeTaskByIndex(100);
        assertFalse(result, "No debería eliminarse nada si el índice no existe");
    }
}
