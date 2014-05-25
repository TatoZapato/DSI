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
public class Modelo {
    private int idModelo;
    private String modelo;    
    private Date fechaCreacion;
    private Date fechaModificacion;

    public Modelo(int id, String expresion, Date fechaCreacion, Date fechaModificacion) {
        this.idModelo = id;
        this.modelo = expresion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int ide) {
        this.idModelo = ide;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
     public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
}
