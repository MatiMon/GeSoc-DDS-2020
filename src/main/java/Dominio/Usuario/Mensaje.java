package Dominio.Usuario;

import Dominio.OperacionEgreso.Item;
import Dominio.OperacionEgreso.OperacionDeEgreso;
import Dominio.Presupuesto.Presupuesto;

import java.time.LocalDateTime;
import java.util.List;

public class Mensaje {
    private LocalDateTime fechaYHora;
    private boolean resultadoValidacion;
    private List<Item> items;
    private Double precioTotal;
    private List<Presupuesto> presupuestos;

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora() {
        this.fechaYHora = LocalDateTime.now();
    }

    public boolean getResultadoValodacion() {
        return resultadoValidacion;
    }

    public void setResultadoValidacion(boolean resultadoValidacion) {
        this.resultadoValidacion = resultadoValidacion;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public List<Presupuesto> getPresupuestos() {
        return presupuestos;
    }

    public void setPresupuestos(List<Presupuesto> presupuestos) {
        this.presupuestos = presupuestos;
    }


    public Mensaje crearMensajeValidacion(OperacionDeEgreso operacion, boolean validacion) {
        this.fechaYHora = LocalDateTime.now();
        this.resultadoValidacion = validacion;
        this.items = operacion.getItems();
        this.precioTotal = operacion.getValorTotal();
        this.presupuestos = operacion.getPresupuestos();

        return this;
    }

}