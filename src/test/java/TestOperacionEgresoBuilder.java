import Dominio.OperacionEgreso.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class TestOperacionEgresoBuilder extends TestSetUpGeneral {
    private OperacionEgresoBuilder operador;

    @Before
    public void setup(){
        this.operador = new OperacionEgresoBuilder();
    }

    @Test(expected = sinItemsException.class)
    public void intentaGenerarOperacionSinItems() {
        operador.setDocumentoContable(TipoDocumentoComercial.Factura, 12345)
                .setEntidad(entidadBase)
                .setMetodoPago(this.enEectivo())
                .setProveedor(proveedor)
                .grabarOperacion();
    }

    @Test(expected = NullPointerException.class)
    public void intentaGenerarOperacionSinProveedor() {
        operador.setDocumentoContable(TipoDocumentoComercial.Factura, 12345)
                .agregarItem(producto1, 2)
                .agregarItem(producto2, 5)
                .setEntidad(entidadBase)
                .setMetodoPago(this.enEectivo())
                .grabarOperacion();
    }

    @Test(expected = NullPointerException.class)
    public void intentaGenerarOperacionSinMedioPago() {
        operador.setDocumentoContable(TipoDocumentoComercial.Factura, 12345)
                .agregarItem(producto1, 2)
                .agregarItem(producto2, 5)
                .setEntidad(entidadBase)
                .setProveedor(proveedor)
                .grabarOperacion();
    }

    @Test(expected = NullPointerException.class)
    public void intentaGenerarOperacionSinEntidad() {
        operador.setDocumentoContable(TipoDocumentoComercial.Factura, 12345)
                .agregarItem(producto1, 2)
                .agregarItem(producto2, 5)
                .setMetodoPago(this.enEectivo())
                .setProveedor(proveedor)
                .grabarOperacion();
    }

    @Test
    public void GeneraOperacionConExito() {
        OperacionDeEgreso operacion = operador.setDocumentoContable(TipoDocumentoComercial.Factura, 12345)
                .agregarItem(producto1, 2)
                .agregarItem(producto2, 5)
                .setEntidad(entidadBase)
                .setMetodoPago(this.enEectivo())
                .setProveedor(proveedor)
                .grabarOperacion();

        Assert.assertEquals(operacion.getItems().size(), 2);
        Assert.assertEquals(operacion.getEntidad(), entidadBase);
        //Assert.assertSame(operacion.getPago(), this.enEectivo());
        Assert.assertEquals(operacion.getProveedor(), proveedor);
        Assert.assertEquals(operacion.getTipoDocumentoComercial(), TipoDocumentoComercial.Factura);
        Assert.assertEquals(operacion.getNroDocumentoComercial(), new Integer(12345));
        Assert.assertEquals(operacion.valorTotal(), producto1.getPrecioUnitario().multiply(BigDecimal.valueOf(2))
                .add(producto2.getPrecioUnitario().multiply(BigDecimal.valueOf(5))));
    }

    @Test
    public void GeneraOperacionConExitoSinDocComercial() {
        OperacionDeEgreso operacion = operador.agregarItem(producto1, 2)
                .agregarItem(producto2, 5)
                .setEntidad(entidadBase)
                .setProveedor(proveedor)
                .setMetodoPago(this.enEectivo())
                .grabarOperacion();

        Assert.assertEquals(operacion.getItems().size(), 2);
        Assert.assertEquals(operacion.getEntidad(), entidadBase);
        //Assert.assertEquals(operacion.getPago(), this.enEectivo());
        Assert.assertEquals(operacion.getProveedor(), proveedor);
        Assert.assertNull(operacion.getDocumentoComercial());
    }

    @Test
    public void EliminaItemConExito() {
        operador.agregarItem(producto1, 2)
                .agregarItem(producto2, 5)
                .eliminarItem(0);
        Assert.assertEquals(operador.getItems().size(), 1);
    }

    @Test(expected = IntentaEliminarItemInexistenteException.class)
    public void ErrorAlEliminarItemNoExistente() {
        operador.eliminarItem(0);
    }

}
