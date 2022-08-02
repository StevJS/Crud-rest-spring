package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.interfaceService.IpersonaService;
import com.example.demo.interfaces.IPersona;
import com.example.demo.modelo.Persona;

@Service
public class PersonaService implements IpersonaService{ // con esta clase implementamos los metodos creados
	
	@Autowired // con este notacion podremos usar la varible y sus metodos
	private IPersona data; // creamos una variable de nuestra IPersona
	
	@Override
	public List<Persona> listar() {
		return (List<Persona>)data.findAll(); // este metodo viene de CrudRepository y nos retorna una lista de nuestro constructor
	}

	@Override
	public Optional<Persona> listarId(int id) {
		return data.findById(id); // este metodo retorna nuestro objeto a la funcion de actualizar ID
	}

	@Override
	public int save(Persona p) {
		int res=0; 
		Persona persona=data.save(p);
		if(!persona.equals(null)) {
			res=1;
		}
		return res; // el metodo evalua que persona sea distinto de nulo para retonar la respuesta y guardar en base de datos 
	}

	@Override
	public void delete(int id) {
		data.deleteById(id); //el metodo pide eliminar nuestra persona por ID
		
	}
	
}