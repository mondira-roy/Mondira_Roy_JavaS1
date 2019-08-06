package com.trilogyed.taskerservice.controller;

import com.trilogyed.taskerservice.dao.TaskerDao;
import com.trilogyed.taskerservice.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
public class TaskerServiceController {
    @Autowired
    TaskerDao dao;

    public TaskerServiceController(TaskerDao dao) {
        this.dao = dao;
    }

    //    @CachePut(key = "#result.getId()")
    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task) {
        System.out.println("CREATING Task");
        return dao.createTask(task);
    }

    //    @Cacheable
    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Task getTask(@PathVariable int id) {
        System.out.println("GETTING Task ID = " + id);
        return dao.getTaskById(id);
    }


    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllTasks() {
        System.out.println("GETTING ALL TASKS");
        return dao.getAllTasks();
    }

    //    @CacheEvict(key = "#rsvp.getId()")
    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateTask(@RequestBody Task task,@PathVariable int id) {
        System.out.println("UPDATING TASK ID = " + task.getTaskId());
        dao.updateTask(task);
    }

    //    @CacheEvict
    @RequestMapping(value = "/tasks/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteTask(@PathVariable int id) {
        System.out.println("DELETING TASK ID = " + id);
        dao.deleteTask(id);
    }
}
