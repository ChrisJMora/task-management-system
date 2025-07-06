package com.groupone.taskmanagementsystem;

import java.util.Collection;

public interface ITaskService {

    Collection<TaskItem> getTaskCollection() throws Exception;

    TaskItem getTaskByIndex(int taskIndex) throws Exception;

    void addTask(TaskItem newTask) throws Exception;

    TaskItem updateTaskByIndex(int taskIndex, String newTaskName) throws Exception;

    void removeTaskByIndex(int taskIndex) throws Exception;

}