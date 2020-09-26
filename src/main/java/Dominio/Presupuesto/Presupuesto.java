package Dominio.Presupuesto;

import Dominio.OperacionEgreso.Item;
import Dominio.OperacionEgreso.OperacionDeEgreso;
import Dominio.OperacionEgreso.TipoDocumentoComercial;
import Persistencia.Persistente;

import javax.persistence.*;
import java.util.List;

@Entity
public class Presupuesto extends Persistente {

    @ManyToOne
    private OperacionDeEgreso operacionAsociada;

    @OneToMany
    @Column(name = "id_presupuesto")
    private List<Item> items;

    @ElementCollection
    private List<TipoDocumentoComercial> documentoComerciales;

    @Column(name = "valor_total")
    private Double valorTotal;

    public Presupuesto(OperacionDeEgreso unEgreso,
                List<Item> unosItems,
                List<TipoDocumentoComercial> unosDocs) {
        operacionAsociada = unEgreso;
        items = unosItems;
        documentoComerciales = unosDocs;
        valorTotal = this.calcularValorTotal();
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
