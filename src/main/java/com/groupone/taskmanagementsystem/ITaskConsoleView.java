package com.groupone.taskmanagementsystem;

import java.util.Collection;

public interface ITaskConsoleView {

    void printWelcomeMessage();

    void printMenu();

    void promptTaskName();

    void promptTaskIndexToUpdate();

    void promptNewTaskName();

    void promptTaskIndexToDelete();

    void printInvalidOption();

    void printInvalidInput();

    void printGoodbye();

    void printTaskList(Collection<TaskItem> tasks);
}
