package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoAlumnos;
import ar.edu.unju.fi.model.Alumno;

@Controller
public class AlumnoController {
	@Autowired
	Alumno nuevoAlumno = new Alumno();
	
	@GetMapping("/formAlumno")
	 public ModelAndView getformAlumno() {
		//vista
		ModelAndView formA = new ModelAndView("formAlumno");
		//agrega el object
		formA.addObject("nuevoAlumno",nuevoAlumno);
		
		
        return formA;
    }
	
	@PostMapping("/guardarAlumno")
	public ModelAndView saveAlumno(@ModelAttribute("nuevoAlumno") Alumno guardarAlumno) {
		//guardar
		ListadoAlumnos.agregarAlumno(guardarAlumno);
		
		//mostrar listado
	    ModelAndView formA = new ModelAndView("listaAlumnos");
		formA.addObject("listadoMaterias",ListadoAlumnos.listarAlumnos());
		return formA;
	}
	
	@GetMapping("/borrarAlumno/{codigo}")
	public ModelAndView deleteAlumno(@PathVariable(name="lu") String lu) {
		//borrar
		ListadoAlumnos.eliminarAlumno(lu);
		
		//mostrar nueva lista
		ModelAndView formA = new ModelAndView("listaAlumnos");
		formA.addObject("listadoAlumnos", ListadoAlumnos.listarAlumnos());	
		
		return formA;		
		}
	
	@GetMapping("/modificarAlumno/{codigo}")
	public ModelAndView editAlumno(@PathVariable(name="lu") String lu) {
		//buscar
		Alumno modificarAlumno = ListadoAlumnos.buscarAlumno(lu);
		
		//mostrar el nuevo formulario
		ModelAndView formA = new ModelAndView("formAlumno");
		formA.addObject("nuevaAlumno", modificarAlumno);	
		
		return formA;		
		}
	
	@PostMapping("/modificarAlumno")
	public ModelAndView updateAlumno(@ModelAttribute("nuevoAlumno") Alumno alumnoModificado) {
					
		//guardar
		ListadoAlumnos.modificarAlumno(alumnoModificado);
		
		//mostrar el listado
		ModelAndView formA = new ModelAndView("listaAlumnos");
		formA.addObject("listadoAlumnos", ListadoAlumnos.listarAlumnos());	
		
		return formA;		
	}

}
