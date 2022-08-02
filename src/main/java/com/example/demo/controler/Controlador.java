package com.example.demo.controler;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.interfaceService.IpersonaService;
import com.example.demo.modelo.Persona;

@Controller
@RequestMapping
public class Controlador {
	
	@Autowired
	private IpersonaService service; // declaramos la variable service para nuestra IpersonaService
	
	@GetMapping("/listar") // con esta notación traemos toda la lista en la tabla persona que tiene la url
	public String listar(Model model) { 
		List<Persona>personas=service.listar(); 
		model.addAttribute("personas", personas);
		return "index";  // nuestro metodo listar va retornar una lista de personas a nuestro index
	
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("persona", new Persona());
		return "form"; // nuestro metodo hará que cuando se presione el boton "nuevo", se pueda crear una nueva persona en nuestro formulario
	}
	
	@PostMapping("/save") // con esta notacion enviaremos nuestra persona a la url
	public String save(@Valid Persona p, Model model) {
		service.save(p);
		return "redirect:/listar"; // este metodo retorna nuestra persona ya creada a la tabla y lo guarda dentro de la base de datos
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Persona>persona=service.listarId(id);
		model.addAttribute("persona", persona);
		return "form"; // este metodo recibe como parametro nuestro ID de la persona para poder editar y guardar con sus nuevos valores que va ser retornada a nuestro formulario
	}
	
	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/listar"; // este metodo trae nuestro id y lo elimina de nuestro formulario
	}
}