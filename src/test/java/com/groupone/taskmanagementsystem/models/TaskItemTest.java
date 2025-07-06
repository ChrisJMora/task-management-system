package com.groupone.taskmanagementsystem.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Clase de pruebas unitarias para la clase TaskItem.
 * <p>
 * Esta clase contiene pruebas que verifican el comportamiento correcto
 * de la clase TaskItem, incluyendo sus constructores, métodos getter,
 * setter y toString.
 * </p>
 * 
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings({"PMD.AtLeastOneConstructor"})
class TaskItemTest {

    /**
     * Verifica que el constructor con parámetros establece correctamente el ID.
     */
    @Test
    void testConstructorSetsId() {
        final TaskItem task = new TaskItem(1, "Leer libro de calidad");
        assertEquals(1, task.getEntityIndex(), "El ID debe coincidir con el pasado al constructor");
    }

    /**
     * Verifica que el constructor con parámetros establece correctamente el nombre.
     */
    @Test
    void testConstructorSetsName() {
        final TaskItem task = new TaskItem(1, "Leer libro de calidad");
        assertEquals("Leer libro de calidad", task.getTaskTitle(), "El nombre debe coincidir con el pasado al constructor");
    }

    /**
     * Verifica que el setter de título funciona correctamente.
     */
    @Test
    void testSetter() {
        final TaskItem task = new TaskItem(2, "Tarea inicial");
        task.setTitle("Tarea modificada");
        assertEquals("Tarea modificada", task.getTaskTitle(), "El nombre debe reflejar el valor actualizado con el setter");
    }

    /**
     * Verifica que el método toString devuelve el formato esperado.
     */
    @Test
    void testToString() {
        final TaskItem task = new TaskItem(3, "Escribir test");
        final String expected = "TaskItem{id='3'nombre='tarea'título='Escribir test'}";
        assertEquals(expected, task.toString(), "El método toString debe seguir el formato TaskItem{id='...'nombre='...'}");
    }
}
