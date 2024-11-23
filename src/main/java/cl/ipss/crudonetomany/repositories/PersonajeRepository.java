package cl.ipss.crudonetomany.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cl.ipss.crudonetomany.models.Personaje;

public interface PersonajeRepository extends JpaRepository<Personaje, Long>{
    @Query("SELECT p FROM Personaje p JOIN FETCH p.serie")
    List<Personaje> findAllWithSerie();
}
