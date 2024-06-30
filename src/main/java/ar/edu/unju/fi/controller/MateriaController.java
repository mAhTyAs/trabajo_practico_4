package ar.edu.unju.fi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarrera;
import ar.edu.unju.fi.collections.ListadoDocentes;
import ar.edu.unju.fi.collections.ListadoMaterias;
import ar.edu.unju.fi.model.Materia;


@Controller
public class MateriaController {
	@Autowired
	Materia nuevaMateria = new Materia();
	
	@GetMapping("/formMateria")
	 public ModelAndView getformMateria() {
		//vista
		ModelAndView formM = new ModelAndView("formMateria");
		//agrega el object
		formM.addObject("nuevaMateria",nuevaMateria);
		formM.addObject("docentes", ListadoDocentes.listarDocentes());
		formM.addObject("carreras",ListadoCarrera.listarCarreras());
        return formM;
    }
	
	@PostMapping("/guardarMateria")
	public ModelAndView saveMateria(@ModelAttribute("nuevaMateria") Materia guardarMateria) {
		//guardar
		guardarMateria.setDocente(ListadoDocentes.buscarDocente(guardarMateria.getDocente().getLegajo()));
		guardarMateria.setCarrera(ListadoCarrera.buscarCarrera(guardarMateria.getCarrera().getCodigo()));
		ListadoMaterias.agregarMateria(guardarMateria);
		
		//mostrar listado
	    ModelAndView formM = new ModelAndView("listaMaterias");
	
		formM.addObject("listadoMaterias",ListadoMaterias.listarMaterias());
		return formM;
	}
	
	@GetMapping("/borrarMateria/{codigo}")
	public ModelAndView deleteMateria(@PathVariable(name="codigo") String codigo) {
		//borrar
		ListadoMaterias.eliminarMateria(codigo);
		
		//mostrar nueva lista
		ModelAndView formM = new ModelAndView("listaMaterias");
		formM.addObject("listadoMaterias", ListadoMaterias.listarMaterias());	
		
		return formM;		
		}
	
	@GetMapping("/modificarMateria/{codigo}")
	public ModelAndView editMateria(@PathVariable(name="codigo") String codigo) {
		//buscar
		Materia modificarMateria = ListadoMaterias.buscarMateria(codigo);
		
		//mostrar el nuevo formulario
		ModelAndView formM = new ModelAndView("formMateria");
		formM.addObject("nuevaMateria", modificarMateria);	
		formM.addObject("band", true);
		return formM;		
		}
	
	@PostMapping("/modificarMateria")
	public ModelAndView updateMateria(@ModelAttribute("nuevaMateria") Materia materiaModificada) {
					
		//guardar
		ListadoMaterias.modificarMateria(materiaModificada);
		
		//mostrar el listado
		ModelAndView formM = new ModelAndView("listaMaterias");
		formM.addObject("listadoMaterias", ListadoMaterias.listarMaterias());	
		
		return formM;		
	}


}
