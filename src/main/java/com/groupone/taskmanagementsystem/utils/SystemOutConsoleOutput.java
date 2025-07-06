package com.groupone.taskmanagementsystem.utils;

@SuppressWarnings("PMD.AtLeastOneConstructor")
public class SystemOutConsoleOutput implements IConsoleOutput {

    @Override
    public void print(final String message) {
        System.out.println(message);
    }

}