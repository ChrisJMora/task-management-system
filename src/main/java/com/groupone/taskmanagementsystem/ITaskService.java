package com.groupone.taskmanagementsystem;

import java.util.Collection;

public interface ITaskService {

    Collection<TaskItem> getTaskCollection();

    TaskItem getTaskByIndex(int taskIndex);

    boolean addTask(TaskItem newTask);

    TaskItem updateTaskByIndex(int taskIndex, String newTaskName);

    TaskItem removeTaskByIndex(int taskIndex);

}