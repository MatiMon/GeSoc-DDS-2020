import java.util.List;

public class EntidadJuridica implements Entidad {
    List<EntidadBase> entidadBaseList;
    String nombre;
    int cuit;
    String direccionPostal; //se repite con proveedor -> sacarlo a una clase?
    int codigoIGJ;
    CategoriaEntidadJuridica categoriaEntidadJuridica;
}
