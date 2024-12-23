package com.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.Date;
import java.util.Calendar;
import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {

    private Date validFutureDate;
    private Date pastDate;
    
    @BeforeEach
    void setup() {
        // Reset existingIds before each test
        Appointment.getExistingAppointments().clear();

        Calendar calendar = Calendar.getInstance();

        // Set a valid future date (5 days from now)
        calendar.add(Calendar.DAY_OF_MONTH, 5);
        validFutureDate = calendar.getTime();

        // Set a past date (5 days ago)
        calendar.add(Calendar.DAY_OF_MONTH, -10);
        pastDate = calendar.getTime();
    }

    @Test
    void testConstructorWithValidInputs() {
        Appointment appointment = new Appointment("123", validFutureDate, "Appointment with team head");
        assertEquals("123", appointment.getAppointmentId());
        assertEquals(validFutureDate, appointment.getAppointmentDate());
        assertEquals("Appointment with team head", appointment.getAppointmentDescription());
    }

    @Test
    void testConstructorWithInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment(null, validFutureDate, "Test Description"), "Appointment ID does not meet specifications");
        assertThrows(IllegalArgumentException.class, () -> new Appointment("01234567890", validFutureDate, "Test Description"), "Appointment ID does not meet specifications");
    }
    
    @Test
    void testConstructorWithInvalidDate() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment("123", pastDate, "Test Description"), "Appointment date cannot be in the past.");
    }

    @Test
    void testConstructorWithInvalidDescription() {
        assertThrows(IllegalArgumentException.class, () -> new Appointment("123", validFutureDate, null), "Appointment Description does not meet specifications");
        assertThrows(IllegalArgumentException.class, () -> new Appointment("123", validFutureDate, "Very long description exceeding fifty characters to trigger an error"),"Appointment Description does not meet specifications");
    }

    @Test
    void testSetAppointmentDate() {
        Appointment appointment = new Appointment("456", validFutureDate, "Test Description");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 10);
        Date newDate = calendar.getTime();

        appointment.setAppointmentDate(newDate);
        assertEquals(newDate, appointment.getAppointmentDate());
    }

    @Test
    void testSetAppointmentDescription() {
        Appointment appointment = new Appointment("456", validFutureDate, "Old Description");
        appointment.setAppointmentDescription("New Description");
        assertEquals("New Description", appointment.getAppointmentDescription());
    }
}