package co.unicauca.microkernel.interfaces;

import co.unicauca.microkernel.entities.Appointment;
import java.util.List;

public interface IReportPlugin {
    String generateReport(List<Appointment> data);
}