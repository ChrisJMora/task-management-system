package com.groupone.taskmanagementsystem;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter"})
class TaskConsoleInterfaceInputHandlingTest extends TaskConsoleInterfaceTestBase {

    @Test
    void readIntInputShouldReturnParsedInteger() {
        setInput("42\n");
        final int result = consoleInterface.readIntInput();
        // Verifica que el valor ingresado "42" se haya convertido correctamente a entero
        assertEquals(42, result, "La entrada numérica válida no fue interpretada correctamente");
    }

    @Test
    void readIntInputShouldPrintErrorOnNonNumericInput() {
        setInput("not a number\n");
        consoleInterface.readIntInput();
        // Verifica que se muestre un mensaje de error cuando la entrada no es numérica
        verify(view).printInvalidInput();
    }

    @Test
    void readIntInputShouldReturnMinusOneOnInvalidInput() {
        setInput("invalid\n");
        final int result = consoleInterface.readIntInput();
        // Verifica que se retorne -1 cuando la entrada no es válida
        assertEquals(-1, result, "Se esperaba que la entrada inválida devolviera -1");
    }
}
