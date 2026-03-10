package co.unicauca.microkernel.plugin.json; // Cambiado al paquete del Core

import co.unicauca.microkernel.entities.Appointment;
import co.unicauca.microkernel.interfaces.IReportPlugin;
import java.util.List;

public class ReportService {
    
    // Este método es el que invoca a la reflexión del Manager
    public String generateReport(String pluginClassName, List<Appointment> data) {
        // Ahora sí encontrará al ReportPluginManager
        IReportPlugin plugin = ReportPluginManager.getPlugin(pluginClassName);
        
        if (plugin == null) {
            return "Error: No se pudo cargar el plugin " + pluginClassName;
        }
        return plugin.generateReport(data);
    }
}