package Dominio.MediosDePago;

import java.math.BigDecimal;

public class Tarjeta implements MediosDePago {

    TipoTarjeta tipo;
    String numTarjeta;
    String codigoSeguridad;
    String nombreCompleto;
    java.util.Date fechaVencimiento;
    BigDecimal limite;

    public Tarjeta(TipoTarjeta unTipo, String numTarj, String codSeg, String nombre, java.util.Date vencimineto, BigDecimal lim){
        tipo = unTipo;
        numTarjeta = this.verificarNumerosIngrasados(numTarj,16,"Numero Dominio.Direccion.Direccion.MediosDePago.Tarjeta");
        codigoSeguridad = this.verificarNumerosIngrasados(codSeg,3, "Codigo de seguridad");
        nombreCompleto = nombre;
        fechaVencimiento = vencimineto;
        limite = lim;
    }

    String verificarNumerosIngrasados(String numeros,int largo,String nombreCampo){
        this.verificarLargoDeLosNumeros(numeros,largo,nombreCampo);
        this.verificarQueSeanNumeros(numeros,largo);
        return numeros;
        /*if (numeros.matches("[0-9]+") && numeros.length() == largo) {
            return numeros;
        }else if(largo == 3){
            throw new Dominio.Direccion.Direccion.Usuario.Dominio.Direccion.Direccion.MediosDePago.HayCaracteresNoNumericosEnLosNumerosDeLaTarjetaExeption(
                    "Se ingrasaron caracteres no numericos como codigo de seguridad de una tarjeta"
            );
        }else{
            throw new Dominio.Direccion.Direccion.Usuario.Dominio.Direccion.Direccion.MediosDePago.HayCaracteresNoNumericosEnLosNumerosDeLaTarjetaExeption(
                    "Se ingresaron caracteres no numericos en el numero de la tarjeta"
            );
        }*/
    }

     void verificarQueSeanNumeros(String numeros,int largo){
        if (!(numeros.matches("[0-9]+"))) {
            if(largo == 3){
                throw new HayCaracteresNoNumericosEnLosNumerosDeLaTarjetaExeption(
                        "Se ingrasaron caracteres no numericos como codigo de seguridad de una tarjeta"
                );
            }
            if(largo == 16){
                throw new HayCaracteresNoNumericosEnLosNumerosDeLaTarjetaExeption(
                        "Se ingresaron caracteres no numericos en el numero de la tarjeta"
                );
            }
         }
    }

    void verificarLargoDeLosNumeros(String numeros, int largo, String nombreCampo){
        if(numeros.length() != largo){
            throw new CantidadIncorrectaDeCaractereresExeption(
                    "Se ingreso un numero incorrecto de caracteres en el campo " + nombreCampo
            );
        }
    }

    void setLimite(BigDecimal cantidad){
        limite = cantidad;
    }

    BigDecimal getLimite(){ return limite; }

    String getNombreCompleto(){
        return nombreCompleto;
    }



    boolean estaDentroDelLimite(BigDecimal cantidad){

        return limite.compareTo(cantidad) >= 0;
    }

    boolean estaVencidaParaEstaFecha(java.util.Date unaFecha){


        return fechaVencimiento.compareTo(unaFecha) < 0;

    }

    public boolean puedePagarse(BigDecimal cantidad, java.util.Date fecha){
        return this.estaDentroDelLimite(cantidad) && !this.estaVencidaParaEstaFecha(fecha);
    }

}
