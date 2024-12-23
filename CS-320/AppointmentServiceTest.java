package com.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.Date;
import java.util.Calendar;
import static org.junit.jupiter.api.Assertions.*;

class AppointmentServiceTest {
    
    private AppointmentService appointmentService;
    private Date validFutureDate;
    private Date anotherValidFutureDate;
    private Date pastDate;

    @BeforeEach
    void setUp() {
        // Reset existingIds before each test
        Appointment.getExistingAppointments().clear();

        appointmentService = new AppointmentService();
        Calendar calendar = Calendar.getInstance();

        // Set valid future dates
        calendar.add(Calendar.DAY_OF_MONTH, 5);
        validFutureDate = calendar.getTime();
        calendar.add(Calendar.DAY_OF_MONTH, 2);
        anotherValidFutureDate = calendar.getTime();

        // Set a past date
        calendar.add(Calendar.DAY_OF_MONTH, -10);
        pastDate = calendar.getTime();
    }

    @Test
    void testAddAppointment() {
        appointmentService.addAppointment("123", validFutureDate, "Test Appointment");
        assertEquals(1, appointmentService.getAllAppointments().size());
        assertEquals("123", appointmentService.getAllAppointments().get(0).getAppointmentId());
    }

    @Test
    void testAddDuplicateAppointment() {
        appointmentService.addAppointment("123", validFutureDate, "Test Appointment");
        assertThrows(IllegalArgumentException.class, () -> appointmentService.addAppointment("123", anotherValidFutureDate, "Another Test"), "Appointment ID must be unique");
    }

    @Test
    void testDeleteAppointment() {
        appointmentService.addAppointment("123", validFutureDate, "Test Appointment");
        boolean removed = appointmentService.deleteAppointment("123");
        assertTrue(removed);
        assertEquals(0, appointmentService.getAllAppointments().size());
    }

    @Test
    void testDeleteNonExistentAppointment() {
        boolean removed = appointmentService.deleteAppointment("NonExistent");
        assertFalse(removed);
    }

    @Test
    void testUpdateAppointment() {
        appointmentService.addAppointment("456", validFutureDate, "Old Description");

        // Update the appointment
        appointmentService.updateAppointment("456", anotherValidFutureDate, "New Description");

        Appointment updatedAppointment = appointmentService.getAllAppointments().get(0);
        assertEquals(anotherValidFutureDate, updatedAppointment.getAppointmentDate());
        assertEquals("New Description", updatedAppointment.getAppointmentDescription());
    }

    @Test
    void testUpdateNonExistentAppointment() {
        assertThrows(IllegalArgumentException.class, () -> appointmentService.updateAppointment("NonExistent", validFutureDate, "Test"), "Appointment ID does not exist");
    }

    @Test
    void testAddAppointmentWithPastDate() {
    assertThrows(IllegalArgumentException.class, () -> appointmentService.addAppointment("123", pastDate, "Test Appointment"), "Appointment date cannot be in the past");
    }

    @Test
    void testAddAppointmentWithNullDescription() {
        assertThrows(IllegalArgumentException.class, () -> appointmentService.addAppointment("123", validFutureDate, null), "Appointment description cannot be null or empty");
    }
}