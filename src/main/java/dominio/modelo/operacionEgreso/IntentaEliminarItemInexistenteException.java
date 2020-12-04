package dominio.modelo.operacionEgreso;

public class IntentaEliminarItemInexistenteException extends RuntimeException{
    public IntentaEliminarItemInexistenteException(int key) {
        super("No existe la posicion nro " + key);
    }
}

