package Utilidades.Inventario;

import java.sql.Date;
import java.util.UUID;

/**
 *
 * @author Führer
 */
public class Funcion {
    private String idFuncion;
    private String funcion;
    private Date fechaCreacion;
    private Date fechaModificacion;
    public Funcion(String id, String funcion, Date fechaCreacion, Date fechaModificacion) {
        this.idFuncion = id;
        this.funcion = funcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public String getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(String codigo) {
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
