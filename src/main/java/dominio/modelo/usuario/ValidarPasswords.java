package dominio.modelo.usuario;

import db.Persistente;

import javax.persistence.*;

@Entity
@Table(name = "validaciones")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class ValidarPasswords extends Persistente {
    abstract boolean validarPassword(String password);
    abstract public String getIdentificador();
}
