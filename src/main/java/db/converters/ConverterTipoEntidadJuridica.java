package db.converters;

import dominio.modelo.entidad.ClasificacionAfip;
import dominio.modelo.entidad.Empresa;
import dominio.modelo.entidad.OSC;
import dominio.modelo.entidad.TipoEntidadJuridica;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ConverterTipoEntidadJuridica implements AttributeConverter<TipoEntidadJuridica, String> {

    @Override
    public String convertToDatabaseColumn(TipoEntidadJuridica tipoEntidadJuridica) {
        return tipoEntidadJuridica.getIdentificador();
    }

    @Override
    public TipoEntidadJuridica convertToEntityAttribute(String s) {
        switch (s) {
            case "OSC":
                return new OSC();
            case "MICRO":
                return new Empresa(ClasificacionAfip.MICRO);
            case "MEDIANA1":
                return new Empresa(ClasificacionAfip.MEDIANA1);
            case "MEDIANA2":
                return new Empresa(ClasificacionAfip.MEDIANA2);
            case "PEQUENIA":
                return new Empresa(ClasificacionAfip.PEQUENIA);
        }
        return null;
    }
}
