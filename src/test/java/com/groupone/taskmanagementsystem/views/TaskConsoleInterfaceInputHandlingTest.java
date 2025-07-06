package com.groupone.taskmanagementsystem.views;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Clase de pruebas unitarias para el manejo de entrada en TaskConsoleInterface.
 * <p>
 * Esta clase contiene pruebas que verifican el comportamiento correcto
 * del método readIntInput de TaskConsoleInterface, incluyendo casos
 * de entrada válida e inválida.
 * </p>
 * 
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter"})
class TaskConsoleInterfaceInputHandlingTest extends TaskConsoleInterfaceTestBase {

    /**
     * Verifica que readIntInput devuelve el entero parseado correctamente.
     */
    @Test
    void readIntInputShouldReturnParsedInteger() {
        setInput("42\n");
        final int result = consoleInterface.readIntInput();
        // Verifica que el valor ingresado "42" se haya convertido correctamente a entero
        assertEquals(42, result, "La entrada numérica válida no fue interpretada correctamente");
    }

    /**
     * Verifica que readIntInput muestra un mensaje de error para entrada no numérica.
     */
    @Test
    void readIntInputShouldPrintErrorOnNonNumericInput() {
        setInput("not a number\n");
        consoleInterface.readIntInput();
        // Verifica que se muestre un mensaje de error cuando la entrada no es numérica
        verify(view).printInvalidInput();
    }

    /**
     * Verifica que readIntInput devuelve -1 para entrada inválida.
     */
    @Test
    void readIntInputShouldReturnMinusOneOnInvalidInput() {
        setInput("invalid\n");
        final int result = consoleInterface.readIntInput();
        // Verifica que se retorne -1 cuando la entrada no es válida
        assertEquals(-1, result, "Se esperaba que la entrada inválida devolviera -1");
    }
}
