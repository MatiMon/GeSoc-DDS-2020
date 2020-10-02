package Dominio.OperacionEgreso.Etiquetado;

import Dominio.Moneda.Moneda;
import Dominio.OperacionEgreso.OperacionDeEgreso;
import Persistencia.Persistente;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "etiqueta_egreso")
public class EtiquetaEgreso extends Persistente {

    @OneToOne
    @JoinColumn(name = "tipo_etiqueta_id", referencedColumnName = "id")
    private TipoEtiqueta tipo;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "operacion_de_egreso_etiqueta",
            joinColumns = {@JoinColumn(name = "etiqueta_id")},
            inverseJoinColumns = {@JoinColumn(name = "operacion_id")}
    )
    private List<OperacionDeEgreso> operaciones = new ArrayList<>();

    @org.hibernate.annotations.Type(
            type = "org.hibernate.type.SerializableToBlobType",
            parameters = {@Parameter(name = "classname", value = "java.util.HashMap")}
    )
    private HashMap<Moneda, Double> gasto = new HashMap<Moneda, Double>();

    public EtiquetaEgreso(TipoEtiqueta tipo) {
        this.tipo = tipo;
    }

    public List<OperacionDeEgreso> getOperaciones() {
        return operaciones;
    }

    public String descripcionTipo() {
        return tipo.getDescripcion();
    }


    public HashMap<Moneda, Double> getValorTotal() {
        return gasto;
    }

    public void showGastos() {
        gasto.forEach((moneda, valor) -> System.out.println(moneda.toString() + valor.toString()));
    }

    public void enlistarOperaciones() {
        operaciones.forEach(operacion -> System.out.println(operacion.getNumeroDocumentoComercial()
                + " " + operacion.getValorTotal()));
    }

    public void agregarOperacion(OperacionDeEgreso operacion) {
        operaciones.add(operacion);
        modificarGasto(operacion, 1);
    }

    public void quitarOperacion(OperacionDeEgreso operacion) {
        operaciones.remove(operacion);
        modificarGasto(operacion, -1);
    }

    private void modificarGasto(OperacionDeEgreso operacion, int sentido) {
        Double valor = operacion.getValorTotal() * sentido;
        if (gasto.containsKey(operacion.getMoneda())) {
            valor = valor + gasto.get(operacion.getMoneda());
        }
        if (valor > 0) {
            gasto.put(operacion.getMoneda(), valor);
        } else {
            gasto.remove(operacion.getMoneda());
        }
    }

    public boolean tieneOperacion(OperacionDeEgreso operacionDeEgreso) {
        return getOperaciones().contains(operacionDeEgreso);
    }
}
