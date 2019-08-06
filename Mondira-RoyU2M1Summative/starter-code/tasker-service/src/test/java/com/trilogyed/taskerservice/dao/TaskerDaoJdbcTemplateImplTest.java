package com.trilogyed.taskerservice.dao;

import com.trilogyed.taskerservice.model.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TaskerDaoJdbcTemplateImplTest {
    @Autowired
    TaskerDao dao;

    @Before
    public void setUp() throws Exception {
        List<Task> tasks = dao.getAllTasks();
        for (Task task : tasks) {
            dao.deleteTask(task.getTaskId());
        }
    }
   @Test
    public void createGetDeleteTask(){
            Task task = new Task();
            task.setTaskDescription("Description1");
            task.setCreateDate(LocalDate.of(2018,11,11));
            task.setDueDate(LocalDate.of(2018,12,12));
            task.setCategory("category1");

            task = dao.createTask(task);

            Task task1 = dao.getTaskById(task.getTaskId());
            assertEquals(task1, task);

            dao.deleteTask(task.getTaskId());
            task1 = dao.getTaskById(task.getTaskId());
            assertNull(task1);
        }

    @Test
    public void getTaskById() {
        Task task = new Task();
        task.setTaskDescription("Description1");
        task.setCreateDate(LocalDate.of(2018,11,11));
        task.setDueDate(LocalDate.of(2018,12,12));
        task.setCategory("category1");

        task = dao.createTask(task);

        Task task1 = dao.getTaskById(task.getTaskId());
        assertEquals(task1, task);
    }

    @Test
    public void getAllTasks() {
        Task task = new Task();
        task.setTaskDescription("Description1");
        task.setCreateDate(LocalDate.of(2018,11,15));
        task.setDueDate(LocalDate.of(2018,12,10));
        task.setCategory("category1");

        task = dao.createTask(task);

        task = new Task();
        task.setTaskDescription("Description2");
        task.setCreateDate(LocalDate.of(2015,11,15));
        task.setDueDate(LocalDate.of(2015,11,20));
        task.setCategory("category2");

        task = dao.createTask(task);

        List<Task> taskList = dao.getAllTasks();
        assertEquals(2, taskList.size());
    }

    @Test
    public void getTasksByCategory() {
        Task task = new Task();
        task.setTaskId(10);
        task.setTaskDescription("Description1");
        task.setCreateDate(LocalDate.of(2015,11,15));
        task.setDueDate(LocalDate.of(2015,10,19));
        task.setCategory("category1");

        dao.createTask(task);

       Task task1 = dao.getTaskById(task.getTaskId());
        assertEquals(task1, task);
    }

    @Test
    public void updateTask() {
        Task task = new Task();
        task.setTaskDescription("Description1");
        task.setCreateDate(LocalDate.of(2015,11,15));
        task.setDueDate(LocalDate.of(2015,10,19));
        task.setCategory("category1");

        task = dao.createTask(task);

//Note note = new Note(1,"note1");
//        note = dao.createNote(note);
//        note.setNote("It is a good book");
//        dao.updateNote(note,1);
//        Note fromDao = dao.getNote(note.getNoteId());
//        assertEquals(note, fromDao);
//    }
        task.setTaskDescription("Description2");
        task.setCreateDate(LocalDate.of(2018,11,11));
        task.setDueDate(LocalDate.of(2018,10,19));
        task.setCategory("category2");

        dao.updateTask(task);

        Task task1  = dao.createTask(task);
        assertEquals(task1,task);
    }

//    @Test
//    public void deleteTask() {
//        Task task = new Task();
//        task.setTaskDescription("Description1");
//        task.setCreateDate(LocalDate.of(2018,11,11));
//        task.setDueDate(LocalDate.of(2018,12,12));
//        task.setCategory("category1");
//
//        task = dao.createTask(task);
//
//        Task task1 = dao.getTaskById(task.getTaskId());
//        assertEquals(task1, task);
//        dao.deleteTask(task.getTaskId());
//        task1 = dao.getTaskById(task.getTaskId());
//        assertNull(task1);
//    }
}