package com.example.demo.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // definimos que nuestra persona va ser una entidad con esta propiedad
@Table(name = "persona") // definimos esta propiedad para dejar a persona en una tabla que usaremos para nuestra base de datos
public class Persona { //creamos la clase persona
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;  // definimos nuestras variables a usar
	private String name;
	private String telefono;
	
	public Persona() {  // constructor
	}

	public Persona(int id, String name, String telefono) { //le pasamos las variables definidas a nuestro constructor
		super();
		this.id = id;
		this.name = name;
		this.telefono = telefono;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
}
