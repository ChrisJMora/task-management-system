package com.groupone.taskmanagementsystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest {

    @Test
    void testConstructorAndGetter() {
        TaskItem task = new TaskItem("Estudiar PMD");
        assertEquals("Estudiar PMD", task.getNombre());
    }

    @Test
    void testSetter() {
        TaskItem task = new TaskItem("Inicial");
        task.setNombre("Nuevo nombre");
        assertEquals("Nuevo nombre", task.getNombre());
    }

    @Test
    void testToString() {
        TaskItem task = new TaskItem("Leer documentación");
        String expected = "TaskItem{nombre='Leer documentación'}";
        assertEquals(expected, task.toString());
    }
}
