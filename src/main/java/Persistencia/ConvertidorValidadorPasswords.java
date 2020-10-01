package Persistencia;

import Dominio.Usuario.ValidarCaracteresConsecutivos;
import Dominio.Usuario.ValidarLongitud;
import Dominio.Usuario.ValidarPasswords;
import Dominio.Usuario.ValidarPorArchivo;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ConvertidorValidadorPasswords implements AttributeConverter<ValidarPasswords, String> {
    @Override
    public String convertToDatabaseColumn(ValidarPasswords validarPasswords) {
        return validarPasswords.getIdentificador();
    }

    @Override
    public ValidarPasswords convertToEntityAttribute(String s) {
        return null;
    }
}
