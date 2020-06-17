package Dominio.Presupuesto;

import Dominio.OperacionEgreso.Item;
import Dominio.OperacionEgreso.OperacionDeEgreso;
import Dominio.OperacionEgreso.TipoDocumentoComercial;

import java.math.BigDecimal;
import java.util.List;

public class Presupuesto {

    OperacionDeEgreso operacionAsociada;
    List<Item> items;
    List<TipoDocumentoComercial> documentoComerciales;
    BigDecimal total;

    Presupuesto(OperacionDeEgreso unEgreso,
                List<Item> unosItems,
                List<TipoDocumentoComercial> unosDocs){
        operacionAsociada = unEgreso;
        items = unosItems;
        documentoComerciales = unosDocs;
        total = this.calcularValorTotal();
    }

    BigDecimal calcularValorTotal(){
        return BigDecimal.valueOf(SumarItems());
    }

    private double SumarItems(){
        return items.stream().mapToDouble(item -> item.valorItem().doubleValue()).sum();
    }

}
