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
    private int fundo;
    private int rodal;
    private String especie;
    private Date fechaMedicion;
    private Date fechaProyeccion;
    private String modAltura;
    private float[] BO;
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

    public int getFundo() {
        return fundo;
    }

    public void setFundo(int fundo) {
        this.fundo = fundo;
    }

    public int getRodal() {
        return rodal;
    }

    public void setRodal(int rodal) {
        this.rodal = rodal;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Date getFechaMedicion() {
        return fechaMedicion;
    }

    public void setFechaMedicion(Date fechaMedicion) {
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

    public float[] getBO() {
        return BO;
    }

    public void setBO(float[] BO) {
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
    
    
}
