package com.groupone.taskmanagementsystem;

public class DefaultTaskValidator implements TaskValidator {

    @Override
    public boolean isTitleValid(TaskItem task) {
        return task.getName() != null && !task.getName().trim().isEmpty();
    }

    @Override
    public boolean isDueDateValid(TaskItem task) {
        // No se puede validar si TaskItem no tiene fecha
        return true;
    }

    @Override
    public boolean isPriorityValid(TaskItem task) {
        // No se puede validar si TaskItem no tiene prioridad
        return true;
    }

    @Override
    public boolean isValid(TaskItem task) {
        return isTitleValid(task); // Solo valida el nombre
    }
}
