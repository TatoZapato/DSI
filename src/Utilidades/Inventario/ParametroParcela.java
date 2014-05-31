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
    private Date fechaMedicion;
    private int tipoInventario;
    private int fundo;
    private int rodal;
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

    public int getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(int ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }

    public Date getFechaMedicion() {
        return fechaMedicion;
    }

    public void setFechaMedicion(Date fechaMedicion) {
        this.fechaMedicion = fechaMedicion;
    }

    public int getTipoInventario() {
        return tipoInventario;
    }

    public void setTipoInventario(int tipoInventario) {
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

}
