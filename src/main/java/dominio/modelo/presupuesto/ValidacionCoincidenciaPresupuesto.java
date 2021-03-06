package dominio.modelo.presupuesto;

import dominio.modelo.operacionEgreso.Item;
import dominio.modelo.operacionEgreso.OperacionDeEgreso;

import java.util.List;

public class ValidacionCoincidenciaPresupuesto implements ValidacionDePresupuesto {
    @Override
    public boolean validar(OperacionDeEgreso operacionDeEgreso) {
        return operacionDeEgreso.getPresupuestos().stream().anyMatch(presupuesto -> comparar(presupuesto.getItems(),
                operacionDeEgreso.getItems()));
    }

    private boolean comparar(List<Item> lista1, List<Item> lista2) {
        if (lista1.size() != lista2.size()) return false;
        return lista1.stream().map(item -> item.descripcionItem()).reduce("", String::concat)
                .equals(lista2.stream().map(item -> item.descripcionItem()).reduce("", String::concat));
    }

}
