import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class OperacionDeEgreso {
    Date fecha;
    Proveedor proveedor;
    DocumentoComercial documentoComercial;
    BigDecimal valorTotal;
    MedioDePago medioDePago;
    Entidad entidad;
    List<Item> itemList;
}
