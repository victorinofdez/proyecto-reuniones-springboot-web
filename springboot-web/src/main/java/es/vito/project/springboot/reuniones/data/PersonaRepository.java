package es.vito.project.springboot.reuniones.data;

import es.vito.project.springboot.reuniones.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
