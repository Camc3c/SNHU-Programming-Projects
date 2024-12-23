package com.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class TaskServiceTest {

    private TaskService taskService;

    @BeforeEach
    void setUp() {
        // Clear global list of Taks before each test
        Task.getExistingTasks().clear();
        taskService = new TaskService();
    }
    
    @Test
    void testAddTask() {
        taskService.addTask("123", "Read eMail", "Read eMail sent out by Admin");
        List<Task> tasks = taskService.getAllTasks();

        assertEquals(1, tasks.size());
        assertEquals("123", tasks.get(0).getTaskId());
        assertEquals("Read eMail", tasks.get(0).getTaskName());
        assertEquals("Read eMail sent out by Admin", tasks.get(0).getTaskDescription());
    }

    @Test
    void testAddDuplicateTaskId() {
        taskService.addTask("123", "Read eMail", "Read eMail sent out by Admin");
        assertThrows(IllegalArgumentException.class, () -> taskService.addTask("123", "Edit file", "Edit file from database"));
    }

    @Test
    void testDeleteTask() {
        taskService.addTask("123", "Read eMail", "Read eMail sent out by Admin");
        boolean removed = taskService.deleteTask("123");

        assertTrue(removed);
        assertTrue(taskService.getAllTasks().isEmpty());
        assertFalse(Task.getExistingTasks().contains("123"));
    }

    @Test
    void testDeleteNonexistentTask() {
        assertFalse(taskService.deleteTask("999"));
    }

    @Test
    void testUpdateTask() {
        taskService.addTask("123", "Read eMail", "Read eMail sent out by Admin");
        taskService.updateTask("123", "Edit file", "Edit file from database");

        Task updatedTask = taskService.getAllTasks().get(0);
        assertEquals("Edit file", updatedTask.getTaskName());
        assertEquals("Edit file from database", updatedTask.getTaskDescription());
    }

    @Test
    void testUpdateNonexistentTask() {
        assertThrows(IllegalArgumentException.class, () -> taskService.updateTask("999", "Update Time Sheet", "Update this weeks time sheet before friday"));
    }
}