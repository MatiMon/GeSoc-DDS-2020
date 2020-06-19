package Dominio.MercadoLibre;

import java.io.IOException;
import java.util.List;

import Dominio.MercadoLibre.UbicacionesMercadoLibre.PaisService;

public class EjemploDeUso {

    /*public static void main(String[] args) throws IOException {
    	UbicacionesMercadoLibre ubicacionesML = UbicacionesMercadoLibre.instancia();
        System.out.println("Estos son los paises:");
        List<UbicacionesMercadoLibre.PaisService> listadoPaises = ubicacionesML.listadoDePaises();
        for(PaisService unPais:listadoPaises){
            System.out.println(unPais.name);
        }
    }
	public static void main(String[] args) throws IOException {
    	UbicacionesMercadoLibre ubicacionesML = UbicacionesMercadoLibre.instancia();
        System.out.println("Estas son las provincias:");
        UbicacionesMercadoLibre.ListadoProvinciaService listadoProvincias = ubicacionesML.listadoDeProvincias("AR");
        for(UbicacionesMercadoLibre.ProvinciaService unaProvincia:listadoProvincias.states) {
        	System.out.println(unaProvincia.name);
        }
    }*/
	public static void main(String[] args) throws IOException {
    	UbicacionesMercadoLibre ubicacionesML = UbicacionesMercadoLibre.instancia();
        System.out.println("Estas son las ciudades:");
        UbicacionesMercadoLibre.ListadoCiudadService listadoCiudades = ubicacionesML.listadoDeCiudades("TUxBUEdSQWVmNTVm");
        for(UbicacionesMercadoLibre.CiudadService unaCiudad:listadoCiudades.cities) {
        	System.out.println(unaCiudad.name);
        }
    }
}