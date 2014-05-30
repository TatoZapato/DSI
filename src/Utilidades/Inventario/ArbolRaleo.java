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
public class ArbolRaleo {
    private int ordenTrabajo;
    private int numParcela;
    private int numero;
    private int especie;
    private int estrato;
    private int fito;
    private int dominancia;
    private int conPoda;
    private float dap;
    private float hPoda;
    private float hTotal;
    private int rectitud;
    private int copa;
    private int bifulcacion;
    private int sanidad;

    public ArbolRaleo(int ordenTrabajo, int numParcela, int numero, int especie, int estrato, int fito, int dominancia, int conPoda, float dap, float hPoda, float hTotal, int rectitud, int copa, int bifulcacion, int sanidad) {
        this.ordenTrabajo = ordenTrabajo;
        this.numParcela = numParcela;
        this.numero = numero;
        this.especie = especie;
        this.estrato = estrato;
        this.fito = fito;
        this.dominancia = dominancia;
        this.conPoda = conPoda;
        this.dap = dap;
        this.hPoda = hPoda;
        this.hTotal = hTotal;
        this.rectitud = rectitud;
        this.copa = copa;
        this.bifulcacion = bifulcacion;
        this.sanidad = sanidad;
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

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getEspecie() {
        return especie;
    }

    public void setEspecie(int especie) {
        this.especie = especie;
    }

    public int getEstrato() {
        return estrato;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }

    public int getFito() {
        return fito;
    }

    public void setFito(int fito) {
        this.fito = fito;
    }

    public int getDominancia() {
        return dominancia;
    }

    public void setDominancia(int dominancia) {
        this.dominancia = dominancia;
    }

    public int getConPoda() {
        return conPoda;
    }

    public void setConPoda(int conPoda) {
        this.conPoda = conPoda;
    }

    public float getDap() {
        return dap;
    }

    public void setDap(float dap) {
        this.dap = dap;
    }

    public float gethPoda() {
        return hPoda;
    }

    public void sethPoda(float hPoda) {
        this.hPoda = hPoda;
    }

    public float gethTotal() {
        return hTotal;
    }

    public void sethTotal(float hTotal) {
        this.hTotal = hTotal;
    }

    public int getRectitud() {
        return rectitud;
    }

    public void setRectitud(int rectitud) {
        this.rectitud = rectitud;
    }

    public int getCopa() {
        return copa;
    }

    public void setCopa(int copa) {
        this.copa = copa;
    }

    public int getBifulcacion() {
        return bifulcacion;
    }

    public void setBifulcacion(int bifulcacion) {
        this.bifulcacion = bifulcacion;
    }

    public int getSanidad() {
        return sanidad;
    }

    public void setSanidad(int sanidad) {
        this.sanidad = sanidad;
    }
    
    
    
    
}
