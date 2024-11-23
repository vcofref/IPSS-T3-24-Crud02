package cl.ipss.crudonetomany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ipss.crudonetomany.models.Serie;
import cl.ipss.crudonetomany.repositories.SerieRepository;


@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository;

    public List<Serie> listarTodas(){
        return serieRepository.findAll();
    }


    public Serie guardar(Serie serie) {
        return serieRepository.save(serie);
    }

    public Serie obtenerPorId(Long id) {
        return serieRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        serieRepository.deleteById(id);
    }
}
