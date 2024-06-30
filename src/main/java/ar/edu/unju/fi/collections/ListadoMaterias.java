package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unju.fi.model.Materia;


public class ListadoMaterias {

public static List<Materia> materias = new ArrayList<Materia>();
	
//Listar Materias
		public static List<Materia> listarMaterias(){
			//listar docente en estado true
			return materias.stream()
		                .filter(Materia::isEstado) 
		                .collect(Collectors.toList());
		}
		
		//Buscar Materias
		public static Materia buscarMateria(String codigo) {
			for (Materia m : materias) {
				if (m.getCodigo().equals(codigo)) {
					return m;
				}		
			}
			return null;
		}
		
		//Agregar Materia
		public static void agregarMateria(Materia m) {
			//agregar estado
			m.setEstado(true);
			materias.add(m);	
		}
		
		//Modificar Materia
		public static void modificarMateria(Materia materiaModif) {
			materiaModif.setEstado(true);
			for(int i=0;i<materias.size();i++) {
				Materia materia = materias.get(i);
				if(materia.getCodigo().equals(materiaModif.getCodigo())) {
					materias.set(i, materiaModif);
					break;
				}
			}
		}
		
		//Eliminar Materia
		public static void eliminarMateria(String codigo) {
			
			//borrado lógico
			  for (int i = 0; i < materias.size(); i++) {
			      Materia materia = materias.get(i);
			      if (materia.getCodigo().equals(codigo)) {
			        materia.setEstado(false);
			        break;
			      }
			    }
		}
}
