/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utilidades.Inventario;

import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author Führer
 */
public class ParametroGeneral {
    private String emPropietaria;
    private int fundo;
    private int rodal;
    private String anoPlantacion;
    private String especiePrincipal;
    private String especieSecundaria;
    private int numEspecies;
    private int ordeTrabajo;
    private String fechaMedicion;
    private String tipoInventario;
    private int numParcelas;
    private String superficieParcelas;
    private String empresaServicios;
    private Date fechaProyeccion;
    private String densidad;
    private String densidadP;
    private String densidadNP;
    private String dapMedio;
    private String dapMedioP;
    private String dapMedioNP;
    private String areaBasal;
    private String areaBasalP;
    private String areaBasalNP;
    private String alturaTotalMedia;
    private String alturaTotalMediaP;
    private String alturaTotalMediaNP;
    private String volumen;
    private String volumenP;
    private String volumenNP;
    private String modeloAltura;
    private String[] BO;
    private String ajuste;
    private String superficieRodal;
    private LinkedList<ArbolRaleo> misArboles;

    public ParametroGeneral() {
        misArboles = new LinkedList<>();
    }

    public String getEmPropietaria() {
        return emPropietaria;
    }

    public void setEmPropietaria(String emPropietaria) {
        this.emPropietaria = emPropietaria;
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

    public String getAnoPlantacion() {
        return anoPlantacion;
    }

    public void setAnoPlantacion(String anoPlantacion) {
        this.anoPlantacion = anoPlantacion;
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

    public int getNumEspecies() {
        return numEspecies;
    }

    public void setNumEspecies(int numEspecies) {
        this.numEspecies = numEspecies;
    }

    public int getOrdeTrabajo() {
        return ordeTrabajo;
    }

    public void setOrdeTrabajo(int ordeTrabajo) {
        this.ordeTrabajo = ordeTrabajo;
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

    public int getNumParcelas() {
        return numParcelas;
    }

    public void setNumParcelas(int numParcelas) {
        this.numParcelas = numParcelas;
    }

    public String getSuperficieParcelas() {
        return superficieParcelas;
    }

    public void setSuperficieParcelas(String superficieParcelas) {
        this.superficieParcelas = superficieParcelas;
    }

    public String getEmpresaServicios() {
        return empresaServicios;
    }

    public void setEmpresaServicios(String empresaServicios) {
        this.empresaServicios = empresaServicios;
    }

    public Date getFechaProyeccion() {
        return fechaProyeccion;
    }

    public void setFechaProyeccion(Date fechaProyeccion) {
        this.fechaProyeccion = fechaProyeccion;
    }

    public String getDensidad() {
        return densidad;
    }

    public void setDensidad(String densidad) {
        this.densidad = densidad;
    }

    public String getDensidadP() {
        return densidadP;
    }

    public void setDensidadP(String densidadP) {
        this.densidadP = densidadP;
    }

    public String getDensidadNP() {
        return densidadNP;
    }

    public void setDensidadNP(String densidadNP) {
        this.densidadNP = densidadNP;
    }

    public String getDapMedio() {
        return dapMedio;
    }

    public void setDapMedio(String dapMedio) {
        this.dapMedio = dapMedio;
    }

    public String getDapMedioP() {
        return dapMedioP;
    }

    public void setDapMedioP(String dapMedioP) {
        this.dapMedioP = dapMedioP;
    }

    public String getDapMedioNP() {
        return dapMedioNP;
    }

    public void setDapMedioNP(String dapMedioNP) {
        this.dapMedioNP = dapMedioNP;
    }

    public String getAreaBasal() {
        return areaBasal;
    }

    public void setAreaBasal(String areaBasal) {
        this.areaBasal = areaBasal;
    }

    public String getAreaBasalP() {
        return areaBasalP;
    }

    public void setAreaBasalP(String areaBasalP) {
        this.areaBasalP = areaBasalP;
    }

    public String getAreaBasalNP() {
        return areaBasalNP;
    }

    public void setAreaBasalNP(String areaBasalNP) {
        this.areaBasalNP = areaBasalNP;
    }

    public String getAlturaTotalMedia() {
        return alturaTotalMedia;
    }

    public void setAlturaTotalMedia(String alturaTotalMedia) {
        this.alturaTotalMedia = alturaTotalMedia;
    }

    public String getAlturaTotalMediaP() {
        return alturaTotalMediaP;
    }

    public void setAlturaTotalMediaP(String alturaTotalMediaP) {
        this.alturaTotalMediaP = alturaTotalMediaP;
    }

    public String getAlturaTotalMediaNP() {
        return alturaTotalMediaNP;
    }

    public void setAlturaTotalMediaNP(String alturaTotalMediaNP) {
        this.alturaTotalMediaNP = alturaTotalMediaNP;
    }

    public String getVolumen() {
        return volumen;
    }

    public void setVolumen(String volumen) {
        this.volumen = volumen;
    }

    public String getVolumenP() {
        return volumenP;
    }

    public void setVolumenP(String volumenP) {
        this.volumenP = volumenP;
    }

    public String getVolumenNP() {
        return volumenNP;
    }

    public void setVolumenNP(String volumenNP) {
        this.volumenNP = volumenNP;
    }

    public String getModeloAltura() {
        return modeloAltura;
    }

    public void setModeloAltura(String modeloAltura) {
        this.modeloAltura = modeloAltura;
    }

    public String[] getBO() {
        return BO;
    }

    public void setBO(String[] BO) {
        this.BO = BO;
    }

    public String getAjuste() {
        return ajuste;
    }

    public void setAjuste(String ajuste) {
        this.ajuste = ajuste;
    }

    public String getSuperficieRodal() {
        return superficieRodal;
    }

    public void setSuperficieRodal(String superficieRodal) {
        this.superficieRodal = superficieRodal;
    }

    public LinkedList<ArbolRaleo> getMisArboles() {
        return misArboles;
    }

    public void setMisArboles(LinkedList<ArbolRaleo> misArboles) {
        this.misArboles = misArboles;
    }
    
    
    
    
}
