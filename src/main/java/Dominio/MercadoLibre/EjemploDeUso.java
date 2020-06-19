package Dominio.MercadoLibre;

import java.io.IOException;
import java.util.List;

public class EjemploDeUso {

   /* public static void main(String[] args) throws IOException {
    	ServicioDeUbicaciones ubicacionesML = ServicioDeUbicaciones.instancia();
        System.out.println("Estos son los paises:");
        List<PaisService> listadoPaises = ubicacionesML.listadoDePaises();
        for(PaisService unPais:listadoPaises){
            System.out.println(unPais.name);
        }
    }
	public static void main(String[] args) throws IOException {
    	UbicacionesMercadoLibre ubicacionesML = UbicacionesMercadoLibre.instancia();
        System.out.println("Estas son las provincias:");
        UbicacionesMercadoLibre.ListadoProvinciaService listadoProvincias = ubicacionesML.listadoDeProvincias("AR");
        for(ProvinciaService unaProvincia:listadoProvincias.states) {
        	System.out.println(unaProvincia.name);
        }
    }*/
	public static void main(String[] args) throws IOException {
    	UbicacionesMercadoLibre ubicacionesML = UbicacionesMercadoLibre.instancia();
        System.out.println("Estas son las ciudades:");
        UbicacionesMercadoLibre.ListadoCiudadService listadoCiudades = ubicacionesML.listadoDeCiudades("TUxBUEdSQWVmNTVm");
        for(CiudadService unaCiudad:listadoCiudades.cities) {
        	System.out.println(unaCiudad.name);
        }
    }
}