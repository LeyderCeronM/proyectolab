package co.unicauca.microkernel.plugin.html;

import co.unicauca.microkernel.entities.Appointment;
import co.unicauca.microkernel.interfaces.IReportPlugin;
import java.util.List;

public class HtmlReportPlugin implements IReportPlugin {

    @Override
    public String generateReport(List<Appointment> data) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html>\n<head><title>Reporte de Citas</title></head>\n<body>\n");
        sb.append("<h2>Listado de Citas Agendadas</h2>\n");
        sb.append("<table border='1'>\n<tr><th>Paciente</th><th>Fecha</th><th>Hora</th></tr>\n");

        for (Appointment app : data) {
            sb.append("<tr>\n");
            sb.append("  <td>").append(app.getPatientName()).append("</td>\n");
            sb.append("  <td>").append(app.getDate()).append("</td>\n");
            sb.append("  <td>").append(app.getTime()).append("</td>\n");
            sb.append("</tr>\n");
        }

        sb.append("</table>\n</body>\n</html>");
        return sb.toString();
    }
}