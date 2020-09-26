package Dominio.MediosDePago;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("E")
public class Efectivo extends MediosDePago {

    @Column(name = "codigo_pago")
    private String codigoPago;

    public Efectivo(String codPago){
        codigoPago = codPago;
    }

    public String getCodigoPago(){
        return codigoPago;
    }
    
	public Efectivo() {
    	
    }

}

