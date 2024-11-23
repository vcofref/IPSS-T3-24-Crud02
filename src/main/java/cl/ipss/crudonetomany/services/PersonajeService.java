package cl.ipss.crudonetomany.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ipss.crudonetomany.models.Personaje;
import cl.ipss.crudonetomany.repositories.PersonajeRepository;



@Service
public class PersonajeService {

    @Autowired
    private PersonajeRepository personajeRepository;

    public List<Personaje> listarTodas(){
        return personajeRepository.findAllWithSerie();
    }
    
    public Personaje guardar(Personaje personaje) {
        return personajeRepository.save(personaje);
    }

    public Personaje obtenerPorId(Long id) {
        return personajeRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        personajeRepository.deleteById(id);
    }
    
}
