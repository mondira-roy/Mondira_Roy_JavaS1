package com.trilogyed.task.service;

import com.trilogyed.task.dao.TaskDao;
import com.trilogyed.task.model.Task;
import com.trilogyed.task.model.TaskViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskerServiceLayer {
    @Autowired
    TaskDao dao;

    public TaskViewModel fetchTask(int id) {

        Task task = dao.getTask(id);
        TaskViewModel tvm = new TaskViewModel();

        tvm.setId(task.getTaskId());
        tvm.setDescription(task.getTaskDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());
        tvm.setAdvertisement(tvm.getAdvertisement());
        // TODO - get ad from Adserver and put in tvm

        return tvm;
    }

    public List<TaskViewModel> fetchAllTasks() {
        // get all tasks

        List<TaskViewModel> tasks = new ArrayList<>();
        List<Task> taskList = dao.getAllTasks();
        taskList.stream().forEach(task -> {
            tasks.add(buildTaskViewModel(task));
        });
        return tasks;
    }


    public List<TaskViewModel> fetchTasksByCategory(String category) {
        return null;
    }

    public TaskViewModel updateNewTask(TaskViewModel taskViewModel) {

        Task task = new Task();
        task.setTaskDescription(taskViewModel.getDescription());
        task.setCreateDate(taskViewModel.getCreateDate());
        task.setDueDate(taskViewModel.getDueDate());
        task.setCategory(taskViewModel.getCategory());

        task = dao.createTask(task);
        taskViewModel.setId(task.getTaskId());

        // TODO - get ad from Adserver and put in taskViewModel
        return taskViewModel;
    }

    public void deleteTask(int id) {
        dao.deleteTask(id);

    }

    public void updateTask(TaskViewModel taskViewModel) {

    }

    // helper method for converting BookViewModel to Book
    private TaskViewModel buildTaskViewModel(Task task) {
        TaskViewModel tvm = new TaskViewModel();
        tvm.setId(task.getTaskId());
        tvm.setDescription(task.getTaskDescription());
        tvm.setCreateDate(task.getCreateDate());
        tvm.setDueDate(task.getDueDate());
        tvm.setCategory(task.getCategory());
        tvm.setAdvertisement(tvm.getAdvertisement());
        return tvm;
    }
}

