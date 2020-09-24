package Dominio.MediosDePago;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("T")
public class Tarjeta extends MediosDePago {

	@Transient
	private TipoTarjeta tipo;
    private String numTarjeta;
    private String nombreCompleto;
    private LocalDateTime fechaVencimiento;


    public Tarjeta(TipoTarjeta unTipo, String numTarj, String nombre, LocalDateTime vencimineto) {
        tipo = unTipo;
        numTarjeta = this.verificarNumerosIngrasados(numTarj, 16, "Numero Dominio.Direccion.Direccion.MediosDePago.Tarjeta");
        nombreCompleto = nombre;
        fechaVencimiento = vencimineto;
    }

    public String verificarNumerosIngrasados(String numeros, int largo, String nombreCampo) {
        this.verificarLargoDeLosNumeros(numeros, largo, nombreCampo);
        this.verificarQueSeanNumeros(numeros, largo);
        return numeros;
    }

    public void verificarQueSeanNumeros(String numeros, int largo) {
        if (!(numeros.matches("[0-9]+"))) {
            if (largo == 16) {
                throw new HayCaracteresNoNumericosEnLosNumerosDeLaTarjetaExeption(
                        "Se ingresaron caracteres no numericos en el numero de la tarjeta"
                );
            }
        }
    }

    public void verificarLargoDeLosNumeros(String numeros, int largo, String nombreCampo) {
        if (numeros.length() != largo) {
            throw new CantidadIncorrectaDeCaractereresExeption(
                    "Se ingreso un numero incorrecto de caracteres en el campo " + nombreCampo
            );
        }
    }


    public String getNombreCompleto() {
        return nombreCompleto;
    }
    
    public Tarjeta() {
    	
    }

}