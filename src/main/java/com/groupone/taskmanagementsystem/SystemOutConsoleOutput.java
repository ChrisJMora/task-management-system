package com.groupone.taskmanagementsystem;

@SuppressWarnings("PMD.AtLeastOneConstructor")
public class SystemOutConsoleOutput implements IConsoleOutput {

    @Override
    public void printMessage(final String message) {
        System.out.println(message);
    }

}