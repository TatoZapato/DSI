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

    private final String logo = "/Utilidades/Reportes/Logo.jpg";
    public void reporteDetallesParametrosGeneralUnico(int valor) {
        try {
            Connection conn = DAOManager.getConnection();
            String url = "General.jasper";
            Map parametros = new HashMap();
            parametros.put("OrdenTrabajo", valor);
            parametros.put("Logo",this.getClass().getResourceAsStream(logo));
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
            parametros.put("Logo",this.getClass().getResourceAsStream(logo));
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource(url));
            JasperPrint print = JasperFillManager.fillReport(report, parametros, conn);
            JasperViewer viewer = new JasperViewer(print,false);
            viewer.setTitle("Reporte Detalles Parametros por Parcela");
            viewer.setVisible(true);
        } catch (DAOException | JRException e) {
            System.out.println("error " + e.toString());
        }
    }
    
    public void reporteDetallesTablaRodalUnico(int valor) {
        try {
            Connection conn = DAOManager.getConnection();
            String url = "Rodal.jasper";
            Map parametros = new HashMap();
            parametros.put("OrdenTrabajo", valor);            
            parametros.put("Logo",this.getClass().getResourceAsStream(logo));
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource(url));
            JasperPrint print = JasperFillManager.fillReport(report, parametros, conn);
            JasperViewer viewer = new JasperViewer(print,false);
            viewer.setTitle("Reporte Detalles Tabla Rodal");
            viewer.setVisible(true);
        } catch (DAOException | JRException e) {
            System.out.println("error " + e.toString());
        }
    }
}
