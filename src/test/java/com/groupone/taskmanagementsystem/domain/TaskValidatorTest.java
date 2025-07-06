package com.groupone.taskmanagementsystem.domain;

import com.groupone.taskmanagementsystem.models.TaskItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para TaskValidator.
 * <p>
 * Esta clase contiene pruebas que verifican el comportamiento correcto
 * de todos los métodos de validación de la clase TaskValidator,
 * incluyendo validaciones para crear, actualizar, eliminar tareas
 * y verificar colecciones y Optional.
 * </p>
 * 
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.TooManyMethods"})
class TaskValidatorTest {

    /**
     * Instancia del validador de tareas bajo prueba.
     */
    private TaskValidator validator;

    /**
     * Configuración inicial antes de cada prueba.
     * <p>
     * Se inicializa una nueva instancia del validador para cada prueba.
     * </p>
     */
    @BeforeEach
    void setUp() {
        validator = new TaskValidator();
    }

    /**
     * Verifica que una tarea con título válido es válida para crear.
     */
    @Test
    void testIsValidForCreateWithValidTitle() {
        final TaskItem task = new TaskItem("Leer libro");
        assertTrue(validator.isValidForCreate(task), "Una tarea con título válido debería ser válida para crear.");
    }

    /**
     * Verifica que una tarea con título en blanco no es válida para crear.
     */
    @Test
    void testIsValidForCreateWithBlankTitle() {
        final TaskItem task = new TaskItem("   ");
        assertFalse(validator.isValidForCreate(task), "Una tarea con título en blanco no debería ser válida para crear.");
    }

    /**
     * Verifica que una tarea con título nulo no es válida para crear.
     */
    @Test
    void testIsValidForCreateWithNullTitle() {
        final TaskItem task = new TaskItem(null);
        assertFalse(validator.isValidForCreate(task), "Una tarea con título nulo no debería ser válida para crear.");
    }

    /**
     * Verifica que la actualización es válida con índice positivo y título válido.
     */
    @Test
    void testIsValidForUpdateWithValidIndexAndTitle() {
        assertTrue(validator.isValidForUpdate(1, "Actualizar tarea"),
                "Debería ser válida la actualización con índice positivo y título no vacío.");
    }

    /**
     * Verifica que la actualización no es válida con índice negativo.
     */
    @Test
    void testIsValidForUpdateWithNegativeIndex() {
        assertFalse(validator.isValidForUpdate(-1, "Tarea"),
                "No debería ser válida la actualización con índice negativo.");
    }

    /**
     * Verifica que la actualización no es válida con título en blanco.
     */
    @Test
    void testIsValidForUpdateWithBlankTitle() {
        assertFalse(validator.isValidForUpdate(0, " "),
                "No debería ser válida la actualización con título en blanco.");
    }

    /**
     * Verifica que la eliminación es válida con índice cero.
     */
    @Test
    void testIsValidForRemoveWithValidIndex() {
        assertTrue(validator.isValidForRemove(0),
                "Eliminar con índice 0 debería ser válido.");
    }

    /**
     * Verifica que la eliminación no es válida con índice negativo.
     */
    @Test
    void testIsValidForRemoveWithNegativeIndex() {
        assertFalse(validator.isValidForRemove(-5),
                "Eliminar con índice negativo no debería ser válido.");
    }

    /**
     * Verifica que una colección vacía se considera vacía.
     */
    @Test
    void testIsCollectionEmptyWhenEmpty() {
        final Collection<TaskItem> tasks = new ArrayList<>();
        assertTrue(validator.isCollectionEmpty(tasks), "Una colección vacía debería considerarse vacía.");
    }

    /**
     * Verifica que una colección con elementos no se considera vacía.
     */
    @Test
    void testIsCollectionEmptyWhenNotEmpty() {
        final Collection<TaskItem> tasks = List.of(new TaskItem("Tarea"));
        assertFalse(validator.isCollectionEmpty(tasks), "Una colección con tareas no debería considerarse vacía.");
    }

    /**
     * Verifica que un Optional vacío se considera vacío.
     */
    @Test
    void testIsOptionalEmptyWhenEmpty() {
        final Optional<TaskItem> task = Optional.empty();
        assertTrue(validator.isOptionalEmpty(task), "Optional vacío debería considerarse vacío.");
    }

    /**
     * Verifica que un Optional con valor no se considera vacío.
     */
    @Test
    void testIsOptionalEmptyWhenPresent() {
        final Optional<TaskItem> task = Optional.of(new TaskItem("Presente"));
        assertFalse(validator.isOptionalEmpty(task), "Optional con tarea no debería considerarse vacío.");
    }
}
