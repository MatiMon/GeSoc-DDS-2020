package Dominio.Moneda;

public class Moneda {
    String identificador;
    String simbolo;
    String descripcion;

    // Constructores:

    public Moneda(String identificador, String simbolo, String descripcion) {
        this.identificador = identificador;
        this.simbolo = simbolo;
        this.descripcion = descripcion;
    }

    // Setters:
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
