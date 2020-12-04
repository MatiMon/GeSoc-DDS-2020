package dominio.modelo.presupuesto;

import db.Persistente;
import dominio.modelo.operacionEgreso.Item;
import dominio.modelo.operacionEgreso.OperacionDeEgreso;
import dominio.modelo.operacionEgreso.TipoDocumentoComercial;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "presupuesto")
public class Presupuesto extends Persistente {

    @ManyToOne
    @JoinColumn(name = "operacion_de_egreso_id", referencedColumnName = "id")
    private OperacionDeEgreso operacionAsociada;

    @OneToMany(mappedBy = "presupuesto")
    private List<Item> items;

    @ElementCollection
    @CollectionTable(name = "presupuesto_tipo_documento", joinColumns = {@JoinColumn(name = "presupuesto_id")})
    @Column(name = "documento_comercial")
    @Enumerated(EnumType.STRING)
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
