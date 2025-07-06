package com.groupone.taskmanagementsystem;

import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Optional;

@SuppressWarnings("PMD.AtLeastOneConstructor")
public class TaskValidator implements ITaskValidator {

    @Override
    public boolean isValidForCreate(TaskItem newtask) {
        return isTitleValid(newtask.getTaskTitle());
    }

    @Override
    public boolean isValidForUpdate(int taskIndex, String newTaskName) {
        return isTitleValid(newTaskName) && isIndexValid(taskIndex);
    }

    @Override
    public boolean isValidForRemove(int taskIndex) {
        return isIndexValid(taskIndex);
    }

    @Override
    public boolean isCollectionEmpty(Collection<TaskItem> taskItemCollection) {
        return taskItemCollection.isEmpty();
    }

    @Override
    public boolean isOptionalEmpty(Optional<TaskItem> optionalTaskItem) {
        return optionalTaskItem.isEmpty();
    }

    private boolean isTitleValid(String taskTitle) {
        return taskTitle != null && !StringUtils.isBlank(taskTitle);
    }

    private boolean isIndexValid(int taskIndex) {
        return taskIndex >= 0;
    }
}