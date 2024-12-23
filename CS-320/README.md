# README for Mobile Application Project

## Overview
This project consists of a suite of Java classes and corresponding JUnit tests for managing appointments, contacts, and tasks. The system ensures data integrity and enforces constraints through rigorous validations in the constructors and service methods.

## Table of Contents
1. [Project Structure](#project-structure)
2. [Features](#features)
3. [Classes and Tests](#classes-and-tests)
4. [Setup and Execution](#setup-and-execution)
5. [Usage](#usage)
6. [Running Tests](#running-tests)

## Project Structure
```
src/main/java/com/app/
  - Appointment.java
  - AppointmentService.java
  - Contact.java
  - ContactService.java
  - Task.java
  - TaskService.java

src/test/java/com/app/
  - AppointmentTest.java
  - AppointmentServiceTest.java
  - ContactTest.java
  - ContactServiceTest.java
  - TaskTest.java
  - TaskServiceTest.java
```

## Features
### Appointment Management
- Create, update, and delete appointments.
- Enforces unique appointment IDs.
- Validates date and description constraints.

### Contact Management
- Create, update, and delete contacts.
- Enforces unique contact IDs.
- Validates field constraints (e.g., phone number length, address, names).

### Task Management
- Create, update, and delete tasks.
- Enforces unique task IDs.
- Validates task name and description constraints.

## Classes and Tests

### Appointment
**Features:**
- Fields: `appointmentId`, `appointmentDate`, `appointmentDescription`
- Validations:
  - `appointmentId`: Must be non-null and unique.
  - `appointmentDate`: Must be a future date.
  - `appointmentDescription`: Must be non-null and less than or equal to 50 characters.

**Tests:**
- Constructor validations for valid and invalid inputs.
- Setter methods to update date and description.
- Validation of unique IDs and field constraints.

**Test File:** `AppointmentTest.java`

### AppointmentService
**Features:**
- Add, update, delete, and retrieve appointments.
- Ensures unique IDs and constraints for all fields.

**Tests:**
- Adding valid and duplicate appointments.
- Updating appointment details.
- Deleting existing and non-existent appointments.

**Test File:** `AppointmentServiceTest.java`

### Contact
**Features:**
- Fields: `contactId`, `firstName`, `lastName`, `phoneNum`, `address`
- Validations:
  - `contactId`: Must be non-null, unique, and <= 10 characters.
  - `phoneNum`: Must be exactly 10 digits.
  - Other fields must be non-null and non-empty.

**Tests:**
- Constructor validations for valid and invalid inputs.
- Setter methods for updating fields.
- Unique ID validations.

**Test File:** `ContactTest.java`

### ContactService
**Features:**
- Add, update, delete, and retrieve contacts.
- Ensures unique IDs and constraints for all fields.

**Tests:**
- Adding valid and duplicate contacts.
- Updating contact details.
- Deleting existing and non-existent contacts.

**Test File:** `ContactServiceTest.java`

### Task
**Features:**
- Fields: `taskId`, `taskName`, `taskDescription`
- Validations:
  - `taskId`: Must be non-null, unique, and <= 10 characters.
  - `taskName`: Must be non-null and <= 20 characters.
  - `taskDescription`: Must be non-null and <= 50 characters.

**Tests:**
- Constructor validations for valid and invalid inputs.
- Setter methods for updating fields.
- Unique ID validations.

**Test File:** `TaskTest.java`

### TaskService
**Features:**
- Add, update, delete, and retrieve tasks.
- Ensures unique IDs and constraints for all fields.

**Tests:**
- Adding valid and duplicate tasks.
- Updating task details.
- Deleting existing and non-existent tasks.

**Test File:** `TaskServiceTest.java`

## Setup and Execution
### Prerequisites
- Java 8 or higher
- Maven
- JUnit 5

### Setup
1. Clone the repository:
   ```
git clone https://github.com/your-repo/appointment-contact-task-manager.git
```
2. Navigate to the project directory:
   ```
cd appointment-contact-task-manager
```
3. Build the project using Maven:
   ```
mvn clean install
```

## Usage
### Running the Application
This project is designed for testing and demonstration purposes. To integrate with a larger application, use the `Service` classes (`AppointmentService`, `ContactService`, and `TaskService`) to manage data.

## Running Tests
1. Navigate to the project directory.
2. Execute the following command:
   ```
mvn test
```
3. View test results in the console or the `target/surefire-reports` directory.

## Q&A Section
### How can I ensure that my code, program, or software is functional and secure?  
Use comprehensive testing (e.g., JUnit), enforce strict input validations in constructors and methods, and handle edge cases to maintain functionality and security.

### How do I interpret user needs and incorporate them into a program?  
Translate user requirements into core features (e.g., managing appointments, contacts, and tasks), and implement validations that reflect real-world constraints like unique IDs and valid dates.

### How do I approach designing software?  
Adopt modular design with separate classes for specific entities, use service classes for operations, and follow test-driven development to align code with functionality.




