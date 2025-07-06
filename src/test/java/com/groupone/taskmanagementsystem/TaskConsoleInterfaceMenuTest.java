package com.groupone.taskmanagementsystem;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.LawOfDemeter"})
class TaskConsoleInterfaceMenuTest extends TaskConsoleInterfaceTestBase {

    @Test
    void startShouldPrintWelcomeMessageOnInit() {
        setInput("5\n"); // Simula selección de salir
        consoleInterface.start();
        verify(view).printWelcomeMessage();
    }

    @Test
    void startShouldPrintMenuAtLeastOnce() {
        setInput("5\n");
        consoleInterface.start();
        verify(view, atLeastOnce()).printMenu();
    }

    @Test
    void startShouldPrintGoodbyeWhenExiting() {
        setInput("5\n");
        consoleInterface.start();
        verify(view).printGoodbye();
    }

    @Test
    void startShouldPrintInvalidOptionForInvalidInput() {
        setInput("invalid\n5\n");
        consoleInterface.start();
        verify(view).printInvalidOption();
    }
}