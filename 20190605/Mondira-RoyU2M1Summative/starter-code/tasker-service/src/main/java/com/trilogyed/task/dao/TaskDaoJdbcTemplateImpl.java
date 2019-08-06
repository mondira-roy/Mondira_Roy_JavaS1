package com.trilogyed.task.dao;

import com.trilogyed.task.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TaskDaoJdbcTemplateImpl implements TaskDao {

    public static final String INSERT_TASK_SQL =
            "insert into task (task_description, create_date, due_date, category) values (?, ?, ?, ?)";
    public static final String SELECT_TASK_BY_ID_SQL =
            "select * from task where task_id = ?";
    public static final String SELECT_ALL_TASKS_SQL =
            "select * from task";
    public static final String SELECT_TASKS_BY_CATEGORY_SQL =
            "select * from task where category = ?";
    public static final String UPDATE_TASK_SQL =
            "update task set task_description = ?, create_date = ?, due_date = ?, category = ? where task_id = ?";
    public static final String DELETE_TASK_SQL =
            "delete from task where task_id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public TaskDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional
    public Task createTask(Task task) {
        jdbcTemplate.update(INSERT_TASK_SQL,
                task.getTaskDescription(),
                task.getCreateDate(),
                task.getDueDate(),
                task.getCategory());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        task.setTaskId(id);
        return task;
    }


    @Override
    public Task getTask(int id) {
        try {
            return jdbcTemplate.queryForObject(SELECT_TASK_BY_ID_SQL,
                    this::mapRowToTask, id);

        } catch (EmptyResultDataAccessException e) {
            // if nothing is returned just catch the exception and return null
            return null;
        }
    }

    @Override
    public List<Task> getAllTasks() {
        return jdbcTemplate.query(SELECT_ALL_TASKS_SQL,
                this::mapRowToTask);

    }

    @Override
    public List<Task> getTasksByCategory(String category) {
        return jdbcTemplate.query(SELECT_TASKS_BY_CATEGORY_SQL,
                this::mapRowToTask, category);

    }

    @Override
    public void updateTask(Task task) {
        jdbcTemplate.update(UPDATE_TASK_SQL,
                task.getTaskDescription(),
                task.getCreateDate(),
                task.getDueDate(),
                task.getTaskId());
    }

    @Override
    public void deleteTask(int id) {

        jdbcTemplate.update(DELETE_TASK_SQL, id);
    }

    // Helper methods
    private Task mapRowToTask(ResultSet rs, int rowNum) throws SQLException {
        Task task = new Task();
        task.setTaskId(rs.getInt("task_id"));
        task.setTaskDescription(rs.getString("task_description"));
        task.setCreateDate(rs.getDate("create_date").toLocalDate());
        task.setDueDate(rs.getDate("due_date").toLocalDate());
        task.setCategory(rs.getString("category"));

        return task;
    }
}
