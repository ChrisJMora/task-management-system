package com.groupone.taskmanagementsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter", "PMD.TooManyMethods"})
class NotificationPrinterTest {

    private FakeConsoleOutput fakeConsole;
    private INotificationPrinter printer;

    /* default */ static class FakeConsoleOutput implements IConsoleOutput {
        /* default */ List<String> messages = new ArrayList<>();

        @Override
        public void printMessage(final String message) {
            messages.add(message);
        }
    }

    /* default */ static class DummyEntity implements Identifiable {
        private final int entityId;
        private final String name;

        /* default */ DummyEntity(final int entityId, final String name) {
            this.entityId = entityId;
            this.name = name;
        }

        @Override
        public int getIndex() {
            return entityId;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    @BeforeEach
    void setUp() {
        final Identifiable entity = new DummyEntity(123, "Tarea");
        fakeConsole = new FakeConsoleOutput();
        printer = new NotificationPrinter(entity, fakeConsole);
    }

    @Test
    void testPrintCreateSuccess() {
        printer.printCreateSuccess();
        assertEquals("Tarea creada con éxito.", fakeConsole.messages.get(0),
                "El mensaje de creación exitosa no es correcto");
    }

    @Test
    void testPrintCreateFailure() {
        printer.printCreateFailure("Error de validación");
        assertEquals("Error al crear Tarea: Error de validación", fakeConsole.messages.get(0),
                "El mensaje de error en creación no es correcto");
    }

    @Test
    void testPrintReadSuccess() {
        printer.printReadSuccess();
        assertEquals("Tarea con ID 123 encontrada.", fakeConsole.messages.get(0),
                "El mensaje de lectura exitosa no es correcto");
    }

    @Test
    void testPrintReadFailure() {
        printer.printReadFailure();
        assertEquals("No existe Tarea con ID 123.", fakeConsole.messages.get(0),
                "El mensaje de lectura fallida no es correcto");
    }

    @Test
    void testPrintUpdateSuccess() {
        printer.printUpdateSuccess();
        assertEquals("Tarea con ID 123 actualizada con éxito.", fakeConsole.messages.get(0),
                "El mensaje de actualización exitosa no es correcto");
    }

    @Test
    void testPrintUpdateFailure() {
        printer.printUpdateFailure("Error de permisos");
        assertEquals("Error al actualizar Tarea con ID 123: Error de permisos", fakeConsole.messages.get(0),
                "El mensaje de error en actualización no es correcto");
    }

    @Test
    void testPrintDeleteSuccess() {
        printer.printDeleteSuccess();
        assertEquals("Tarea con ID 123 eliminada correctamente.", fakeConsole.messages.get(0),
                "El mensaje de eliminación exitosa no es correcto");
    }

    @Test
    void testPrintDeleteFailure() {
        printer.printDeleteFailure();
        assertEquals("No se pudo eliminar Tarea con ID 123. Puede que no exista.", fakeConsole.messages.get(0),
                "El mensaje de error en eliminación no es correcto");
    }

    @Test
    void testPrintListEmpty() {
        printer.printListEmpty();
        assertEquals("No hay Tareas para mostrar.", fakeConsole.messages.get(0),
                "El mensaje para lista vacía no es correcto");
    }

    @Test
    void testPrintListSuccess() {
        printer.printListSuccess(5);
        assertEquals("Se encontraron 5 Tareas.", fakeConsole.messages.get(0),
                "El mensaje para lista exitosa no es correcto");
    }
}
