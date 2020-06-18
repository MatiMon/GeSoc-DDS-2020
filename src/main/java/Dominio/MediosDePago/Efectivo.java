package Dominio.MediosDePago;

public class Efectivo implements MediosDePago {
    String codigoPago;

    public Efectivo(String codPago){
        codigoPago = codPago;
    }


    String getCodigoPago(){
        return codigoPago;
    }

}
