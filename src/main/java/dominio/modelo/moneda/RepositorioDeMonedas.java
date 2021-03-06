package dominio.modelo.moneda;

import java.util.List;

public class RepositorioDeMonedas {
    public List<Moneda> monedas;
    ServicioDeMonedas servicioProveedor;

    public void cambiarServicioProveedor (ServicioDeMonedas nuevoServicio) {
        this.servicioProveedor = nuevoServicio;
        this.monedas = nuevoServicio.getMonedas();
    }

    // Constructor:
    public RepositorioDeMonedas(ServicioDeMonedas servicio) {
        this.servicioProveedor = servicio;
        this.monedas = servicio.getMonedas();
    }
}
