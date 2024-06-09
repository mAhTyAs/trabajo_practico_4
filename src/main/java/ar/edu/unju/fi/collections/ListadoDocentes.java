package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import javax.print.Doc;

import ar.edu.unju.fi.model.Docente;

public class ListadoDocentes {
	public static List<Docente> docentes = new ArrayList<Docente>();
	
	//Listar Materias
	public static List<Docente> listarDocentes(){
		return docentes;
	}
	
	//Buscar Materia
	public static Docente buscarDocente(String leg) {
		for (Docente d : docentes) {
			if (d.getLegajo().equals(leg)) {
				return d;
			}		
		}
		return null;
	}
	
	//Agregar Materia
	public static void agregarDocente(Docente d) {
		docentes.add(d);
	}
	
	//Modificar Materia
	public static void modificarDocente(Docente docenteModif) {
		for(int i=0;i<docentes.size();i++) {
			Docente docente = docentes.get(i);
			if(docente.getLegajo().equals(docenteModif.getLegajo())) {
				docentes.set(i, docenteModif);
				break;
			}
		}
	}
	
	//Eliminar Materia
	public static void eliminarDocente(String leg) {
		docentes.removeIf(docente -> docente.getLegajo().equals(leg));
	}

}
