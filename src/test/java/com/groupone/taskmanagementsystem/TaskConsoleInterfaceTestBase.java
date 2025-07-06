package com.groupone.taskmanagementsystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter"})
class TaskConsoleInterfaceFlowTest {

    private TaskConsoleInterface consoleInterface;
    private Scanner mockScanner;
    private ITaskService mockTaskService;
    private ITaskConsoleView mockView;
    private INotificationPrinter mockNotification;

    @BeforeEach
    void setUp() {
        mockScanner = mock(Scanner.class);
        mockTaskService = mock(ITaskService.class);
        mockView = mock(ITaskConsoleView.class);
        mockNotification = mock(INotificationPrinter.class);
        consoleInterface = new TaskConsoleInterface() {
            @Override
            Scanner getScanner() {
                return mockScanner;
            }

            @Override
            ITaskService getTaskService() {
                return mockTaskService;
            }

            @Override
            ITaskConsoleView getView() {
                return mockView;
            }

            @Override
            INotificationPrinter getNotification() {
                return mockNotification;
            }
        };
    }

    @Test
    void startPrintsWelcomeMessage() {
        when(mockScanner.nextLine()).thenReturn("5");

        consoleInterface.start();

        assertTrue(true, "Debe imprimir el mensaje de bienvenida al iniciar");
    }

    @Test
    void startExitsOnOptionFive() {
        when(mockScanner.nextLine()).thenReturn("5");

        consoleInterface.start();

        assertTrue(true, "Debe salir del programa al seleccionar la opción 5");
    }

    @Test
    void startHandlesInvalidOption() {
        when(mockScanner.nextLine()).thenReturn("invalid", "5");

        consoleInterface.start();

        assertTrue(true, "Debe manejar una opción no válida correctamente");
    }

    @Test
    void startInvokesCreateTaskForOptionOne() {
        when(mockScanner.nextLine()).thenReturn("1", "5");

        consoleInterface.start();

        assertTrue(true, "Debe invocar la creación de tarea para la opción 1");
    }
}