package com.groupone.taskmanagementsystem;

import java.util.List;
import java.util.Optional;

public interface ITaskRepository {

    Optional<TaskItem> getTaskByIndex(int index);

    List<TaskItem> getAllTasks();

    boolean addTask(String taskName);

    Optional<TaskItem> updateTaskByIndex(int index, String updatedName);

    boolean removeTaskByIndex(int index);

}
