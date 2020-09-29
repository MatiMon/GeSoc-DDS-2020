package Dominio.OperacionEgreso;

import Persistencia.Persistente;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item extends Persistente {
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "operacion_de_egreso_id", referencedColumnName = "id")
    OperacionDeEgreso operacionDeEgreso;

    public Item(Producto producto, int cantidad) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public Double valorItem() {
        return producto.getPrecioUnitario() * cantidad;
    }


    public String descripcionItem() {
        return String.valueOf(cantidad) + "x" + producto.getNombreProducto() +
                " $" + String.valueOf(producto.getPrecioUnitario()) + "c/u";
    }

    public Producto getProducto() {
        return this.producto;
    }

    public int getCantidad() {
        return this.cantidad;
    }

}
