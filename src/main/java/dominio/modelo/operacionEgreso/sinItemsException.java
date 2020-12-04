package dominio.modelo.operacionEgreso;

public class sinItemsException extends RuntimeException {
    public sinItemsException(){
        super("Debe ingresar al menos un item");
    }
}
