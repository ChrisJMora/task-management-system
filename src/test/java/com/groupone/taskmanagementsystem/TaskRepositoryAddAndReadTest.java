package com.groupone.taskmanagementsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter"})
class TaskRepositoryAddAndReadTest {

    private static final TaskItem TASK_SAMPLE = new TaskItem("Tarea A");

    private TaskRepository repository;

    @BeforeEach
    void setUp() {
        repository = new TaskRepository();
    }

    @Test
    void testAddTaskReturnsTrue() {
        final boolean result = repository.addTask(TASK_SAMPLE);
        assertTrue(result, "La tarea debería agregarse correctamente");
    }

    @Test
    void testAddTaskStoresCorrectName() {
        repository.addTask(TASK_SAMPLE);
        final String taskName = repository.getTaskByIndex(0)
                .orElseThrow()
                .getTaskTitle();
        assertEquals(TASK_SAMPLE.getTaskTitle(), taskName, "El nombre almacenado no coincide con el esperado");
    }

    @Test
    void testAddTaskStoresCorrectIndex() {
        repository.addTask(TASK_SAMPLE);
        final int taskIndex = repository.getTaskByIndex(0)
                .orElseThrow()
                .getEntityIndex();
        assertEquals(0, taskIndex, "El índice de la primera tarea debería ser 0");
    }

    @Test
    void testGetTaskByIndexWhenExistsReturnsPresent() {
        repository.addTask(TASK_SAMPLE);
        final Optional<TaskItem> result = repository.getTaskByIndex(0);
        assertTrue(result.isPresent(), "La tarea debería estar presente en el índice 0");
    }

    @Test
    void testGetTaskByIndexWhenExistsHasCorrectName() {
        repository.addTask(TASK_SAMPLE);
        final String taskName = repository.getTaskByIndex(0)
                .orElseThrow()
                .getTaskTitle();
        assertEquals(TASK_SAMPLE.getTaskTitle(), taskName, "El nombre de la tarea no coincide con el esperado");
    }

    @Test
    void testGetTaskByIndexWhenNotExistsReturnsEmpty() {
        final Optional<TaskItem> result = repository.getTaskByIndex(99);
        assertTrue(result.isEmpty(), "No debería encontrarse una tarea en un índice inexistente");
    }

    @Test
    void testGetAllTasksReturnsCopyDoesNotAffectOriginal() {
        repository.addTask(TASK_SAMPLE);
        final List<TaskItem> copy = repository.getAllTasks();
        copy.clear();
        final int size = repository.getAllTasks().size();
        assertEquals(1, size, "La lista original no debería verse afectada por cambios externos");
    }
}
