package co.unicauca.microkernel.core.app;

import co.unicauca.microkernel.core.business.AppointmentService;
import co.unicauca.microkernel.core.plugin.manager.ReportPluginManager;
import co.unicauca.microkernel.entities.Appointment;
import co.unicauca.microkernel.interfaces.IReportPlugin;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class Application {
  public static void main(String[] args) {
    String pluginClassName = "co.unicauca.microkernel.plugin.html.HtmlReportPlugin";
    IReportPlugin plugin = ReportPluginManager.getPlugin(pluginClassName);

    if (plugin != null) {
        AppointmentService service = new AppointmentService();
        List<Appointment> data = service.getAll();
        
        // Aquí es donde se genera y se muestra
        String result = plugin.generateReport(data);
        System.out.println("\n--- REPORTE GENERADO ---");
        System.out.println(result);
        System.out.println("------------------------");
    } else {
        System.out.println("No se pudo cargar el plugin. Revisa el error arriba.");
    }
}
}
