package com.groupone.taskmanagementsystem.views;

import com.groupone.taskmanagementsystem.models.TaskItem;
import com.groupone.taskmanagementsystem.utils.IConsoleOutput;
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
        printer = new NotificationPrinter(TaskItem.ENTITY_NAME, fakeConsole);
    }

    @Test
    void testPrintCreateSuccess() {
        printer.printCreateSuccess();
        assertEquals("tarea creada con éxito.", fakeConsole.messages.get(0),
                "El mensaje de creación exitosa no es correcto");
    }

    @Test
    void testPrintCreateFailure() {
        printer.printCreateFailure("Error de validación");
        assertEquals("Error al crear tarea: Error de validación", fakeConsole.messages.get(0),
                "El mensaje de error en creación no es correcto");
    }

    @Test
    void testPrintReadSuccess() {
        printer.printReadSuccess();
        assertEquals("tarea encontrada.", fakeConsole.messages.get(0),
                "El mensaje de lectura exitosa no es correcto");
    }

    @Test
    void testPrintReadFailure() {
        printer.printReadFailure(123);
        assertEquals("No existe tarea con ID 123.", fakeConsole.messages.get(0),
                "El mensaje de lectura fallida no es correcto");
    }

    @Test
    void testPrintUpdateSuccess() {
        printer.printUpdateSuccess(123);
        assertEquals("tarea con ID 123 actualizada con éxito.", fakeConsole.messages.get(0),
                "El mensaje de actualización exitosa no es correcto");
    }

    @Test
    void testPrintUpdateFailure() {
        printer.printUpdateFailure(123, "Error de permisos");
        assertEquals("Error al actualizar tarea con ID 123: Error de permisos", fakeConsole.messages.get(0),
                "El mensaje de error en actualización no es correcto");
    }

    @Test
    void testPrintDeleteSuccess() {
        printer.printDeleteSuccess(123);
        assertEquals("tarea con ID 123 eliminada correctamente.", fakeConsole.messages.get(0),
                "El mensaje de eliminación exitosa no es correcto");
    }

    @Test
    void testPrintDeleteFailure() {
        printer.printDeleteFailure(123, "Error de permisos");
        assertEquals("No se pudo eliminar tarea con ID 123: Error de permisos", fakeConsole.messages.get(0),
                "El mensaje de error en eliminación no es correcto");
    }

    @Test
    void testPrintListEmpty() {
        printer.printListEmpty();
        assertEquals("No hay tareas para mostrar.", fakeConsole.messages.get(0),
                "El mensaje para lista vacía no es correcto");
    }

    @Test
    void testPrintListSuccess() {
        printer.printListSuccess(5);
        assertEquals("Se encontraron 5 tareas.", fakeConsole.messages.get(0),
                "El mensaje para lista exitosa no es correcto");
    }
}
