package com.groupone.taskmanagementsystem.views;

import com.groupone.taskmanagementsystem.models.TaskItem;
import com.groupone.taskmanagementsystem.utils.IConsoleOutput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de pruebas unitarias para NotificationPrinter.
 * <p>
 * Esta clase contiene pruebas que verifican el comportamiento correcto
 * de todos los métodos de NotificationPrinter, incluyendo mensajes
 * de éxito y error para todas las operaciones CRUD.
 * </p>
 * 
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter", "PMD.TooManyMethods"})
class NotificationPrinterTest {

    /**
     * Instancia fake de consola para capturar mensajes.
     */
    private FakeConsoleOutput fakeConsole;
    
    /**
     * Instancia del impresor de notificaciones bajo prueba.
     */
    private INotificationPrinter printer;

    /**
     * Implementación fake de IConsoleOutput para pruebas.
     * <p>
     * Esta clase captura todos los mensajes impresos en una lista
     * para poder verificar el contenido en las pruebas.
     * </p>
     */
    /* default */ static class FakeConsoleOutput implements IConsoleOutput {
        /**
         * Lista de mensajes capturados.
         */
        /* default */ List<String> messages = new ArrayList<>();

        /**
         * {@inheritDoc}
         */
        @Override
        public void print(final String message) {
            messages.add(message);
        }
    }

    /**
     * Configuración inicial antes de cada prueba.
     * <p>
     * Se crea una instancia fake de consola y se inicializa el impresor
     * de notificaciones con el nombre de entidad de TaskItem.
     * </p>
     */
    @BeforeEach
    void setUp() {
        fakeConsole = new FakeConsoleOutput();
        printer = new NotificationPrinter(TaskItem.ENTITY_NAME, fakeConsole);
    }

    /**
     * Verifica que el mensaje de creación exitosa es correcto.
     */
    @Test
    void testPrintCreateSuccess() {
        printer.printCreateSuccess();
        assertEquals("tarea creada con éxito.", fakeConsole.messages.get(0),
                "El mensaje de creación exitosa no es correcto");
    }

    /**
     * Verifica que el mensaje de error en creación es correcto.
     */
    @Test
    void testPrintCreateFailure() {
        printer.printCreateFailure("Error de validación");
        assertEquals("Error al crear tarea: Error de validación", fakeConsole.messages.get(0),
                "El mensaje de error en creación no es correcto");
    }

    /**
     * Verifica que el mensaje de lectura exitosa es correcto.
     */
    @Test
    void testPrintReadSuccess() {
        printer.printReadSuccess();
        assertEquals("tarea encontrada.", fakeConsole.messages.get(0),
                "El mensaje de lectura exitosa no es correcto");
    }

    /**
     * Verifica que el mensaje de error en lectura es correcto.
     */
    @Test
    void testPrintReadFailure() {
        printer.printReadFailure(123);
        assertEquals("No existe tarea con ID 123.", fakeConsole.messages.get(0),
                "El mensaje de lectura fallida no es correcto");
    }

    /**
     * Verifica que el mensaje de actualización exitosa es correcto.
     */
    @Test
    void testPrintUpdateSuccess() {
        printer.printUpdateSuccess(123);
        assertEquals("tarea con ID 123 actualizada con éxito.", fakeConsole.messages.get(0),
                "El mensaje de actualización exitosa no es correcto");
    }

    /**
     * Verifica que el mensaje de error en actualización es correcto.
     */
    @Test
    void testPrintUpdateFailure() {
        printer.printUpdateFailure(123, "Error de permisos");
        assertEquals("Error al actualizar tarea con ID 123: Error de permisos", fakeConsole.messages.get(0),
                "El mensaje de error en actualización no es correcto");
    }

    /**
     * Verifica que el mensaje de eliminación exitosa es correcto.
     */
    @Test
    void testPrintDeleteSuccess() {
        printer.printDeleteSuccess(123);
        assertEquals("tarea con ID 123 eliminada correctamente.", fakeConsole.messages.get(0),
                "El mensaje de eliminación exitosa no es correcto");
    }

    /**
     * Verifica que el mensaje de error en eliminación es correcto.
     */
    @Test
    void testPrintDeleteFailure() {
        printer.printDeleteFailure(123, "Error de permisos");
        assertEquals("No se pudo eliminar tarea con ID 123: Error de permisos", fakeConsole.messages.get(0),
                "El mensaje de error en eliminación no es correcto");
    }

    /**
     * Verifica que el mensaje para lista vacía es correcto.
     */
    @Test
    void testPrintListEmpty() {
        printer.printListEmpty();
        assertEquals("No hay tareas para mostrar.", fakeConsole.messages.get(0),
                "El mensaje para lista vacía no es correcto");
    }

    /**
     * Verifica que el mensaje para lista exitosa es correcto.
     */
    @Test
    void testPrintListSuccess() {
        printer.printListSuccess(5);
        assertEquals("Se encontraron 5 tareas.", fakeConsole.messages.get(0),
                "El mensaje para lista exitosa no es correcto");
    }
}
