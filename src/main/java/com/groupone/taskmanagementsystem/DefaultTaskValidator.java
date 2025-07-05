package com.groupone.taskmanagementsystem;

import java.time.LocalDate;

public class DefaultTaskValidator implements TaskValidator {

    @Override
    public boolean isTitleValid(TaskItem task) {
        return task.getTitle() != null && !task.getTitle().trim().isEmpty();
    }

    @Override
    public boolean isDueDateValid(TaskItem task) {
        return task.getDueDate() != null && !task.getDueDate().isBefore(LocalDate.now());
    }

    @Override
    public boolean isPriorityValid(TaskItem task) {
        String priority = task.getPriority();
        return priority != null && (priority.equalsIgnoreCase("low") ||
                                    priority.equalsIgnoreCase("medium") ||
                                    priority.equalsIgnoreCase("high"));
    }

    @Override
    public boolean isValid(TaskItem task) {
        return isTitleValid(task) && isDueDateValid(task) && isPriorityValid(task);
    }
}
