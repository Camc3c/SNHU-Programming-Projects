package com.app;

import java.util.ArrayList;
import java.util.List;

/**
 * A class designed to hold information about tasks
 * taskId is a unique ID, shall not be longer than 10 characters, shall not be null, and shall not be updated
 * taskName shall not be longer than 20 characters and shall not be null
 * taskDescription shall not be longer than 50 characters and shall not be null
 */

 public class Task {

    private static List<String> existingTasks = new ArrayList<>();
    private String taskId;
    private String taskName;
    private String taskDescription;

    /**
     * Constructor with all attributes
     */
    public Task(String taskId, String taskName, String taskDescription) {

        // If statements to checking for valid inputs
        // Validate taskId
        if(taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Task ID does not meet specifications");
        }
        if (existingTasks.contains(taskId)) {
            throw new IllegalArgumentException("Task ID must be unique");
        }

        // Validate other fields
        if(taskName == null || taskName.length() > 20) {
            throw new IllegalArgumentException("Task Name does not meet specifications");
        }
        if(taskDescription == null || taskDescription.length() > 50) {
            throw new IllegalArgumentException("Task Description does not meet specifications");
        }

        /**
         * If specifications are met then contact object will be created
         * with entered agruments
         */
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;

         // Add contactId to the list
        existingTasks.add(taskId);
    }

    /**
     * Method for getting task ID
     * @return the taskId variable
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * Method for getting task name
     * @return the taskName variable
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * Method for getting task description
     * @return the taskDescrip variable
     */
    public String getTaskDescription() {
        return taskDescription;
    }

    /**
     * Method for getting the list of tasks
     * @return the existingTasks List
     */
    public static List<String> getExistingTasks() {
        return existingTasks;
    }

    /**
     * Method for setting task name
     * @param taskName to be set as task name
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    /**
     * Method for setting task description
     * @param taskDescription to be set as task name
     */
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
 }