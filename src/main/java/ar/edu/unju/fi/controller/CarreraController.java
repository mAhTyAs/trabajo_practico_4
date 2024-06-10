package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoCarrera;
import ar.edu.unju.fi.model.Carrera;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CarreraController {
	@Autowired
	Carrera nuevaCarrera = new Carrera();
	
	@GetMapping("/formCarrera")
	 public ModelAndView getOtroIndex() {
		//vista
		ModelAndView formC = new ModelAndView("formCarrera");
		//agrega el object
		formC.addObject("nuevaCarrera",nuevaCarrera);
		
		
        return formC;
    }
	
	@PostMapping("/guardarCarrera")
	public ModelAndView saveCarrera(@ModelAttribute("nuevaCarrera") Carrera guardarCarrera) {
		//guardar
		ListadoCarrera.agregarCarrera(guardarCarrera);
		
		//mostrar listado
	    ModelAndView formC = new ModelAndView("listaCarreras");
		formC.addObject("listadoCarreras",ListadoCarrera.listarCarreras());
		return formC;
	}
	
	@GetMapping("/borrarCarrera/{codigo}")
	public ModelAndView deleteCarrera(@PathVariable(name="codigo") String codigo) {
		//borrar
		ListadoCarrera.eliminarCarrera(codigo);
		
		//mostrar nueva lista
		ModelAndView formC = new ModelAndView("listaCarreras");
		formC.addObject("listadoCarreras", ListadoCarrera.listarCarreras());	
		
		return formC;		
		}
	
	@GetMapping("/modificarCarrera/{codigo}")
	public ModelAndView editCarrera(@PathVariable(name="codigo") String codigo) {
		//buscar
		Carrera modificarCarrera = ListadoCarrera.buscarCarrera(codigo);
		
		//mostrar el nuevo formulario
		ModelAndView formC = new ModelAndView("formCarrera");
		formC.addObject("nuevaCarrera", modificarCarrera);	
		formC.addObject("band", true);
		return formC;		
		}
	
	@PostMapping("/modificarCarrera")
	public ModelAndView updateCarrera(@ModelAttribute("nuevaCarrera") Carrera carreraModificada) {
					
		//guardar
		ListadoCarrera.modificarCarrera(carreraModificada);
		
		//mostrar el listado
		ModelAndView formC = new ModelAndView("listaCarreras");
		formC.addObject("listadoCarreras", ListadoCarrera.listarCarreras());	
		
		return formC;		
	}
	

}
