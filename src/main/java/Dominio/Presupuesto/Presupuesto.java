package Dominio.Presupuesto;

import Dominio.OperacionEgreso.Item;
import Dominio.OperacionEgreso.OperacionDeEgreso;
import Dominio.OperacionEgreso.TipoDocumentoComercial;

import java.math.BigDecimal;
import java.util.List;

public class Presupuesto {


    private OperacionDeEgreso operacionDeEgresoAsociada;
    private List<Item> listaDeItems;
    private List<TipoDocumentoComercial> tiposDeDocumentoPosibles;
    private BigDecimal valorTotal;



    public Presupuesto(OperacionDeEgreso opreacionDeEgresoAsociada, List<Item> listaDeItems, List<TipoDocumentoComercial> tiposDeDocumentoPosibles, BigDecimal valorTotal) {
        this.operacionDeEgresoAsociada = opreacionDeEgresoAsociada;
        this.listaDeItems = listaDeItems;
        this.tiposDeDocumentoPosibles = tiposDeDocumentoPosibles;
        this.valorTotal = valorTotal;
    }

    public OperacionDeEgreso getOpreacionDeEgresoAsociada() {
        return operacionDeEgresoAsociada;
    }

    public List<Item> getListaDeItems() {
        return listaDeItems;
    }

    public List<TipoDocumentoComercial> getTiposDeDocumentoPosibles() {
        return tiposDeDocumentoPosibles;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }


    public void setOpreacionDeEgresoAsociada(OperacionDeEgreso opreacionDeEgresoAsociada) {
        this.operacionDeEgresoAsociada = opreacionDeEgresoAsociada;
    }

    public void setTiposDeDocumentoPosibles(List<TipoDocumentoComercial> tiposDeDocumentoPosibles) {
        this.tiposDeDocumentoPosibles = tiposDeDocumentoPosibles;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }


}
