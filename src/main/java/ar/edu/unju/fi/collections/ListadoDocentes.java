package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unju.fi.model.Docente;

public class ListadoDocentes {
	public static List<Docente> docentes = new ArrayList<Docente>();
	
	//Listar Docentes
		public static List<Docente> listarDocentes(){
			//listar docente en estado true
			return docentes.stream()
		                .filter(Docente::isEstado) 
		                .collect(Collectors.toList());
		}
		
		//Buscar Docentes
		public static Docente buscarDocente(String legajo) {
			for (Docente d : docentes) {
				if (d.getLegajo().equals(legajo)) {
					return d;
				}		
			}
			return null;
		}
		
		//Agregar Docente
		public static void agregarDocente(Docente d) {
			//agregar estado
			d.setEstado(true);
			docentes.add(d);	
		}
		
		//Modificar Docente
		public static void modificarDocente(Docente docenteModif) {
			docenteModif.setEstado(true);
			for(int i=0;i<docentes.size();i++) {
				Docente docente = docentes.get(i);
				if(docente.getLegajo().equals(docenteModif.getLegajo())) {
					docentes.set(i, docenteModif);
					break;
				}
			}
		}
		
		//Eliminar Docente
		public static void eliminarDocente(String legajo) {
			//docentes.removeIf(docente -> docente.getLegajo().equals(legajo));
			
			//borrado lógico
			  for (int i = 0; i < docentes.size(); i++) {
			      Docente docente = docentes.get(i);
			      if (docente.getLegajo().equals(legajo)) {
			        docente.setEstado(false);
			        break;
			      }
			    }
		}

	}
