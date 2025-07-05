package com.groupone.taskmanagementsystem;

import java.util.List;
import java.util.Optional;

public interface ITaskRepository {

    Optional<TaskItem> getTaskByIndex(int index);

    List<TaskItem> getAllTasks();

    boolean addTask(final TaskItem newTask);

    Optional<TaskItem> updateTaskByIndex(int index, String updatedTitle);

    boolean removeTaskByIndex(int index);

}
