package Dominio.Entidad;

import Dominio.OperacionEgreso.Etiquetado.EtiquetaEgreso;
import Dominio.OperacionEgreso.OperacionDeEgreso;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Reporte {

    void imprimirReporteUltimoMes(EtiquetaEgreso etiquetaEgreso, Entidad entidad) {
        List<OperacionDeEgreso> operacionesFiltradas = etiquetaEgreso.getOperaciones().stream().
                filter(e -> e.getEntidad().equals(entidad) && fechaUltimoMes(e.getFechaOperacion())).
                collect(Collectors.toList());

        System.out.println(operacionesFiltradas);

    }

    private boolean fechaUltimoMes(Date fechaOperacion) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date fechaMesPasado = cal.getTime();
        return fechaMesPasado.after(fechaOperacion);
    }
}
