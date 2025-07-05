package com.groupone.taskmanagementsystem;

import org.apache.commons.lang3.StringUtils;
@SuppressWarnings("PMD.AtLeastOneConstructor")
public class DefaultTaskValidator implements TaskValidator {

  

    @Override
    public boolean isTitleValid(final TaskItem task) {
        final String name = task.getName();
        return name != null && !StringUtils.isBlank(name);
    }

    @Override
    public boolean isDueDateValid(final TaskItem task) {
        return true;
    }

    @Override
    public boolean isPriorityValid(final TaskItem task) {
        return true;
    }

    @Override
    public boolean isValid(final TaskItem task) {
        return isTitleValid(task);
    }
}
