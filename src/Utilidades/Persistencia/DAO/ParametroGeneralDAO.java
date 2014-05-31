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
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Führer
 */
public class ParametroGeneralDAO {

    private static final String INSERTAR_PARAMETRO = "INSERT INTO T_INV_PARAMETROGENERAL (EM_PROPIETARIA,FUNDO,RODAL,ANO_PLANTACION,ES_PRINCIPAL,ES_SECUNDARIA,NM_ESPECIES,CD_ORDEN_TRABAJO,FC_MEDICION,TP_INVENTARIO,NM_PARCELAS,SUPERFICIE_PARCELAS,EM_DE_SERVICIOS,FC_PROYECCION,DENSIDAD,DENSIDAD_P,DENSIDAD_MP,DAP_MEDIO,DAP_MEDIO_P,DAP_MEDIO_MP,AREA_BASAL,AREA_BASAL_P,AREA_BASAL_MP,ALTURA_TOTAL_MEDIA,ALTURA_TOTAL_MEDIA_P,ALTURA_TOTAL_MEDIA_MP,VOLUMEN,VOLUMEN_P,VOLUMEN_MP,MOD_ALTURA,B0,B1,B2,B3,B4,B5,B6,AJUSTE,SUPERFICIE_RODAL) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String ELIMINA_PARAMETRO = "DELETE FROM T_INV_PARAMETROGENERAL WHERE CD_ORDEN_TRABAJO = ?";

    public static boolean insertarParametroGeneral(ParametroGeneral p) throws DAOException, SQLException {
        Connection conn = DAOManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(INSERTAR_PARAMETRO)) {
            ps.setString(1, p.getEmPropietaria());
            ps.setInt(2, p.getFundo());
            ps.setInt(3, p.getRodal());
            ps.setString(4, p.getAnoPlantacion());
            ps.setString(5, p.getEspeciePrincipal());
            ps.setString(6, p.getEspecieSecundaria());
            ps.setInt(7, p.getNumEspecies());
            ps.setInt(8, p.getOrdenTrabajo());
            ps.setDate(9, p.getFechaMedicion());
            ps.setInt(10, p.getTipoInventario());
            ps.setInt(11, p.getNumParcelas());
            ps.setFloat(12, p.getSuperficieParcelas());
            ps.setString(13, p.getEmpresaServicios());
            ps.setDate(14, new Date(new java.util.Date().getTime()));
            ps.setFloat(15, p.getDensidad());
            ps.setFloat(16, p.getDensidadP());
            ps.setFloat(17, p.getDensidadNP());
            ps.setFloat(18, p.getDapMedio());
            ps.setFloat(19, p.getDapMedioP());
            ps.setFloat(20, p.getDapMedioNP());
            ps.setFloat(21, p.getAreaBasal());
            ps.setFloat(22, p.getAreaBasalP());
            ps.setFloat(23, p.getAreaBasalNP());
            ps.setFloat(24, p.getAlturaTotalMedia());
            ps.setFloat(25, p.getAlturaTotalMediaP());
            ps.setFloat(26, p.getAlturaTotalMediaNP());
            ps.setFloat(27, p.getVolumen());
            ps.setFloat(28, p.getVolumenP());
            ps.setFloat(29, p.getVolumenNP());
            ps.setString(30, p.getModeloAltura());
            int i = 31;
            for (float b : p.getBO()) {
                ps.setFloat(i, b);
                i++;
            }
            ps.setFloat(38, p.getAjuste());
            ps.setFloat(39, p.getSuperficieRodal());
            ResultSet rs = ps.executeQuery();
            rs.close();
            ps.close();
        } catch (SQLException e) {
            conn.rollback();
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
}
