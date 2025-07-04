package com.groupone.taskmanagementsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Pruebas para la clase TaskItem.
 */
@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.JUnitAssertionsShouldIncludeMessage", "PMD.LocalVariableCouldBeFinal"})
class TaskItemTest {

    /**
     * Constructor explícito requerido por PMD.
     */
    public TaskItemTest() {
        // Constructor vacío necesario para la regla PMD.AtLeastOneConstructor
    }

    @Test
    void testConstructorAndGetter() {
        final TaskItem task = new TaskItem("Leer libro de calidad");
        assertEquals("Leer libro de calidad", task.getNombre(), "El nombre debe coincidir con el pasado al constructor");
    }

    @Test
    void testSetter() {
        final TaskItem task = new TaskItem("Tarea inicial");
        task.setNombre("Tarea modificada");
        assertEquals("Tarea modificada", task.getNombre(), "El nombre debe reflejar el valor actualizado con el setter");
    }

    @Test
    void testToString() {
        final TaskItem task = new TaskItem("Escribir test");
        final String expected = "TaskItem{nombre='Escribir test'}";
        assertEquals(expected, task.toString(), "El método toString debe seguir el formato TaskItem{nombre='...'}");
    }
}
