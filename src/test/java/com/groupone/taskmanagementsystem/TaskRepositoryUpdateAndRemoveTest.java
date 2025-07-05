package com.groupone.taskmanagementsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter"})
class TaskRepositoryUpdateAndRemoveTest {

    private static final TaskItem TASK = new TaskItem("Tarea de prueba");

    private TaskRepository repository;

    @BeforeEach
    void setUp() {
        repository = new TaskRepository();
        TASK.setTitle("Tarea de prueba");
        TASK.setEntityIndex(0); // Por si se modifica en algún momento
    }

    @Test
    void testUpdateTaskByIndexReturnsPresent() {
        repository.addTask(TASK);
        final Optional<TaskItem> result = repository.updateTaskByIndex(0, "Actualizada");
        assertTrue(result.isPresent(), "La tarea debería actualizarse si el índice existe");
    }

    @Test
    void testUpdateTaskByIndexChangesName() {
        repository.addTask(TASK);
        repository.updateTaskByIndex(0, "Actualizada");
        final String updatedName = repository.getTaskByIndex(0)
                .orElseThrow()
                .getTaskTitle();
        assertEquals("Actualizada", updatedName, "El nombre de la tarea no se actualizó correctamente");
    }

    @Test
    void testUpdateTaskByIndexWhenNotExistsReturnsEmpty() {
        final Optional<TaskItem> result = repository.updateTaskByIndex(10, "Nada");
        assertTrue(result.isEmpty(), "No debería actualizarse ninguna tarea si el índice no existe");
    }

    @Test
    void testRemoveTaskByIndexReturnsTrueIfExists() {
        repository.addTask(TASK);
        final boolean result = repository.removeTaskByIndex(0);
        assertTrue(result, "La tarea debería eliminarse correctamente si existe");
    }

    @Test
    void testRemoveTaskByIndexActuallyRemoves() {
        repository.addTask(TASK);
        repository.removeTaskByIndex(0);
        final boolean isEmpty = repository.getAllTasks().isEmpty();
        assertTrue(isEmpty, "La tarea no fue eliminada de la lista");
    }

    @Test
    void testRemoveTaskByIndexReturnsFalseIfNotExists() {
        final boolean result = repository.removeTaskByIndex(100);
        assertFalse(result, "No debería eliminarse nada si el índice no existe");
    }
}
