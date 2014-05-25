package Utilidades.Inventario;

import java.sql.Date;

/**
 *
 * @author Führer
 */
public class Funcion {
    private int idFuncion;
    private String funcion;
    private Date fechaCreacion;
    private Date fechaModificacion;
    public Funcion(int id, String funcion, Date fechaCreacion, Date fechaModificacion) {
        this.idFuncion = id;
        this.funcion = funcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int codigo) {
        this.idFuncion = codigo;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
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
