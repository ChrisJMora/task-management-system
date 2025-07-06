package com.groupone.taskmanagementsystem;

import com.groupone.taskmanagementsystem.views.TaskConsoleInterface;

@SuppressWarnings({"PMD.AtLeastOneConstructor", "PMD.UseUtilityClass"})
public final class MainApp {

    public static void main(final String[] args) {
        final TaskConsoleInterface consoleInterface = new TaskConsoleInterface();
        consoleInterface.start();
    }

}