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
    private int conPoda;
    private float dap;
    private float hPoda;
    private float hTotal;
    public ArbolRaleo(int ordenTrabajo, int numParcela, int numero, int especie, int conPoda, float dap, float hPoda, float hTotal) {
        this.ordenTrabajo = ordenTrabajo;
        this.numParcela = numParcela;
        this.numero = numero;
        this.especie = especie;
        this.conPoda = conPoda;
        this.dap = dap;
        this.hPoda = hPoda;
        this.hTotal = hTotal;
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
//
//    public int getDominancia() {
//        return dominancia;
//    }
//
//    public void setDominancia(int dominancia) {
//        this.dominancia = dominancia;
//    }

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
  
}
