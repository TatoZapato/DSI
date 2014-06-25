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
public class TablaRodal {

    private int ordenTrabajo;
    private String tipoInventario;
    private String fundo;
    private String rodal;
    private String especie;
    private String fechaMedicion;
    private Date fechaProyeccion;
    private String modAltura;
    private double[] BO;
    private String ajuste;
    private LinkedList<DetalleTablaRodal> detalles;
    private ParametroGeneral parametro;
    
    public TablaRodal(ParametroGeneral par) {
        this.parametro = par;
        ordenTrabajo = parametro.getOrdenTrabajo();
        tipoInventario = parametro.getTipoInventario();
        fundo = parametro.getFundo();
        rodal = parametro.getRodal();
        especie = parametro.getEspeciePrincipal();
        fechaMedicion = parametro.getFechaMedicion();
        fechaProyeccion = parametro.getFechaProyeccion();
        modAltura = parametro.getModeloAltura();
        BO = parametro.getBO();
        ajuste = parametro.getAjuste();
        detalles = new LinkedList();
    }

    public int getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(int ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getFechaMedicion() {
        return fechaMedicion;
    }

    public void setFechaMedicion(String fechaMedicion) {
        this.fechaMedicion = fechaMedicion;
    }

    public Date getFechaProyeccion() {
        return fechaProyeccion;
    }

    public void setFechaProyeccion(Date fechaProyeccion) {
        this.fechaProyeccion = fechaProyeccion;
    }

    public String getModAltura() {
        return modAltura;
    }

    public void setModAltura(String modAltura) {
        this.modAltura = modAltura;
    }

    public double[] getBO() {
        return BO;
    }

    public void setBO(double[] BO) {
        this.BO = BO;
    }

    public String getAjuste() {
        return ajuste;
    }

    public void setAjuste(String ajuste) {
        this.ajuste = ajuste;
    }

    public LinkedList<DetalleTablaRodal> getDetalles() {
        return detalles;
    }

    public void setDetalles(LinkedList<DetalleTablaRodal> detalles) {
        this.detalles = detalles;
    }

    public ParametroGeneral getParametro() {
        return parametro;
    }

    public void setParametro(ParametroGeneral parametro) {
        this.parametro = parametro;
    }
    
    @Override
    public String toString(){
        return ordenTrabajo+" - "+ tipoInventario+" - "+ fundo +" - "+rodal;
    }
    
    
}
