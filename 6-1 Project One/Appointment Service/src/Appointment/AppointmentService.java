package Appointment;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private final Map<String, Appointment> appointments;

    public AppointmentService() {
        appointments = new HashMap<>();
    }

    // Add appointment if appointment ID is unique
    public boolean addAppointment(Appointment appointment) {
        if (appointment == null || appointments.containsKey(appointment.getAppointmentId())) {
            return false; // Appointment ID is not unique or appointment is null
        }
        appointments.put(appointment.getAppointmentId(), appointment);
        return true;
    }

    // Delete appointment by appointment ID
    public boolean deleteAppointment(String appointmentId) {
        if (appointmentId == null || !appointments.containsKey(appointmentId)) {
            return false; // Appointment ID is null or not found
        }
        appointments.remove(appointmentId);
        return true;
    }

    // Get appointment by appointment ID
    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}