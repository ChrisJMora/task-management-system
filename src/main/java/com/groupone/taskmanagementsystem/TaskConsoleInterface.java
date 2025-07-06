package com.groupone.taskmanagementsystem;

import java.util.Collection;
import java.util.Scanner;

@SuppressWarnings({"PMD.LawOfDemeter"})
public class TaskConsoleInterface {

    private final Scanner scanner;
    private final ITaskService taskService;
    private final ITaskConsoleView view;
    private final INotificationPrinter notification;

    public TaskConsoleInterface() {
        this.scanner = new Scanner(System.in);
        this.taskService = new TaskService();
        this.view = new TaskConsoleView();
        this.notification = new NotificationPrinter(TaskItem.ENTITY_NAME);
    }

    public TaskConsoleInterface(final Scanner scanner, final ITaskService taskService,
                                final ITaskConsoleView view, final INotificationPrinter notification) {
        this.scanner = scanner;
        this.taskService = taskService;
        this.view = view;
        this.notification = notification;
    }

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

    /* default */ void listTasks() {
        try {
            final Collection<TaskItem> tasks = taskService.getTaskCollection();
            view.printTaskList(tasks);
        } catch (IllegalStateException ex) {
            notification.printListEmpty();
        }
    }

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