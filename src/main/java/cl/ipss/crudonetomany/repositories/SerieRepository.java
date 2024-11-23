package cl.ipss.crudonetomany.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.ipss.crudonetomany.models.Serie;

public interface SerieRepository extends JpaRepository<Serie, Long>{

}
