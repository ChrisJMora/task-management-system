package com.groupone.taskmanagementsystem.domain;

import com.groupone.taskmanagementsystem.models.TaskItem;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Optional;

@SuppressWarnings("PMD.AtLeastOneConstructor")
public class TaskValidator implements ITaskValidator {

    @Override
    public boolean isValidForCreate(final TaskItem newtask) {
        return isTitleValid(newtask.getTaskTitle());
    }

    @Override
    public boolean isValidForUpdate(final int taskIndex, final String newTaskName) {
        return isTitleValid(newTaskName) && isIndexValid(taskIndex);
    }

    @Override
    public boolean isValidForRemove(final int taskIndex) {
        return isIndexValid(taskIndex);
    }

    @Override
    public boolean isCollectionEmpty(final Collection<TaskItem> taskCollection) {
        return taskCollection.isEmpty();
    }

    @Override
    public boolean isOptionalEmpty(final Optional<TaskItem> optionalTaskItem) {
        return optionalTaskItem.isEmpty();
    }

    private boolean isTitleValid(final String taskTitle) {
        return taskTitle != null && !StringUtils.isBlank(taskTitle);
    }

    private boolean isIndexValid(final int taskIndex) {
        return taskIndex >= 0;
    }
}