package dao_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao_api.AgendaDao;
import dao_api.AgendaJpaSpring;
import model.Contacto;

@Repository
public class AgendaDaoImpl implements AgendaDao {
	
	@Autowired
	AgendaJpaSpring agenda;

	@Override
	public void agregarContacto(Contacto contacto) {
		agenda.save(contacto);
		
	}

	@Override
	public void eliminarContacto(int idContacto) {
		agenda.deleteById(idContacto);
		
	}

	@Override
	public void actualizarContacto(Contacto contacto) {
		agenda.save(contacto);
		
	}

	@Override
	public Contacto obtenerContacto(int idContacto) {
		return agenda.findById(idContacto).orElse(null);
	}

	@Override
	public List<Contacto> devolverContactos() {
		List<Contacto> contactos = agenda.findAll();
		return contactos;
	}
	
	Contacto findByNombre(String nombre) {
		return agenda.findByNombre(nombre);
	}

	Contacto findByEmail(String email) {
		return agenda.findByEmail(email);
		
	}

	void eliminarByEmail(String email) {
		agenda.deleteByEmail(email);
		
	};
	
	void eliminarByNombre(String nombre) {
		agenda.deleteByNombre(nombre);
		
	};

	

}
