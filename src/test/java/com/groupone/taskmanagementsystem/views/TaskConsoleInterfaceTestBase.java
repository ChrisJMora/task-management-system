package com.groupone.taskmanagementsystem.views;

import com.groupone.taskmanagementsystem.domain.ITaskService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Clase base para las pruebas unitarias de TaskConsoleInterface.
 * <p>
 * Esta clase proporciona la configuración común para todas las pruebas
 * de TaskConsoleInterface, incluyendo la inicialización de mocks y
 * métodos de utilidad para configurar la entrada del usuario.
 * </p>
 * 
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings({"PMD.AtLeastOneConstructor"})
public class TaskConsoleInterfaceTestBase {
    
    /**
     * Mock del servicio de tareas.
     */
    @Mock protected ITaskService taskService;
    
    /**
     * Mock de la vista de consola.
     */
    @Mock protected ITaskConsoleView view;
    
    /**
     * Mock del impresor de notificaciones.
     */
    @Mock protected INotificationPrinter notification;

    /**
     * Instancia de TaskConsoleInterface bajo prueba.
     */
    protected TaskConsoleInterface consoleInterface;
    
    /**
     * Scanner para simular entrada del usuario.
     */
    protected Scanner scanner;

    /**
     * Configuración inicial antes de cada prueba.
     * <p>
     * Se inicializan los mocks y se configura un scanner por defecto
     * que puede ser sobrescrito en tests específicos.
     * </p>
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        // Configurar un scanner por defecto que puede ser sobrescrito en tests específicos
        scanner = new Scanner(new ByteArrayInputStream("1\n".getBytes()));
        consoleInterface = new TaskConsoleInterface(scanner, taskService, view, notification);
    }

    /**
     * Configura la entrada del usuario para las pruebas.
     * <p>
     * Este método permite simular la entrada del usuario creando
     * un nuevo scanner con la entrada especificada.
     * </p>
     * 
     * @param input la entrada del usuario a simular
     */
    protected void setInput(final String input) {
        final InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        scanner = new Scanner(inputStream);
        consoleInterface = new TaskConsoleInterface(scanner, taskService, view, notification);
    }
}