package Dominio.Entidad;

public class Empresa implements TipoEntidadJuridica {

    private ClasificacionAfip clasificacion;

    @Override
    public String getIdentificador() {
        switch (clasificacion) {
            case MICRO:
                return "MICRO";
            case MEDIANA1:
                return "MEDIANA1";
            case MEDIANA2:
                return "MEDIANA2";
            case PEQUENIA:
                return "PEQUENIA";
        }
        return "";
    }

    // Constructor
    public Empresa(ClasificacionAfip clasificacion) {
        this.clasificacion = clasificacion;
    }

    // Getter
    public ClasificacionAfip getClasificacion() {
        return clasificacion;
    }

}
