package com.groupone.taskmanagementsystem;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter"})
class TaskManagerTest {

    private TaskManager taskManager;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        taskManager = createTaskManager();
        System.setOut(new PrintStream(outputStream));
    }

    private static TaskManager createTaskManager() {
        return new TaskManager();
    }

    @Test
    void testAddTask() {
        // Test 1: Verificar mensaje de añadir tarea
        taskManager.AddTask("Test Task");
        final String addOutput = getOutputAndReset();
        assertTrue(addOutput.contains("Task added."), "Verificación mensaje de añadir tarea");

        // Test 2: Verificar listado de tareas
        verifyTaskListing();
    }

    private void verifyTaskListing() {
        taskManager.listTasks();
        final String listOutput = getOutputAndReset();
        assertEquals("Task 1: Test Task", listOutput, "Verificación de listado de tareas");
    }

    @Test
    void testRemoveTask() {
        // Preparación
        taskManager.AddTask("Task to Remove");
        resetOutput();

        // Ejecución y verificación
        taskManager.removeTask(1);
        final String output = getOutput();
        assertTrue(output.contains("Task removed."),
                "Verificación mensaje de eliminación de tarea");
    }

    private String getOutput() {
        return outputStream.toString().trim();
    }

    private String getOutputAndReset() {
        final String output = getOutput();
        resetOutput();
        return output;
    }

    private void resetOutput() {
        outputStream.reset();
    }

    @AfterEach
    public void tearDown() {
        System.setOut(originalOut);
    }
}