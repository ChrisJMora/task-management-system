package com.groupone.taskmanagementsystem.views;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

/**
 * Clase de pruebas unitarias para el menú y navegación en TaskConsoleInterface.
 * <p>
 * Esta clase contiene pruebas que verifican el comportamiento correcto
 * del método start de TaskConsoleInterface, incluyendo la navegación
 * del menú y el manejo de opciones válidas e inválidas.
 * </p>
 * 
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter"})
class TaskConsoleInterfaceMenuTest extends TaskConsoleInterfaceTestBase {

    /**
     * Verifica que start imprime el mensaje de bienvenida al iniciar.
     */
    @Test
    void startShouldPrintWelcomeMessageOnInit() {
        setInput("5\n"); // Simula selección de salir
        consoleInterface.start();
        verify(view).printWelcomeMessage();
    }

    /**
     * Verifica que start imprime el menú al menos una vez.
     */
    @Test
    void startShouldPrintMenuAtLeastOnce() {
        setInput("5\n");
        consoleInterface.start();
        verify(view, atLeastOnce()).printMenu();
    }

    /**
     * Verifica que start imprime el mensaje de despedida al salir.
     */
    @Test
    void startShouldPrintGoodbyeWhenExiting() {
        setInput("5\n");
        consoleInterface.start();
        verify(view).printGoodbye();
    }

    /**
     * Verifica que start imprime mensaje de opción inválida para entrada incorrecta.
     */
    @Test
    void startShouldPrintInvalidOptionForInvalidInput() {
        setInput("invalid\n5\n");
        consoleInterface.start();
        verify(view).printInvalidOption();
    }
}