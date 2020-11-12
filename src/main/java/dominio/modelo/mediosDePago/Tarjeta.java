package dominio.modelo.mediosDePago;

import javax.persistence.*;
import java.util.Date;

@Entity
@DiscriminatorValue("T")
public class Tarjeta extends MediosDePago {

    @Column(name = "tipo_tarjeta")
    @Enumerated(EnumType.ORDINAL)
    private TipoTarjeta tipo;

    @Column(name = "numero_tarjeta")
    private String numTarjeta;

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @Column(name = "fecha_vencimiento")
    private Date fechaVencimiento;

    public Tarjeta(TipoTarjeta unTipo, String numTarj, String nombre, Date vencimineto) {
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