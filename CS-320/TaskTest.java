package com.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @BeforeEach
    void clearExistingTasks() {
        // Reset existingTasks before each test
        Task.getExistingTasks().clear();
    }
    
    @Test
    void testValidTaskCreation() {
        Task task = new Task("123", "Read eMail", "Read eMail sent out by Admin");
        assertEquals("123", task.getTaskId());
        assertEquals("Read eMail", task.getTaskName());
        assertEquals("Read eMail sent out by Admin", task.getTaskDescription());
    }

    @Test
    void testInvalidTaskId() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Read eMail", "Read eMail sent out by Admin"));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Read eMail", "Read eMail sent out by Admin"));
    }

    @Test
    void testDuplicateTaskId() {
        new Task("123", "Read eMail", "Read eMail sent out by Admin");
        assertThrows(IllegalArgumentException.class, () -> new Task("123", "Edit file", "Edit file from database"));
    }

    @Test
    void testInvalidFieldValues() {
        assertThrows(IllegalArgumentException.class, () -> new Task("123", null, "Read eMail sent out by Admin"));
        assertThrows(IllegalArgumentException.class, () -> new Task("123", "Read eMail", null));
    }

    @Test
    void testUpdateFields() {
        Task task = new Task("123", "Read eMail", "Read eMail sent out by Admin");
        task.setTaskName("Edit file");
        task.setTaskDescription("Edit file from database");

        assertEquals("Edit file", task.getTaskName());
        assertEquals("Edit file from database", task.getTaskDescription());
    }
}