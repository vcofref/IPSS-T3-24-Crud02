package cl.ipss.crudonetomany.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.ipss.crudonetomany.models.Personaje;
import cl.ipss.crudonetomany.services.PersonajeService;
import cl.ipss.crudonetomany.services.SerieService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/personajes")
public class PersonajeController {

    @Autowired
    private PersonajeService personajeService;
    @Autowired
    private SerieService serieService;
    @GetMapping
    public String listarPersonajes(Model model) {
        model.addAttribute("titulo", "Listado de Personajes");
        model.addAttribute("personajes", personajeService.listarTodas());
        return "personajes-lista";
    }
    @GetMapping("/nuevo")
    public String mostrarFormularioDeCrearPersonaje(Model model) {
        model.addAttribute("personaje", new Personaje());
        model.addAttribute("series", serieService.listarTodas()); // Cargar todas las series disponibles
        return "personaje-crear";
    }

    @PostMapping("/guardar")
    public String guardarPersonaje(Personaje personaje) {
        personajeService.guardar(personaje);
        return "redirect:/personajes";
    }

    @GetMapping("/editar/{id}")
      public String editarPersonaje(@PathVariable Long id, Model model) {
          model.addAttribute("personaje", personajeService.obtenerPorId(id));
          return "personaje-crear";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPersonaje(@PathVariable Long id) {
        personajeService.eliminar(id);
        return "redirect:/personajes";
    }
}
