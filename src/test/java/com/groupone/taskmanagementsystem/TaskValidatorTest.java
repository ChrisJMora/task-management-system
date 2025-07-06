package com.groupone.taskmanagementsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.TooManyMethods"})
class TaskValidatorTest {

    private TaskValidator validator;

    @BeforeEach
    void setUp() {
        validator = new TaskValidator();
    }

    @Test
    void testIsValidForCreateWithValidTitle() {
        final TaskItem task = new TaskItem("Leer libro");
        assertTrue(validator.isValidForCreate(task), "Una tarea con título válido debería ser válida para crear.");
    }

    @Test
    void testIsValidForCreateWithBlankTitle() {
        final TaskItem task = new TaskItem("   ");
        assertFalse(validator.isValidForCreate(task), "Una tarea con título en blanco no debería ser válida para crear.");
    }

    @Test
    void testIsValidForCreateWithNullTitle() {
        final TaskItem task = new TaskItem(null);
        assertFalse(validator.isValidForCreate(task), "Una tarea con título nulo no debería ser válida para crear.");
    }

    @Test
    void testIsValidForUpdateWithValidIndexAndTitle() {
        assertTrue(validator.isValidForUpdate(1, "Actualizar tarea"),
                "Debería ser válida la actualización con índice positivo y título no vacío.");
    }

    @Test
    void testIsValidForUpdateWithNegativeIndex() {
        assertFalse(validator.isValidForUpdate(-1, "Tarea"),
                "No debería ser válida la actualización con índice negativo.");
    }

    @Test
    void testIsValidForUpdateWithBlankTitle() {
        assertFalse(validator.isValidForUpdate(0, " "),
                "No debería ser válida la actualización con título en blanco.");
    }

    @Test
    void testIsValidForRemoveWithValidIndex() {
        assertTrue(validator.isValidForRemove(0),
                "Eliminar con índice 0 debería ser válido.");
    }

    @Test
    void testIsValidForRemoveWithNegativeIndex() {
        assertFalse(validator.isValidForRemove(-5),
                "Eliminar con índice negativo no debería ser válido.");
    }

    @Test
    void testIsCollectionEmptyWhenEmpty() {
        final Collection<TaskItem> tasks = new ArrayList<>();
        assertTrue(validator.isCollectionEmpty(tasks), "Una colección vacía debería considerarse vacía.");
    }

    @Test
    void testIsCollectionEmptyWhenNotEmpty() {
        final Collection<TaskItem> tasks = List.of(new TaskItem("Tarea"));
        assertFalse(validator.isCollectionEmpty(tasks), "Una colección con tareas no debería considerarse vacía.");
    }

    @Test
    void testIsOptionalEmptyWhenEmpty() {
        final Optional<TaskItem> task = Optional.empty();
        assertTrue(validator.isOptionalEmpty(task), "Optional vacío debería considerarse vacío.");
    }

    @Test
    void testIsOptionalEmptyWhenPresent() {
        final Optional<TaskItem> task = Optional.of(new TaskItem("Presente"));
        assertFalse(validator.isOptionalEmpty(task), "Optional con tarea no debería considerarse vacío.");
    }
}
