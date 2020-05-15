package Dominio.OperacionEgreso;

public class IntentaEliminarItemInexistenteException extends RuntimeException{
    public IntentaEliminarItemInexistenteException(int key) {
        super("No existe la posicion nro " + key);
    }
}

