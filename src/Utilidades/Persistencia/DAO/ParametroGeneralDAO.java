/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades.Persistencia.DAO;

import Utilidades.Inventario.ParametroGeneral;
import Utilidades.Persistencia.DAOManager.DAOException;
import Utilidades.Persistencia.DAOManager.DAOManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Führer
 */
public class ParametroGeneralDAO {

    private static final String INSERTAR_PARAMETRO = "INSERT INTO T_INV_PARAMETROGENERAL (EM_PROPIETARIA,FUNDO,RODAL,ANO_PLANTACION,ES_PRINCIPAL,ES_SECUNDARIA,NM_ESPECIES,CD_ORDEN_TRABAJO,FC_MEDICION,TP_INVENTARIO,NM_PARCELAS,SUPERFICIE_PARCELAS,EM_DE_SERVICIOS,FC_PROYECCION,DENSIDAD,DENSIDAD_P,DENSIDAD_NP,DAP_MEDIO,DAP_MEDIO_P,DAP_MEDIO_NP,AREA_BASAL,AREA_BASAL_P,AREA_BASAL_NP,ALTURA_TOTAL_MEDIA,ALTURA_TOTAL_MEDIA_P,ALTURA_TOTAL_MEDIA_NP,VOLUMEN,VOLUMEN_P,VOLUMEN_NP,MOD_ALTURA,B0,B1,B2,B3,B4,B5,B6,AJUSTE,SUPERFICIE_RODAL,FACTOR_EXPANSION) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String INSERTAR_PARAMETRO_V2 = "INSERT INTO T_INV_PARAMETROGENERAL (EM_PROPIETARIA,FUNDO,RODAL,ANO_PLANTACION,ES_PRINCIPAL,ES_SECUNDARIA,NM_ESPECIES,CD_ORDEN_TRABAJO,FC_MEDICION,TP_INVENTARIO,NM_PARCELAS,SUPERFICIE_PARCELAS,EM_DE_SERVICIOS,DENSIDAD,DENSIDAD_P,DENSIDAD_NP,DAP_MEDIO,DAP_MEDIO_P,DAP_MEDIO_NP,AREA_BASAL,AREA_BASAL_P,AREA_BASAL_NP,ALTURA_TOTAL_MEDIA,ALTURA_TOTAL_MEDIA_P,ALTURA_TOTAL_MEDIA_NP,VOLUMEN,VOLUMEN_P,VOLUMEN_NP,MOD_ALTURA,B0,B1,B2,B3,B4,B5,B6,AJUSTE,FC_PROYECCION,FACTOR_EXPANSION,FUNCION_VOLUMEN,FUNCION_SITIO,VALOR_SITIO) VALUES (";
    private static final String OBTENER_PARAMETROS = "SELECT CD_ORDEN_TRABAJO,EM_PROPIETARIA, EM_DE_SERVICIOS, TP_INVENTARIO,FC_MEDICION,FUNDO,RODAL FROM T_INV_PARAMETROGENERAL";
    private static final String ELIMINA_PARAMETRO = "DELETE FROM T_INV_PARAMETROGENERAL WHERE CD_ORDEN_TRABAJO = ?";

    public static boolean insertarParametroGeneral(ParametroGeneral p) throws DAOException, SQLException {
        Connection conn = DAOManager.getConnection();
        //try (PreparedStatement ps = conn.prepareStatement(INSERTAR_PARAMETRO)) {
        try{
            String arrgs = INSERTAR_PARAMETRO_V2+"'"+p.getEmPropietaria()+"','";
            Statement ps = conn.createStatement();
//            ps.setString(1, p.getEmPropietaria());
//            ps.setInt(2, p.getFundo());
            
            arrgs+=p.getFundo()+"','";
            arrgs+=p.getRodal()+"','";
//            ps.setInt(3, p.getRodal());
//            ps.setString(4, p.getAnoPlantacion());
            arrgs+=p.getAnoPlantacion()+"','";
//            System.out.println(p.getEspeciePrincipal() +" especie principal");
//            ps.setString(5, p.getEspeciePrincipal());
            arrgs+=p.getEspeciePrincipal()+"','";
//            ps.setString(6, p.getEspecieSecundaria());
            arrgs+= p.getEspecieSecundaria()+"','";
//            ps.setInt(7, p.getNumEspecies());
            arrgs+= p.getNumEspecies()+"','";
//            ps.setInt(8, p.getOrdenTrabajo());
            arrgs+= p.getOrdenTrabajo()+"','";
//            ps.setDate(9, p.getFechaMedicion());
            arrgs+= p.getFechaMedicion()+"','";
//            ps.setString(10, p.getTipoInventario());
            
            arrgs+= p.getTipoInventario()+"','";
//            ps.setInt(11, p.getNumParcelas());
            arrgs+= p.getNumParcelas()+"','";
//            ps.setString(12, p.getSuperficieParcelas());
            arrgs+= p.getSuperficieParcelas()+"','";
//            ps.setString(13, p.getEmpresaServicios());
            arrgs+= p.getEmpresaServicios()+"','";
//            ps.setDate(14, new Date(new java.util.Date().getTime()));
//            ps.setString(15, p.getDensidad());
            arrgs+= p.getDensidad()+"','";
//            ps.setString(16, p.getDensidadP());
            arrgs+= p.getDensidadP()+"','";
//            ps.setString(17, p.getDensidadNP());
            arrgs+= p.getDensidadNP()+"','";
//            ps.setString(18, p.getDapMedio());
            arrgs+= p.getDapMedio()+"','";
//            ps.setString(19, p.getDapMedioP());
            arrgs+= p.getDapMedioP()+"','";
//            ps.setString(20, p.getDapMedioNP());
            arrgs+= p.getDapMedioNP()+"','";
//            ps.setString(21, p.getAreaBasal());
            arrgs+= p.getAreaBasal()+"','";
//            ps.setString(22, p.getAreaBasalP());
            arrgs+= p.getAreaBasalP()+"','";
//            ps.setString(23, p.getAreaBasalNP());
            arrgs+= p.getAreaBasalNP()+"','";
//            ps.setString(24, p.getAlturaTotalMedia());
            arrgs+= p.getAlturaTotalMedia()+"','";
//            ps.setString(25, p.getAlturaTotalMediaP());
            arrgs+= p.getAlturaTotalMediaP()+"','";
//            ps.setString(26, p.getAlturaTotalMediaNP());
            arrgs+= p.getAlturaTotalMediaNP()+"','";
//            ps.setString(27, p.getVolumen());
            arrgs+= p.getVolumen()+"','";
//            ps.setString(28, p.getVolumenP());
            arrgs+= p.getVolumenP()+"','";
//            ps.setString(29, p.getVolumenNP());
            arrgs+= p.getVolumenNP()+"','";
//            ps.setString(30, p.getModeloAltura());
            arrgs+= p.getModeloAltura()+"','";
            System.out.println(p.getBO().length);
            int i = 31;
            for (double b : p.getBO()) {
                //ps.setString(i, b+"");
                arrgs+= b+"','";
                i++;
            }
            System.out.println(i);
//            ps.setString(38, p.getAjuste());
            arrgs+= p.getAjuste()+"',";
            
            arrgs+= "to_date(SYSDATE,'DD/MM/RR'),'";
            arrgs+= p.getFactorExpansion()+"','";
            arrgs+= p.getFuncionVolumen()+"','";
            arrgs+= p.getFuncionSitio()+"','";
            arrgs+= p.getValorSitio()+"')";
            System.out.println(arrgs);
            //ResultSet rs = ps.executeQuery();
            ps.execute(arrgs);
            ps.close();
        } catch (SQLException e) {
            conn.rollback();
            System.out.println(e.toString() + "\n Error:");
            throw new DAOException(DAOException.IMPOSIBLE_MAKE_QUERY);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DAOException(DAOException.IMPOSIBLE_CLOSE_CONNECTION);
            }
        }
        return true;
    }

    public static boolean eliminaParametro(ParametroGeneral p) throws DAOException {
        Connection conn = DAOManager.getConnection();
        try (PreparedStatement ps = conn.prepareCall(ELIMINA_PARAMETRO)) {
            ps.setInt(1, p.getOrdenTrabajo());
            ResultSet rs = ps.executeQuery();
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw new DAOException(DAOException.IMPOSIBLE_MAKE_QUERY);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DAOException(DAOException.IMPOSIBLE_CLOSE_CONNECTION);
            }
        }
        return true;
    }
    
    
    public static LinkedList<ParametroGeneral> getAllParametroGeneral() throws DAOException{
        Connection conn = DAOManager.getConnection();
        LinkedList<ParametroGeneral> parametro = new LinkedList();

        try (PreparedStatement ps = conn.prepareStatement(OBTENER_PARAMETROS)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ParametroGeneral x = new ParametroGeneral();
                x.setOrdenTrabajo(rs.getInt("CD_ORDEN_TRABAJO"));
                x.setEmPropietaria(rs.getString("EM_PROPIETARIA"));
                x.setEmpresaServicios(rs.getString("EM_DE_SERVICIOS"));
                x.setTipoInventario("TP_INVENTARIO");
                x.setFechaMedicion(rs.getString("FC_MEDICION"));
                x.setFundo(rs.getString("FUNDO"));
                x.setRodal(rs.getString("RODAL"));
                parametro.add(x);
            }
            rs.close();
            ps.close();
            return parametro;
        } catch (SQLException e) {
            throw new DAOException(DAOException.IMPOSIBLE_MAKE_QUERY);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DAOException(DAOException.IMPOSIBLE_CLOSE_CONNECTION);
            }
        }
    }
}
