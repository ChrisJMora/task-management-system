package com.groupone.taskmanagementsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

@SuppressWarnings({"PMD.AtLeastOneConstructor"})
class TaskItemTest {

    @Test
    void testConstructorSetsId() {
        final TaskItem task = new TaskItem(1, "Leer libro de calidad");
        assertEquals(1, task.getEntityIndex(), "El ID debe coincidir con el pasado al constructor");
    }

    @Test
    void testConstructorSetsName() {
        final TaskItem task = new TaskItem(1, "Leer libro de calidad");
        assertEquals("Leer libro de calidad", task.getTaskTitle(), "El nombre debe coincidir con el pasado al constructor");
    }

    @Test
    void testSetter() {
        final TaskItem task = new TaskItem(2, "Tarea inicial");
        task.setTitle("Tarea modificada");
        assertEquals("Tarea modificada", task.getTaskTitle(), "El nombre debe reflejar el valor actualizado con el setter");
    }

    @Test
    void testToString() {
        final TaskItem task = new TaskItem(3, "Escribir test");
        final String expected = "TaskItem{id='3'nombre='tarea'título='Escribir test'}";
        assertEquals(expected, task.toString(), "El método toString debe seguir el formato TaskItem{id='...'nombre='...'}");
    }
}
