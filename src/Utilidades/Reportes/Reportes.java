package Utilidades.Reportes;

import Utilidades.Persistencia.DAOManager.DAOException;
import Utilidades.Persistencia.DAOManager.DAOManager;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Jorge
 */
public class Reportes {

    public void reporteDetallesParametrosGeneralUnico(int valor) {
        try {
            Connection conn = DAOManager.getConnection();
            String url = "General.jasper";
            Map parametros = new HashMap();
            parametros.put("OrdenTrabajo", valor);
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource(url));
            JasperPrint print = JasperFillManager.fillReport(report, parametros, conn);
            JasperViewer viewer = new JasperViewer(print,false);
            viewer.setTitle("Reporte Detalles Parametros Generales");
            viewer.setVisible(true);
        } catch (DAOException | JRException e) {
            System.out.println("error " + e.toString());
        }
    }
    
    public void reporteDetallesParametrosParcelaUnico(int valor) {
        try {
            Connection conn = DAOManager.getConnection();
            String url = "Parcela.jasper";
            Map parametros = new HashMap();
            parametros.put("OrdenTrabajo", valor);
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource(url));
            JasperPrint print = JasperFillManager.fillReport(report, parametros, conn);
            JasperViewer viewer = new JasperViewer(print,false);
            viewer.setTitle("Reporte Detalles Parametros por Parcela");
            viewer.setVisible(true);
        } catch (DAOException | JRException e) {
            System.out.println("error " + e.toString());
        }
    }
}
