package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ar.edu.unju.fi.model.Alumno;





public class ListadoAlumnos {
public static List<Alumno> alumnos = new ArrayList<Alumno>();
	
	//Listar Alumnos
	public static List<Alumno> listarAlumnos(){
		//listar alumnos en estado true
		return alumnos.stream()
	                .filter(Alumno::isEstado) 
	                .collect(Collectors.toList());
	}
	
	//Buscar Alumnos
	public static Alumno buscarAlumno(String lu) {
		for (Alumno a : alumnos) {
			if (a.getLu().equals(lu)) {
				return a;
			}		
		}
		return null;
	}
	
	//Agregar Alumno
	public static void agregarAlumno(Alumno a) {
		//agregar estado
		a.setEstado(true);
		alumnos.add(a);	
	}
	
	//Modificar Alumno
	public static void modificarAlumno(Alumno alumnoModif) {
		alumnoModif.setEstado(true);
		for(int i=0;i<alumnos.size();i++) {
			Alumno alumno = alumnos.get(i);
			if(alumno.getLu().equals(alumnoModif.getLu())) {
				alumnos.set(i, alumnoModif);
				break;
			}
		}
	}
	
	//Eliminar Alumno
	public static void eliminarAlumno(String lu) {
		//alumnos.removeIf(alumno -> alumno.getDni().equals(dni));
		
		//borrado lógico
		  for (int i = 0; i < alumnos.size(); i++) {
		      Alumno alumno = alumnos.get(i);
		      if (alumno.getLu().equals(lu)) {
		        alumno.setEstado(false);
		        break;
		      }
		    }
	}

}
