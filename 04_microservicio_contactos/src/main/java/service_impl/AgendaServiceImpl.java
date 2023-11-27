package service_impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao_api.AgendaDao;
import model.Contacto;
import service_api.AgendaService;

@Service
public class AgendaServiceImpl implements AgendaService {
	
	@Autowired
	AgendaDao agendaDao;

	@Override
	public boolean agregarContacto(Contacto contacto) {
		if(agendaDao.obtenerContacto(contacto.getIdContacto())==null) {
			agendaDao.agregarContacto(contacto);		
			return true;
		}
		return false;
	}

	@Override
	public boolean eliminarContacto(int idContacto) {
		if(agendaDao.obtenerContacto(idContacto)!=null) {
			agendaDao.eliminarContacto(idContacto);
			return true;
		}
		return false;
	}

	@Override
	public void actualizarContacto(Contacto contacto) {
		if(agendaDao.obtenerContacto(contacto.getIdContacto())==null) {
			agendaDao.actualizarContacto(contacto);
		}
		
	}

	@Override
	public Contacto obtenerContacto(int idContacto) {
		return agendaDao.obtenerContacto(idContacto);
	}

	@Override
	public List<Contacto> devolverContactos() {
		try {
			Thread.sleep(10000);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return agendaDao.devolverContactos();
	}

}
