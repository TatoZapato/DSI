package Utilidades.Inventario;

/**
 *
 * @author Führer
 */
public class Funcion {
    private int idFuncion;
    private String funcion;
    private String fechaCreacion;
    private String fechaModificacion;
    public Funcion(int id, String funcion, String fechaCreacion, String fechaModificacion) {
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

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }
}
