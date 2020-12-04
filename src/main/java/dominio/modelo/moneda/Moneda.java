package dominio.modelo.moneda;

import db.Persistente;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "moneda")
public class Moneda extends Persistente {
    private String identificador;
    private String simbolo;
    private String descripcion;

    public Moneda(String identificador, String simbolo, String descripcion) {
        this.identificador = identificador;
        this.simbolo = simbolo;
        this.descripcion = descripcion;
    }

    public Moneda() {

    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getSimbolo() {
        return this.simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

}
