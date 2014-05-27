package Utilidades.Persistencia.DAOManager;

/**
 *
 * @author Führer
 */
public class DAOException extends Exception {

    private static final long serialVersionUID = 1L;
    public static final int PROBLEM_WITH_PRIMARY_KEY = 0;
    public static final int NOT_FOUND_ROW = 1;
    public static final int IMPOSIBLE_CREATE_STATEMENT = 2;
    public static final int IMPOSIBLE_ESTABLISH_CONNECTION = 3;
    public static final int IMPOSIBLE_CLOSE_CONNECTION = 4;
    public static final int IMPOSIBLE_FIND_DRIVER = 5;
    public static final int IMPOSIBLE_MAKE_QUERY = 6;
    public static final int IMPOSIBLE_DO_VECTOR = 7;
    public static final int IMPOSIBLE_CLOSE_STATEMENT = 8;
    public static final int IMPOSIBLE_CLOSE_RESULSET = 9;

    private static final String[] errors = {
        "Problemas con la Clave Primaria",
        "No se Encontro la Fila",
        "Imposible Crear el Estamento",
        "Imposible Establecer Coneccion",
        "Imposible Cerrar la Coneccion",
        "Imposible Encontrar el Driver",
        "Imposible Realizar la Consulta",
        "Imposible llenar vector de transferencia",
        "Imposible cerrar la consulta",
        "Imposible cerrar resulset"
    };

    private int error = -1;

    public DAOException(int error) {
        this.error = error;
    }

    public int getError() {
        return error;
    }

    @Override
    public String getMessage() {
        return errors[error];
    }

}
