package Dominio.Presupuesto;

import Dominio.OperacionEgreso.Item;
import Dominio.OperacionEgreso.OperacionDeEgreso;
import Dominio.OperacionEgreso.TipoDocumentoComercial;

import java.util.List;

public class Presupuesto {

    private OperacionDeEgreso operacionAsociada;
    private List<Item> items;
    private List<TipoDocumentoComercial> documentoComerciales;
    private Double valorTotal;

    Presupuesto(OperacionDeEgreso unEgreso,
                List<Item> unosItems,
                List<TipoDocumentoComercial> unosDocs) {
        operacionAsociada = unEgreso;
        items = unosItems;
        documentoComerciales = unosDocs;
        valorTotal = this.calcularValorTotal();
    }

    boolean validarOpEgresoAsociada(OperacionDeEgreso egreso){
        return operacionAsociada == egreso;
    }

    boolean validarItemsDelEgreso(OperacionDeEgreso egreso){
        return items == egreso.getItems();
    }

    boolean validarTotalDelEgreso(OperacionDeEgreso egreso){
        return valorTotal == egreso.getValorTotal();
    }

    public boolean cumpleLasCondiciones(OperacionDeEgreso egreso){
        return this.validarItemsDelEgreso(egreso) &&
                this.validarOpEgresoAsociada(egreso) &&
                this.validarTotalDelEgreso(egreso);
    }

    Double calcularValorTotal() {
        return items.stream().mapToDouble(item -> item.valorItem()).sum();
    }

    public OperacionDeEgreso getOperacionAsociada() {
        return operacionAsociada;
    }

    public List<Item> getItems() {
        return items;
    }

    public Double getValorTotal() {
        return valorTotal;
    }


}
