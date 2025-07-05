package com.groupone.taskmanagementsystem;

public interface TaskValidator {
    boolean isTitleValid(TaskItem task);
    boolean isDueDateValid(TaskItem task);
    boolean isPriorityValid(TaskItem task);
    boolean isValid(TaskItem task);
}