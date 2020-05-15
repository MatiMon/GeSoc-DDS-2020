import java.math.BigDecimal;

public class Efectivo implements MediosDePago{
    String codigoPago;

    Efectivo(String codPago){
        codigoPago = codPago;
    }


    public boolean puedePagarse(BigDecimal cantidad, java.util.Date fecha){
        return true;
    }

    String getCodigoPago(){
        return codigoPago;
    }

}
