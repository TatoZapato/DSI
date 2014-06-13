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
public class ParametroGeneral {
    private String emPropietaria;
    private int fundo;
    private int rodal;
    private String anoPlantacion;
    private String especiePrincipal;
    private String especieSecundaria;
    private int numEspecies;
    private int ordenTrabajo;
    private Date fechaMedicion;
    private String tipoInventario;
    private int numParcelas;
    private float superficieParcelas;
    private String empresaServicios;
    private Date fechaProyeccion;
    private float densidad;
    private float densidadP;
    private float densidadNP;
    private float dapMedio;
    private float dapMedioP;
    private float dapMedioNP;
    private float areaBasal;
    private float areaBasalP;
    private float areaBasalNP;
    private float alturaTotalMedia;
    private float alturaTotalMediaP;
    private float alturaTotalMediaNP;
    private float volumen;
    private float volumenP;
    private float volumenNP;
    private String modeloAltura;
    private float[] BO;
    private String ajuste;
    private float superficieRodal;
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

    public float getSuperficieParcelas() {
        return superficieParcelas;
    }

    public void setSuperficieParcelas(float superficieParcelas) {
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

    public float getDensidad() {
        return densidad;
    }

    public void setDensidad(float densidad) {
        this.densidad = densidad;
    }

    public float getDensidadP() {
        return densidadP;
    }

    public void setDensidadP(float densidadP) {
        this.densidadP = densidadP;
    }

    public float getDensidadNP() {
        return densidadNP;
    }

    public void setDensidadNP(float densidadNP) {
        this.densidadNP = densidadNP;
    }

    public float getDapMedio() {
        return dapMedio;
    }

    public void setDapMedio(float dapMedio) {
        this.dapMedio = dapMedio;
    }

    public float getDapMedioP() {
        return dapMedioP;
    }

    public void setDapMedioP(float dapMedioP) {
        this.dapMedioP = dapMedioP;
    }

    public float getDapMedioNP() {
        return dapMedioNP;
    }

    public void setDapMedioNP(float dapMedioNP) {
        this.dapMedioNP = dapMedioNP;
    }

    public float getAreaBasal() {
        return areaBasal;
    }

    public void setAreaBasal(float areaBasal) {
        this.areaBasal = areaBasal;
    }

    public float getAreaBasalP() {
        return areaBasalP;
    }

    public void setAreaBasalP(float areaBasalP) {
        this.areaBasalP = areaBasalP;
    }

    public float getAreaBasalNP() {
        return areaBasalNP;
    }

    public void setAreaBasalNP(float areaBasalNP) {
        this.areaBasalNP = areaBasalNP;
    }

    public float getAlturaTotalMedia() {
        return alturaTotalMedia;
    }

    public void setAlturaTotalMedia(float alturaTotalMedia) {
        this.alturaTotalMedia = alturaTotalMedia;
    }

    public float getAlturaTotalMediaP() {
        return alturaTotalMediaP;
    }

    public void setAlturaTotalMediaP(float alturaTotalMediaP) {
        this.alturaTotalMediaP = alturaTotalMediaP;
    }

    public float getAlturaTotalMediaNP() {
        return alturaTotalMediaNP;
    }

    public void setAlturaTotalMediaNP(float alturaTotalMediaNP) {
        this.alturaTotalMediaNP = alturaTotalMediaNP;
    }

    public float getVolumen() {
        return volumen;
    }

    public void setVolumen(float volumen) {
        this.volumen = volumen;
    }

    public float getVolumenP() {
        return volumenP;
    }

    public void setVolumenP(float volumenP) {
        this.volumenP = volumenP;
    }

    public float getVolumenNP() {
        return volumenNP;
    }

    public void setVolumenNP(float volumenNP) {
        this.volumenNP = volumenNP;
    }

    public String getModeloAltura() {
        return modeloAltura;
    }

    public void setModeloAltura(String modeloAltura) {
        this.modeloAltura = modeloAltura;
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

    public float getSuperficieRodal() {
        return superficieRodal;
    }

    public void setSuperficieRodal(float superficieRodal) {
        this.superficieRodal = superficieRodal;
    }

    public LinkedList<ArbolRaleo> getMisArboles() {
        return misArboles;
    }

    public void setMisArboles(LinkedList<ArbolRaleo> misArboles) {
        this.misArboles = misArboles;
    }

    
}
