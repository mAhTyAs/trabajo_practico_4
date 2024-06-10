package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Alumno;



public class ListadoAlumnos {
public static List<Alumno> alumnos = new ArrayList<Alumno>();
	
	//Listar Alumnos
	public static List<Alumno> listarAlumnos(){
		return alumnos;
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
		alumnos.add(a);
	}
	
	//Modificar Alumno
	public static void modificarAlumno(Alumno alumnoModif) {
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
		alumnos.removeIf(alumno -> alumno.getLu().equals(lu));
	}

}
