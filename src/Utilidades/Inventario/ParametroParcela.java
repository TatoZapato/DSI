/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades.Inventario;

import java.sql.Date;
import java.util.LinkedList;

/**
 *
 * @author Führer
 */
public class ParametroParcela {

    private int ordenTrabajo;
    private String fechaMedicion;
    private String tipoInventario;
    private String fundo;
    private String rodal;
    private String especiePrincipal;
    private String especieSecundaria;
    private Date fechaProyeccion;
    private LinkedList<DetalleParcela> detalles;
    private ParametroGeneral parametro;

    public ParametroParcela(ParametroGeneral pg) {
        detalles = new LinkedList();
        parametro = pg;
        ordenTrabajo = parametro.getOrdenTrabajo();
        fechaMedicion = parametro.getFechaMedicion();
        tipoInventario = parametro.getTipoInventario();
        fundo = parametro.getFundo();
        rodal = parametro.getRodal();
        especiePrincipal = parametro.getEspeciePrincipal();
        especieSecundaria = parametro.getEspecieSecundaria();
        fechaProyeccion = new Date(new java.util.Date().getTime());
    }

    public ParametroParcela() {
    }
    

    public int getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(int ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }

    public String getFechaMedicion() {
        return fechaMedicion;
    }

    public void setFechaMedicion(String fechaMedicion) {
        this.fechaMedicion = fechaMedicion;
    }

    public String getTipoInventario() {
        return tipoInventario;
    }

    public void setTipoInventario(String tipoInventario) {
        this.tipoInventario = tipoInventario;
    }

    public String getFundo() {
        return fundo;
    }

    public void setFundo(String fundo) {
        this.fundo = fundo;
    }

    public String getRodal() {
        return rodal;
    }

    public void setRodal(String rodal) {
        this.rodal = rodal;
    }

    public String getEspeciePrincipal() {
        return especiePrincipal;
    }

    public void setEspeciePrincipal(String especiePrincipal) {
        this.especiePrincipal = especiePrincipal;
    }

    public String getEspecieSecundaria() {
        return especieSecundaria;
    }

    public void setEspecieSecundaria(String especieSecundaria) {
        this.especieSecundaria = especieSecundaria;
    }

    public Date getFechaProyeccion() {
        return fechaProyeccion;
    }

    public void setFechaProyeccion(Date fechaProyeccion) {
        this.fechaProyeccion = fechaProyeccion;
    }

    public LinkedList<DetalleParcela> getDetalles() {
        return detalles;
    }

    public void setDetalles(LinkedList<DetalleParcela> detalles) {
        this.detalles = detalles;
    }

    public ParametroGeneral getParametro() {
        return parametro;
    }

    public void setParametro(ParametroGeneral parametro) {
        this.parametro = parametro;
    }
    
    @Override
    public String toString() {
        return "ParametroParcela: ["+ordenTrabajo+", "+fechaMedicion+", "+tipoInventario+", "+fundo+", "+rodal+", "+
                especiePrincipal+", "+especieSecundaria+", "+fechaProyeccion+", "+detalles.size();
    }
}
