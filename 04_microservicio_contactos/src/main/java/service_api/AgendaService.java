package service_api;

import java.util.List;

import model.Contacto;

public interface AgendaService {
	boolean agregarContacto(Contacto contacto);
	boolean eliminarContacto(int idContacto);
	void actualizarContacto(Contacto contacto);
	Contacto obtenerContacto(int idContacto);
	List<Contacto> devolverContactos();
}
