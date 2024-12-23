package com.app;

import java.util.ArrayList;
import java.util.List;

public class TaskService {

    // List to hold Task objects
    private List<Task> tasks;

    public TaskService() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Adds a new task with a unique ID.
     * 
     * @param taskId task unique ID
     * @param taskName tasks name
     * @param taskDescription  tasks description
     * @throws IllegalArgumentException if any parameter fails validation
     */
    public void addTask(String taskId, String taskName, String taskDescription) {
        Task newTask = new Task(taskId, taskName, taskDescription);
        // Add to local list if the constructor succeeds
        tasks.add(newTask);
    }

    /**
     * Deletes a contact by ID.
     * 
     * @param taskId The ID of the task to delete
     * @return true if the task was removed, false otherwise
     */
    public boolean deleteTask(String taskId) {
        boolean removed = tasks.removeIf(task -> task.getTaskId().equals(taskId));
        if (removed) {
            // Remove ID from the global list
            Task.getExistingTasks().remove(taskId);
        }
        return removed;
    }

    /**
     * Updates the fields of a task by ID.
     * 
     * @param taskId The ID of the task to update
     * @param taskName New task name (nullable if not updating)
     * @param taskDescription  New task description (nullable if not updating)
     * @throws IllegalArgumentException if the task ID is invalid or any update value fails validation
     */
    public void updateTask(String taskId, String taskName, String taskDescription) {
        Task task = findTaskById(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task ID does not exist");
        }

        // Check for null entries
        if (taskName != null) {
            task.setTaskName(taskName);
        }
        if (taskDescription != null) {
            task.setTaskDescription(taskDescription);
        }
    }

    /**
     * Finds a task by ID.
     * 
     * @param taskId The ID to search for
     * @return The matching Task object, or null if not found
     */
    private Task findTaskById(String taskId) {
        for (Task task : tasks) {
            if (task.getTaskId().equals(taskId)) {
                return task;
            }
        }
        return null;
    }

    /**
     * Returns the list of all tasks.
     * 
     * @return List of tasks
     */
    public List<Task> getAllTasks() {
        // Return a copy of the list to ensure immutability
        return new ArrayList<>(tasks);
    }
}