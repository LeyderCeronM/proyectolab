package co.unicauca.microkernel.core.business;

import co.unicauca.microkernel.entities.Appointment;
import java.util.ArrayList;
import java.util.List;

public class AppointmentService {
    public List<Appointment> getAll() {
        List<Appointment> list = new ArrayList<>();
        list.add(new Appointment("Leidy", "2026-03-10", "15:00"));
        return list;
    }
}