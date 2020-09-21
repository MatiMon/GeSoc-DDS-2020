package Dominio.OperacionEgreso.Etiquetado;

import Dominio.Moneda.Moneda;
import Dominio.OperacionEgreso.OperacionDeEgreso;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class EtiquetaEgreso {

    private TipoEtiqueta tipo;

    private List<OperacionDeEgreso> operaciones = new ArrayList<>();

    private HashMap <Moneda, Double> gasto = new HashMap<Moneda, Double>();

    public EtiquetaEgreso(TipoEtiqueta tipo){
        this.tipo = tipo;
    }

    public List<OperacionDeEgreso> getOperaciones(){
        return operaciones;
    }

    public String descripcionTipo(){
        return tipo.getDescripcion();
    }

    public HashMap <Moneda, Double> getValorTotal(){
        return gasto;
    }

    public void showGastos(){
         gasto.forEach((moneda, valor)-> System.out.println(moneda.toString() + valor.toString()));
    }

    public void enlistarOperaciones(){
        operaciones.forEach(operacion-> System.out.println(operacion.getNroDocumentoComercial()
                                                            + " " + operacion.getValorTotal()));
    }

    public void agregarOperacion( OperacionDeEgreso operacion){
        operaciones.add(operacion);
        modificarGasto(operacion, 1);
    }

    public void quitarOperacion( OperacionDeEgreso operacion){
        operaciones.remove(operacion);
        modificarGasto(operacion, -1);
    }

    private void modificarGasto(OperacionDeEgreso operacion, int sentido){
        Double valor = operacion.getValorTotal() * sentido;
        if (gasto.containsKey(operacion.getMoneda())) {
            valor = valor + gasto.get(operacion.getMoneda());
        }
        if ( valor > 0) {
            gasto.put(operacion.getMoneda(), valor );
        }else{
            gasto.remove( operacion.getMoneda());
        }
    }

    public boolean tieneOperacion(OperacionDeEgreso operacionDeEgreso){
        return getOperaciones().contains(operacionDeEgreso);
    }
}
