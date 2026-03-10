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
    // 1. Obtenemos los datos una sola vez
    AppointmentService service = new AppointmentService();
    List<Appointment> data = service.getAll();

    // 2. Definimos una lista con los nombres de las clases de los plugins que queremos probar
    String[] pluginsParaProbar = {
        "co.unicauca.microkernel.plugin.html.HtmlReportPlugin",
        "co.unicauca.microkernel.plugin.json.JsonReportPlugin"
    };

    // 3. Recorremos cada plugin y generamos el reporte
    for (String className : pluginsParaProbar) {
        System.out.println("\n>>> PROBANDO PLUGIN: " + className);
        
        IReportPlugin plugin = ReportPluginManager.getPlugin(className);

        if (plugin != null) {
            String result = plugin.generateReport(data);
            System.out.println("--- REPORTE GENERADO ---");
            System.out.println(result);
            System.out.println("------------------------");
        } else {
            System.out.println("ERROR: No se pudo cargar el plugin: " + className);
        }
    }
}
}
