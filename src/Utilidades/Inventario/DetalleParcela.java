/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades.Inventario;

/**
 *
 * @author Führer
 */
public class DetalleParcela {

    private int ordenTrabajo;
    private int numParcela;
    private double superficie;
    private double densidad;
    private double areaBasalMedia;
    private double dapMedio;
    private double alturaDominante;
    private double volumen;
    private double factorExpansion;

    public DetalleParcela() {
    }

    public int getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(int ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }

    public int getNumParcela() {
        return numParcela;
    }

    public void setNumParcela(int numParcela) {
        this.numParcela = numParcela;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public double getDensidad() {
        return densidad;
    }

    public void setDensidad(double densidad) {
        this.densidad = densidad;
    }

    public double getAreaBasalMedia() {
        return areaBasalMedia;
    }

    public void setAreaBasalMedia(double areaBasalMedia) {
        this.areaBasalMedia = areaBasalMedia;
    }

    public double getDapMedio() {
        return dapMedio;
    }

    public void setDapMedio(double dapMedio) {
        this.dapMedio = dapMedio;
    }

    public double getAlturaDominante() {
        return alturaDominante;
    }

    public void setAlturaDominante(float alturaDominante) {
        this.alturaDominante = alturaDominante;
    }

    public double getVolumen() {
        return volumen;
    }

    public void setVolumen(double volumen) {
        this.volumen = volumen;
    }

    public void setFactorExpansion(double factorExpansion) {
        this.factorExpansion = factorExpansion;
    }
    public double getFactorExpansion(){
        return this.factorExpansion;
    }

}
