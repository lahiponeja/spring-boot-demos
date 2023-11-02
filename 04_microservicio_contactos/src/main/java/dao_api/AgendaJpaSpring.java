package dao_api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;
import model.Contacto;

public interface AgendaJpaSpring extends JpaRepository<Contacto, Integer> {
	@Transactional
	@Modifying
	@Query(value="SELECT * FROM Contacto c WHERE c.nombre = ?1", nativeQuery = true)
	Contacto findByNombre(String nombre);
	
	@Transactional
	@Modifying
	@Query(value="SELECT * FROM Contacto c WHERE c.email = ?1",nativeQuery = true)
	Contacto findByEmail(String email);
	
	@Transactional
	@Modifying
	@Query(value="DELETE FROM Contacto c WHERE c.email = ?1",nativeQuery = true)
	void deleteByEmail(String email);
	
	@Transactional
	@Modifying
	@Query(value="DELETE FROM Contacto c WHERE c.nombre = ?1",nativeQuery = true)
	void deleteByNombre(String nombre);

}
