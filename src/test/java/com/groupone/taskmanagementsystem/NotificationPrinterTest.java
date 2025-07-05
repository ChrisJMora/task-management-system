package com.groupone.taskmanagementsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter", "PMD.TooManyMethods"})
class NotificationPrinterTest {

    private FakeConsoleOutput fakeConsole;
    private INotificationPrinter printer;

    /* default */ static class FakeConsoleOutput implements IConsoleOutput {
        /* default */ List<String> messages = new ArrayList<>();

        @Override
        public void print(final String message) {
            messages.add(message);
        }
    }

    @BeforeEach
    void setUp() {
        fakeConsole = new FakeConsoleOutput();
        printer = new NotificationPrinter(TaskItem.class, fakeConsole);
    }

    @Test
    void testPrintCreateSuccess() {
        printer.printCreateSuccess();
        assertEquals("tarea creada con éxito.", fakeConsole.messages.get(0));
    }

    @Test
    void testPrintCreateFailure() {
        printer.printCreateFailure("Error de validación");
        assertEquals("Error al crear tarea: Error de validación", fakeConsole.messages.get(0));
    }

    @Test
    void testPrintReadSuccess() {
        printer.printReadSuccess();
        assertEquals("tarea encontrada.", fakeConsole.messages.get(0));
    }

    @Test
    void testPrintReadFailure() {
        printer.printReadFailure(123);
        assertEquals("No existe tarea con ID 123.", fakeConsole.messages.get(0));
    }

    @Test
    void testPrintUpdateSuccess() {
        printer.printUpdateSuccess(123);
        assertEquals("tarea con ID 123 actualizada con éxito.", fakeConsole.messages.get(0));
    }

    @Test
    void testPrintUpdateFailure() {
        printer.printUpdateFailure(123, "Error de permisos");
        assertEquals("Error al actualizar tarea con ID 123: Error de permisos", fakeConsole.messages.get(0));
    }

    @Test
    void testPrintDeleteSuccess() {
        printer.printDeleteSuccess(123);
        assertEquals("tarea con ID 123 eliminada correctamente.", fakeConsole.messages.get(0));
    }

    @Test
    void testPrintDeleteFailure() {
        printer.printDeleteFailure(123, "Error de permisos");
        assertEquals("No se pudo eliminar tarea con ID 123: Error de permisos", fakeConsole.messages.get(0));
    }

    @Test
    void testPrintListEmpty() {
        printer.printListEmpty();
        assertEquals("No hay tareas para mostrar.", fakeConsole.messages.get(0));
    }

    @Test
    void testPrintListSuccess() {
        printer.printListSuccess(5);
        assertEquals("Se encontraron 5 tareas.", fakeConsole.messages.get(0));
    }
}
