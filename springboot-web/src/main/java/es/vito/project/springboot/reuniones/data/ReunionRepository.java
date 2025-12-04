package es.vito.project.springboot.reuniones.data;

import es.vito.project.springboot.reuniones.models.Reunion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReunionRepository extends JpaRepository<Reunion, Long> {
}
