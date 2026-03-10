package co.unicauca.microkernel.core.plugin.manager;

import co.unicauca.microkernel.interfaces.IReportPlugin;

public class ReportPluginManager {
   public static IReportPlugin getPlugin(String className) {
    try {
        System.out.println("Buscando clase: " + className);
        Class<?> pluginClass = Class.forName(className);
        return (IReportPlugin) pluginClass.getDeclaredConstructor().newInstance();
    } catch (Exception e) {
        // ESTO ES LO MÁS IMPORTANTE:
        System.out.println("FALLO CRÍTICO AL INSTANCIAR:");
        e.printStackTrace(); 
        return null;
    }
}
}