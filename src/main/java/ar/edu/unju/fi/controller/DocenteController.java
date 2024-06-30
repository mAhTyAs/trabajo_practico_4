package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.collections.ListadoDocentes;
import ar.edu.unju.fi.model.Docente;

@Controller
public class DocenteController {
	@Autowired
	Docente nuevoDocente = new Docente();
	
	@GetMapping("/formDocente")
	 public ModelAndView getformDocente() {
		//vista
		ModelAndView formD = new ModelAndView("formDocente");
		//agrega el object
		formD.addObject("nuevoDocente",nuevoDocente);
		
		
        return formD;
    }
	
	@PostMapping("/guardarDocente")
	public ModelAndView saveDocente(@ModelAttribute("nuevoDocente") Docente guardarDocente) {
		//guardar
		ListadoDocentes.agregarDocente(guardarDocente);
		
		//mostrar listado
	    ModelAndView formD = new ModelAndView("listaDocentes");
	
		formD.addObject("listadoDocentes",ListadoDocentes.listarDocentes());
		return formD;
	}
	
	@GetMapping("/borrarDocente/{legajo}")
	public ModelAndView deleteDocente(@PathVariable(name="legajo") String legajo) {
		//borrar
		ListadoDocentes.eliminarDocente(legajo);
		
		//mostrar nueva lista
		ModelAndView formD = new ModelAndView("listaDocentes");
		formD.addObject("listadoDocentes", ListadoDocentes.listarDocentes());	
		
		return formD;		
		}
	
	@GetMapping("/modificarDocente/{legajo}")
	public ModelAndView editDocente(@PathVariable(name="legajo") String legajo) {
		//buscar
		Docente modificarDocente = ListadoDocentes.buscarDocente(legajo);
		
		//mostrar el nuevo formulario
		ModelAndView formD = new ModelAndView("formDocente");
		formD.addObject("nuevoDocente", modificarDocente);	
		formD.addObject("band", true);
		return formD;		
		}
	
	@PostMapping("/modificarDocente")
	public ModelAndView updateDocente(@ModelAttribute("nuevoDocente") Docente docenteModificado) {
					
		//guardar
		ListadoDocentes.modificarDocente(docenteModificado);
		
		//mostrar el listado
		ModelAndView formD = new ModelAndView("listaDocentes");
		formD.addObject("listadoDocentes", ListadoDocentes.listarDocentes());	
		
		return formD;		
	}

}