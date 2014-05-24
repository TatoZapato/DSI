package Utilidades.Inventario;

/**
 *
 * @author Führer
 */
public class Funcion {
    private int codigo;
    private String funcion;
    private String fechaCreacion;
    private String fechaModificacion;
    public Funcion(int codigo, String funcion, String fechaCreacion, String fechaModificacion) {
        this.codigo = codigo;
        this.funcion = funcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
