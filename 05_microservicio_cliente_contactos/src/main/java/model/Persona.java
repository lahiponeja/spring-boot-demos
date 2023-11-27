package model;

public class Persona {
	

	private int edad;

	private String email;

	private String nombre;
	
	

	
	public Persona( String nombre,String email,  int edad) {
		super();
		this.edad = edad;
		this.email = email;
		this.nombre = nombre;
	}
	
	public Persona() {
		super();
	}
	
	




	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
