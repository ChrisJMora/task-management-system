package com.groupone.taskmanagementsystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@SuppressWarnings({"PMD.AtLeastOneConstructor"})
class SystemOutConsoleOutputTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private SystemOutConsoleOutput consoleOutput;

    @BeforeEach
    public void setUp() {
        // Redirigir System.out a outContent para capturar la salida
        System.setOut(new PrintStream(outContent));
        consoleOutput = new SystemOutConsoleOutput();
    }

    @Test
    void testPrintMessage() {
        final String testMessage = "Hola mundo";

        consoleOutput.printMessage(testMessage);

        // Comprobar que la salida contiene el mensaje esperado seguido de salto de línea
        assertEquals(testMessage + System.lineSeparator(),
                outContent.toString(),"Comprobar salida");
    }

    @AfterEach
    public void tearDown() {
        // Restaurar System.out original
        System.setOut(originalOut);
    }
}

