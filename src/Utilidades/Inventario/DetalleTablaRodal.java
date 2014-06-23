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
public class DetalleTablaRodal {

    private int ordenTrabajo;
    private int claseDAP;
    private String densidadTotal;
    private String densidadPodado;
    private String densidadNoPodado;
    private String areaBasal;
    private String alturaMedia;
    private String alturaPoda;
    private String volumenPodado;
    private String volumeNoPodado;
    private String volumenTotal;

    public String getDensidadNoPodado() {
        return densidadNoPodado;
    }

    public DetalleTablaRodal() {}

    public int getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(int ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }

    public int getClaseDAP() {
        return claseDAP;
    }

    public void setClaseDAP(int claseDAP) {
        this.claseDAP = claseDAP;
    }

    public String getDensidadTotal() {
        return densidadTotal;
    }

    public void setDensidadTotal(String densidadTotal) {
        this.densidadTotal = densidadTotal;
    }

    public String getDensidadPodado() {
        return densidadPodado;
    }

    public void setDensidadPodado(String densidadPodado) {
        this.densidadPodado = densidadPodado;
    }

    public String getAreaBasal() {
        return areaBasal;
    }

    public void setAreaBasal(String areaBasal) {
        this.areaBasal = areaBasal;
    }

    public String getAlturaMedia() {
        return alturaMedia;
    }

    public void setAlturaMedia(String alturaMedia) {
        this.alturaMedia = alturaMedia;
    }

    public String getAlturaPoda() {
        return alturaPoda;
    }

    public void setAlturaPoda(String alturaPoda) {
        this.alturaPoda = alturaPoda;
    }

    public String getVolumenPodado() {
        return volumenPodado;
    }

    public void setVolumenPodado(String volumenPodado) {
        this.volumenPodado = volumenPodado;
    }

    public String getVolumeNoPodado() {
        return volumeNoPodado;
    }

    public void setVolumeNoPodado(String volumeNoPodado) {
        this.volumeNoPodado = volumeNoPodado;
    }

    public String getVolumenTotal() {
        return volumenTotal;
    }

    public void setVolumenTotal(String volumenTotal) {
        this.volumenTotal = volumenTotal;
    }

    public void setDensidadNoPodado(String np) {
        this.densidadNoPodado = np;
    }

    
}
