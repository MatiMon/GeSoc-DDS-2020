package Dominio.Usuario;

import Persistencia.Persistente;

import javax.persistence.*;

@Entity
@Table(name = "validaciones")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public abstract class ValidarPasswords extends Persistente {
    abstract boolean validarPassword(String password);
}
