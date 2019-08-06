package com.trilogyed.task.dao;

import com.trilogyed.task.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskDaoJdbcTemplateImplTest {

    @Autowired
    TaskDao taskDao;

    @Before
    public void setUp() throws Exception {

        List<Task> tasks = taskDao.getAllTasks();

        tasks.stream()
                .forEach(task -> taskDao.deleteTask(task.getTaskId()));
    }

    @Test
    public void addGetDeleteTask() {
        Task task = new Task();
        task.setTaskDescription("Description1");
        task.setCreateDate(LocalDate.of(2018, 10, 10));
        task.setDueDate(LocalDate.of(2018,11,10));
        task.setCategory("category1");
        task = taskDao.createTask(task);

        Task fromDao = taskDao.getTask(task.getTaskId());
        assertEquals(fromDao, task);

        taskDao.deleteTask(task.getTaskId());
        fromDao = taskDao.getTask(task.getTaskId());
        assertNull(fromDao);
    }

    @Test
    public void getAllTasks() {
        Task task = new Task();
        task.setTaskDescription("Description1");
        task.setCreateDate(LocalDate.of(2018, 10, 10));
        task.setDueDate(LocalDate.of(2018,11,10));
        task.setCategory("category1");
        task = taskDao.createTask(task);

        task = new Task();
        task.setTaskDescription("Description2");
        task.setCreateDate(LocalDate.of(2015, 05, 01));
        task.setDueDate(LocalDate.of(2015,10,01));
        task.setCategory("category2");
        task = taskDao.createTask(task);


        List<Task> tasks = taskDao.getAllTasks();

        assertEquals(2, tasks.size());
    }

    @Test
    public void updateTask() {
        Task task = new Task();
        task.setTaskDescription("Description1");
        task.setCreateDate(LocalDate.of(2015, 05, 01));
        task.setDueDate(LocalDate.of(2015,10,01));
        task.setCategory("category1");
        task = taskDao.createTask(task);
        task = taskDao.createTask(task);

        task.setTaskDescription("Homeward bound");
        taskDao.updateTask(task);
        Task fromDao = taskDao.getTask(task.getTaskId());
        assertEquals(task, fromDao);
    }

}

//    @Test
//    public void createTask() {
//    }
//
//    @Test
//    public void getTask() {
//    }
//
//    @Test
//    public void getAllTasks() {
//    }
//
//    @Test
//    public void getTasksByCategory() {
//    }
//
//    @Test
//    public void updateTask() {
//    }
//
