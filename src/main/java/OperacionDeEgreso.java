import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

public class OperacionDeEgreso {
	Pair<TipoDocumentoComercial,Integer> DocumentoContable;
	Proveedor proveedor;
	Date f_Operacion;
	List<Item> items;
	MedioPago pago;
	Entidad entidad;
	
	public Integer valorTotal() {
		int sum=0;
		for(int i = 0; i < items.size(); i++)
		    sum += items.get(i).valorItem();
		return sum;
	}

}
