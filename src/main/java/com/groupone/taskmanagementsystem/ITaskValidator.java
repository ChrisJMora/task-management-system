package com.groupone.taskmanagementsystem;

import java.util.Collection;
import java.util.Optional;

public interface ITaskValidator {

    boolean isValidForCreate(TaskItem newtask);

    boolean isValidForUpdate(int taskIndex, String newTaskName);

    boolean isValidForRemove(int taskIndex);

    boolean isCollectionEmpty(Collection<TaskItem> taskCollection);

    boolean isOptionalEmpty(Optional<TaskItem> optionalTaskItem);
}