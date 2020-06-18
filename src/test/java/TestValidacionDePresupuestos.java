import Dominio.OperacionEgreso.Item;
import Dominio.OperacionEgreso.OperacionDeEgreso;
import Dominio.OperacionEgreso.OperacionEgresoBuilder;
import Dominio.OperacionEgreso.TipoDocumentoComercial;
import Dominio.Presupuesto.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TestValidacionDePresupuestos extends TestSetUpGeneral {
    private Presupuesto presupuesto1;
    private Presupuesto presupuesto2;
    private Presupuesto presupuesto3;
    private OperacionEgresoBuilder builder = new OperacionEgresoBuilder();
    private OperacionDeEgreso operacion1;
    private ValidacionMenorPrecio validacionMenorPrecio = new ValidacionMenorPrecio();
    private ValidacionCoincidenciaPresupuesto validacionCoincidenciaPresupuesto =
            new ValidacionCoincidenciaPresupuesto();
    private ValidacionCantidadPresupuestos validacionCantidadPresupuestos = new ValidacionCantidadPresupuestos();
    private ValidadorDePresupuestos validadorDePresupuestos = new ValidadorDePresupuestos();

    @Before
    public void setUpPresupuesto() {
        operacion1 = builder.agregarItem(producto1, 2)
                .agregarItem(producto2, 5)
                .setEntidad(entidadBase)
                .setMetodoPago(this.enEectivo())
                .setProveedor(proveedor)
                .setUsuarioAlta(usuario1)
                .setCantidadDePresupuestosRequeridos(2)
                .grabarOperacion();
        presupuesto1 = new Presupuesto(operacion1, Arrays.asList(new Item(producto1, 2), new Item(producto2, 5)),
                Arrays.asList(TipoDocumentoComercial.Factura));
        presupuesto2 = new Presupuesto(operacion1, Arrays.asList(new Item(producto1, 43)),
                Arrays.asList(TipoDocumentoComercial.Ticket));
        presupuesto3 = new Presupuesto(operacion1, Arrays.asList(new Item(producto2, 34), new Item(producto1, 1)),
                Arrays.asList(TipoDocumentoComercial.Factura));
        validadorDePresupuestos = new ValidadorDePresupuestos();

    }


    @Test
    public void operacionConMenosPresupuestosDeLosRequeridos() {
        operacion1.agregarPresupuesto(presupuesto1);
        assertEquals(validacionCantidadPresupuestos.validar(operacion1), false);
    }

    @Test
    public void operacionConCantidadDePresupuestosRequeridos() {
        operacion1.agregarPresupuesto(presupuesto1);
        operacion1.agregarPresupuesto(presupuesto2);
        operacion1.agregarPresupuesto(presupuesto3);
        assertEquals(validacionCantidadPresupuestos.validar(operacion1), true);
    }

    @Test
    public void operacionCoincideConAlgunPresupuesto() {
        operacion1.agregarPresupuesto(presupuesto1);
        assertEquals(validacionCoincidenciaPresupuesto.validar(operacion1), true);
    }


    @Test
    public void operacionNoCoindiceConPresupuestos() {
        operacion1.agregarPresupuesto(presupuesto2);
        operacion1.agregarPresupuesto(presupuesto3);
        assertEquals(validacionCoincidenciaPresupuesto.validar(operacion1), false);
    }

    @Test
    public void operacionEstaBasadaEnElMenorPresupuesto() {
        operacion1.agregarPresupuesto(presupuesto1);
        operacion1.agregarPresupuesto(presupuesto2);
        assertEquals(validacionMenorPrecio.validar(operacion1), true);
    }

    @Test
    public void operacionNoEstaBasadaEnElMenorPresupuesto() {
        operacion1.agregarPresupuesto(presupuesto2);
        assertEquals(validacionMenorPrecio.validar(operacion1), false);
    }

    @Test
    public void operacionAceptadaPorValidador() {
        validadorDePresupuestos.agregarValidacion(validacionCoincidenciaPresupuesto);
        validadorDePresupuestos.agregarValidacion(validacionCantidadPresupuestos);
        validadorDePresupuestos.agregarValidacion(validacionMenorPrecio);

        operacion1.agregarPresupuesto(presupuesto1);
        operacion1.agregarPresupuesto(presupuesto2);
        operacion1.agregarPresupuesto(presupuesto3);

        assertEquals(validadorDePresupuestos.validar(operacion1), true);

    }

    @Test
    public void operacionRechazadaPorValidadorFallaMenorPrecio() {
        validadorDePresupuestos.agregarValidacion(validacionCoincidenciaPresupuesto);
        validadorDePresupuestos.agregarValidacion(validacionCantidadPresupuestos);
        validadorDePresupuestos.agregarValidacion(validacionMenorPrecio);

        operacion1.agregarPresupuesto(presupuesto2);
        operacion1.agregarPresupuesto(presupuesto3);

        assertEquals(validadorDePresupuestos.validar(operacion1), false);
    }


    @Test
    public void operacionRechazadaPorValidadorFallaCantidadMinima() {
        validadorDePresupuestos.agregarValidacion(validacionCoincidenciaPresupuesto);
        validadorDePresupuestos.agregarValidacion(validacionCantidadPresupuestos);
        validadorDePresupuestos.agregarValidacion(validacionMenorPrecio);

        operacion1.agregarPresupuesto(presupuesto1);

        assertEquals(validadorDePresupuestos.validar(operacion1), false);
    }
}
