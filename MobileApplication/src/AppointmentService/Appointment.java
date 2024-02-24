package AppointmentService;

import java.util.Date;

public class Appointment {
    private String appointmentId;
    private Date appointmentDate;
    private String description;

    public Appointment(String appointmentId, Date appointmentDate, String description) {
        if (appointmentId == null || appointmentId.length() > 10) {
            if (appointmentId == null)
            	throw new IllegalArgumentException("Appointment ID must not be null");
            else {
            	throw new IllegalArgumentException("Appointment ID must not exceed 10 characters");
            }
        }
        
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment Date must not be null and should not be in the past");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must not be null and should not exceed 50 characters");
        }

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }
}

