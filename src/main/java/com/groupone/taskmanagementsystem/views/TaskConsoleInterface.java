package com.groupone.taskmanagementsystem.views;

import com.groupone.taskmanagementsystem.domain.ITaskService;
import com.groupone.taskmanagementsystem.domain.TaskService;
import com.groupone.taskmanagementsystem.models.TaskItem;

import java.util.Collection;
import java.util.Scanner;

/**
 * Controlador principal de la interfaz de consola para tareas.
 * <p>
 * Esta clase actúa como el controlador principal que coordina las interacciones
 * del usuario con el sistema de gestión de tareas. Maneja la lógica de navegación
 * del menú y coordina las operaciones entre la vista, el servicio y las notificaciones.
 * </p>
 * 
 * @author Group One
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings({"PMD.LawOfDemeter"})
public class TaskConsoleInterface {

    /**
     * Scanner para leer la entrada del usuario.
     */
    private final Scanner scanner;
    
    /**
     * Servicio de tareas para operaciones de negocio.
     */
    private final ITaskService taskService;
    
    /**
     * Vista de consola para mostrar información al usuario.
     */
    private final ITaskConsoleView view;
    
    /**
     * Impresor de notificaciones para mostrar mensajes de resultado.
     */
    private final INotificationPrinter notification;

    /**
     * Construye una nueva interfaz de consola con dependencias por defecto.
     * <p>
     * Se inicializan todas las dependencias con sus implementaciones por defecto.
     * </p>
     */
    public TaskConsoleInterface() {
        this.scanner = new Scanner(System.in);
        this.taskService = new TaskService();
        this.view = new TaskConsoleView();
        this.notification = new NotificationPrinter(TaskItem.ENTITY_NAME);
    }

    /**
     * Construye una nueva interfaz de consola con dependencias específicas.
     * <p>
     * Este constructor permite la inyección de dependencias para facilitar
     * las pruebas unitarias y proporcionar flexibilidad en la configuración.
     * </p>
     * 
     * @param scanner el scanner para leer entrada del usuario
     * @param taskService el servicio de tareas
     * @param view la vista de consola
     * @param notification el impresor de notificaciones
     */
    public TaskConsoleInterface(final Scanner scanner, final ITaskService taskService,
                                final ITaskConsoleView view, final INotificationPrinter notification) {
        this.scanner = scanner;
        this.taskService = taskService;
        this.view = view;
        this.notification = notification;
    }

    /**
     * Inicia la aplicación de consola.
     * <p>
     * Este método ejecuta el bucle principal de la aplicación, mostrando el menú
     * y procesando las opciones del usuario hasta que se selecciona la opción de salir.
     * </p>
     */
    public void start() {
        view.printWelcomeMessage();
        boolean running = true;
        while (running) {
            view.printMenu();
            final String input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    createTask();
                    break;
                case "2":
                    listTasks();
                    break;
                case "3":
                    updateTask();
                    break;
                case "4":
                    deleteTask();
                    break;
                case "5":
                    running = false;
                    break;
                default:
                    view.printInvalidOption();
                    break;
            }
        }
        view.printGoodbye();
    }

    /**
     * Maneja la creación de una nueva tarea.
     * <p>
     * Solicita al usuario el nombre de la tarea y la añade al sistema.
     * Muestra mensajes de éxito o error según el resultado.
     * </p>
     */
    /* default */ void createTask() {
        view.promptTaskName();
        final String taskTitle = scanner.nextLine().trim();

        final TaskItem newTask = new TaskItem(taskTitle);
        try {
            taskService.addTask(newTask);
            notification.printCreateSuccess();
        } catch (IllegalArgumentException ex) {
            notification.printCreateFailure(ex.getMessage());
        }
    }

    /**
     * Maneja el listado de todas las tareas.
     * <p>
     * Obtiene todas las tareas del sistema y las muestra al usuario.
     * Muestra un mensaje apropiado si no hay tareas.
     * </p>
     */
    /* default */ void listTasks() {
        try {
            final Collection<TaskItem> tasks = taskService.getTaskCollection();
            view.printTaskList(tasks);
        } catch (IllegalStateException ex) {
            notification.printListEmpty();
        }
    }

    /**
     * Maneja la actualización de una tarea existente.
     * <p>
     * Solicita al usuario el índice de la tarea a actualizar y el nuevo nombre.
     * Muestra mensajes de éxito o error según el resultado.
     * </p>
     */
    /* default */ void updateTask() {
        view.promptTaskIndexToUpdate();
        final int index = readIntInput();

        view.promptNewTaskName();
        final String newTaskName = scanner.nextLine().trim();

        try {
            taskService.updateTaskByIndex(index, newTaskName);
            notification.printUpdateSuccess(index);
        } catch (IllegalArgumentException | IllegalStateException ex) {
            notification.printUpdateFailure(index, ex.getMessage());
        }
    }

    /**
     * Maneja la eliminación de una tarea.
     * <p>
     * Solicita al usuario el índice de la tarea a eliminar.
     * Muestra mensajes de éxito o error según el resultado.
     * </p>
     */
    /* default */ void deleteTask() {
        view.promptTaskIndexToDelete();
        final int index = readIntInput();

        try {
            taskService.removeTaskByIndex(index);
            notification.printDeleteSuccess(index);
        } catch (IllegalArgumentException | IllegalStateException ex) {
            notification.printDeleteFailure(index, ex.getMessage());
        }
    }

    /**
     * Lee un número entero de la entrada del usuario.
     * <p>
     * Maneja errores de formato y muestra un mensaje de error si la entrada no es válida.
     * </p>
     * 
     * @return el número entero ingresado por el usuario, o -1 si hay un error
     */
    /* default */ int readIntInput() {
        int result = -1;
        try {
            result = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            view.printInvalidInput();
        }
        return result;
    }
}