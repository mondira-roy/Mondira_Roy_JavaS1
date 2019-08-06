package com.trilogyed.task.dao;

import com.trilogyed.task.model.Task;

import java.util.List;

public interface TaskDao {

    public Task createTask(Task task);

    public Task getTask(int id);

    public List<Task> getAllTasks();

    public List<Task> getTasksByCategory(String category);

    public void updateTask(Task task);

    public void deleteTask(int id);

}
