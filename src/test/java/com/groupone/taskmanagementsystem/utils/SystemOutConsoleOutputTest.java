package com.groupone.taskmanagementsystem.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Clase de pruebas unitarias para SystemOutConsoleOutput.
 * <p>
 * Esta clase contiene pruebas que verifican el comportamiento correcto
 * de la implementación de salida de consola SystemOutConsoleOutput.
 * Las pruebas capturan la salida estándar para verificar que los mensajes
 * se imprimen correctamente.
 * </p>
 *
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings({"PMD.AtLeastOneConstructor"})
class SystemOutConsoleOutputTest {

    /**
     * Stream para capturar la salida estándar durante las pruebas.
     */
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    /**
     * Stream original de System.out para restaurar después de las pruebas.
     */
    private final PrintStream originalOut = System.out;

    /**
     * Instancia de SystemOutConsoleOutput bajo prueba.
     */
    private SystemOutConsoleOutput consoleOutput;

    /**
     * Configuración inicial antes de cada prueba.
     * <p>
     * Se redirige System.out a un ByteArrayOutputStream para capturar
     * la salida y se crea una nueva instancia de SystemOutConsoleOutput.
     * </p>
     */
    @BeforeEach
    public void setUp() {
        // Redirigir System.out a outContent para capturar la salida
        System.setOut(new PrintStream(outContent));
        consoleOutput = new SystemOutConsoleOutput();
    }

    /**
     * Verifica que el método print imprime correctamente el mensaje.
     */
    @Test
    void testPrint() {
        final String testMessage = "Hola mundo";

        consoleOutput.print(testMessage);

        // Comprobar que la salida contiene el mensaje esperado seguido de salto de línea
        assertEquals(testMessage + System.lineSeparator(),
                outContent.toString(), "El mensaje de salida no es el esperado");

    }

    /**
     * Limpieza después de cada prueba.
     * <p>
     * Se restaura el System.out original para no afectar otras pruebas.
     * </p>
     */
    @AfterEach
    public void tearDown() {
        // Restaurar System.out original
        System.setOut(originalOut);
    }
}

