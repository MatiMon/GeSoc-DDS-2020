package Dominio.OperacionEgreso;

import java.util.ArrayList;
import java.util.Date;

import Dominio.Entidad.Entidad;
import Dominio.MediosDePago.MediosDePago;
import Dominio.Proveedor.Proveedor;
//import org.apache.commons.lang3.tuple.Pair;
import javafx.util.Pair;

public class OperacionDeEgreso {
	private Pair<TipoDocumentoComercial,Integer> documentoContable;
	private Proveedor proveedor;
	private Date f_Operacion;
	private ArrayList<Item> items;
	private MediosDePago pago;
	private Entidad entidad;

	public OperacionDeEgreso(Pair<TipoDocumentoComercial,Integer> documentoContable,
							 Proveedor proveedor,
							 Date f_Operacion,
							 ArrayList<Item> items,
							 MediosDePago pago,
							 Entidad entidad){
		this.documentoContable = documentoContable;
		this.proveedor = proveedor;
		this.items = items;
		this.f_Operacion = f_Operacion;
		this.pago = pago;
		this.entidad = entidad;
	}
	public Double valorTotal() {
		return items.stream()
				.mapToDouble(item-> item.cantidad * item.producto.precioUnitario)
				.sum();
	}

	public TipoDocumentoComercial getTipoDocumentoComercial(){
		return documentoContable.getKey();
	}
	public Integer getNroDocumentoComercial(){
		return documentoContable.getValue();
	}
	public Proveedor getProveedor(){return this.proveedor;}
	public Date getFechaOperacion(){ return this.f_Operacion;}
	public Entidad getEntidad(){ return this.entidad;}
	public ArrayList<Item> getItems(){ return this.items;}
	public MediosDePago getPago(){ return this.pago;}

	public Pair<TipoDocumentoComercial,Integer> getDocumentoComercial() {
		return this.documentoContable;
	}
}
