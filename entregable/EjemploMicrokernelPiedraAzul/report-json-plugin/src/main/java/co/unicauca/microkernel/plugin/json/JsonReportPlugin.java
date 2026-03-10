package co.unicauca.microkernel.plugin.json;

import co.unicauca.microkernel.entities.Appointment;
import co.unicauca.microkernel.interfaces.IReportPlugin;
import java.util.List;

public class JsonReportPlugin implements IReportPlugin {

    @Override
    public String generateReport(List<Appointment> data) {
        StringBuilder sb = new StringBuilder();
        sb.append("[\n");
        for (int i = 0; i < data.size(); i++) {
            Appointment app = data.get(i);
            sb.append("  {\n");
            sb.append("    \"paciente\": \"").append(app.getPatientName()).append("\",\n");
            sb.append("    \"fecha\": \"").append(app.getDate()).append("\",\n");
            sb.append("    \"hora\": \"").append(app.getTime()).append("\"\n");
            sb.append("  }");
            if (i < data.size() - 1) sb.append(",");
            sb.append("\n");
        }
        sb.append("]");
        return sb.toString();
    }
}