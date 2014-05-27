/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utilidades.Inventario;

import java.sql.Date;

/**
 *
 * @author Führer
 */
public class Inventario {
    private int ordenTrabajo;
    private int rutEmpleado;
    private Date fecha;
    private int rutJefeCuadrilla;
    private String estado;
    private int parcela;
    private String rodal;
    private String fundo;
    private int tipoInventario;

    public Inventario(int ordenTrabajo, int rut, Date fecha, int rutJefeCuadrilla, String estado, int parcela, String rodal, String fundo, int tipoInventario) {
        this.ordenTrabajo = ordenTrabajo;
        this.rutEmpleado = rut;
        this.fecha = fecha;
        this.rutJefeCuadrilla = rutJefeCuadrilla;
        this.estado = estado;
        this.parcela = parcela;
        this.rodal = rodal;
        this.fundo = fundo;
        this.tipoInventario = tipoInventario;
    }

    public int getOrdenTrabajo() {
        return ordenTrabajo;
    }

    public void setOrdenTrabajo(int ordenTrabajo) {
        this.ordenTrabajo = ordenTrabajo;
    }

    public int getRutEmpleado() {
        return rutEmpleado;
    }

    public void setRutEmpleado(int rut) {
        this.rutEmpleado = rut;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getRutJefeCuadrilla() {
        return rutJefeCuadrilla;
    }

    public void setRutJefeCuadrilla(int rutJefeCuadrilla) {
        this.rutJefeCuadrilla = rutJefeCuadrilla;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getParcela() {
        return parcela;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }

    public String getRodal() {
        return rodal;
    }

    public void setRodal(String rodal) {
        this.rodal = rodal;
    }

    public String getFundo() {
        return fundo;
    }

    public void setFundo(String fundo) {
        this.fundo = fundo;
    }

    public int getTipoInventario() {
        return tipoInventario;
    }

    public void setTipoInventario(int tipoInventario) {
        this.tipoInventario = tipoInventario;
    }
    
    
}
