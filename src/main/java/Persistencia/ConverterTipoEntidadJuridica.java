package Persistencia;

import Dominio.Entidad.ClasificacionAfip;
import Dominio.Entidad.Empresa;
import Dominio.Entidad.OSC;
import Dominio.Entidad.TipoEntidadJuridica;

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
