package com.trilogyed.task.controller;

import com.trilogyed.task.dao.TaskDao;
import com.trilogyed.task.model.Task;

import com.trilogyed.task.model.TaskViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
public class TaskController {

    @Autowired
    TaskDao dao;

    public TaskController(TaskDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteTask(@PathVariable int id) {
        System.out.println("DELETING TASK ID = " + id   );
        dao.deleteTask(id);
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task) {
        System.out.println("CREATING TASKS");
        return dao.createTask(task);
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllTasks() {
        System.out.println("GETTING ALL TASKS");
        return dao.getAllTasks();
    }
    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Task getTask(@PathVariable int id) {
        System.out.println("GETTING Task By ID = " + id);
        return dao.getTask(id);
    }
    @RequestMapping(value = "/tasks/{category}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getTasksByCategory(@PathVariable String category) {
        System.out.println("GETTING Task By ID = " + category);
        return dao.getTasksByCategory(category);
    }
    @RequestMapping(value = "/tasks", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateTask(@RequestBody Task task) {
        System.out.println("UPDATING Tasks = " + task.getTaskId());
        dao.updateTask(task);
    }

}

