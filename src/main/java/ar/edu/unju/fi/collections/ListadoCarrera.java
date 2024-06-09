package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Carrera;



public class ListadoCarrera {
    public static List<Carrera> carreras = new ArrayList<Carrera>();
	
	//Listar Carreras
	public static List<Carrera> listarCarreras(){
		return carreras;
	}
	
	//Buscar Carrera
	public static Carrera buscarCarrera(String codigo) {
		for (Carrera c : carreras) {
			if (c.getCodigo().equals(codigo)) {
				return c;
			}		
		}
		return null;
	}
	
	//Agregar Carrera
	public static void agregarCarrera(Carrera c) {
		carreras.add(c);
	}
	
	//Modificar Carrera
	public static void modificarCarrera(Carrera carreraModif) {
		for(int i=0;i<carreras.size();i++) {
			Carrera carrera = carreras.get(i);
			if(carrera.getCodigo().equals(carreraModif.getCodigo())) {
				carreras.set(i, carreraModif);
				break;
			}
		}
	}
	
	//Eliminar Carrera
	public static void eliminarCarrera(String codigo) {
		carreras.removeIf(carrera -> carrera.getCodigo().equals(codigo));
	}

}
