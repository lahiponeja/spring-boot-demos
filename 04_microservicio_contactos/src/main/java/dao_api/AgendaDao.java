package dao_api;

import java.util.List;

import model.Contacto;

public interface AgendaDao {
	
	void agregarContacto(Contacto contacto);
	void eliminarContacto(int idContacto);
	void actualizarContacto(Contacto contacto);
	Contacto obtenerContacto(int idContacto);
	List<Contacto> devolverContactos();

}
