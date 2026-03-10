package co.unicauca.microkernel.entities;

public class Appointment {
    private String patientName;
    private String date;
    private String time;

    public Appointment(String patientName, String date, String time) {
        this.patientName = patientName;
        this.date = date;
        this.time = time;
    }

    public String getPatientName() { return patientName; }
    public String getDate() { return date; }
    public String getTime() { return time; }
}