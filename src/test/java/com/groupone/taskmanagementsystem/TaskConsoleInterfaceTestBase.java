package com.groupone.taskmanagementsystem;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

@SuppressWarnings({"PMD.AtLeastOneConstructor"})
public class TaskConsoleInterfaceTestBase {
    @Mock protected ITaskService taskService;
    @Mock protected ITaskConsoleView view;
    @Mock protected INotificationPrinter notification;

    protected TaskConsoleInterface consoleInterface;
    protected Scanner scanner;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        // Configurar un scanner por defecto que puede ser sobrescrito en tests específicos
        scanner = new Scanner(new ByteArrayInputStream("1\n".getBytes()));
        consoleInterface = new TaskConsoleInterface(scanner, taskService, view, notification);
    }

    protected void setInput(final String input) {
        final InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        scanner = new Scanner(inputStream);
        consoleInterface = new TaskConsoleInterface(scanner, taskService, view, notification);
    }
}