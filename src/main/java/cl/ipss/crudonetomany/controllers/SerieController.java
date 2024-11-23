package cl.ipss.crudonetomany.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.ipss.crudonetomany.models.Serie;
import cl.ipss.crudonetomany.services.SerieService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private SerieService serieService;
    @GetMapping
    public String listarSeries(Model model) {
        model.addAttribute("titulo", "Listado de Series");
        model.addAttribute("series", serieService.listarTodas());
        return "series-lista";
    }
    @GetMapping("/nuevo")
      public String nuevaSerie(Model model) {
          model.addAttribute("serie", new Serie());
          return "serie-crear";
      }
  
      @PostMapping("/guardar")
      public String guardarPersona(Serie serie, RedirectAttributes redirectAttributes) {
          serieService.guardar(serie);
          redirectAttributes.addFlashAttribute("msg", "Serie guardado con éxito!");
          return "redirect:/series";
      }
  
      @GetMapping("/editar/{id}")
      public String editarSerie(@PathVariable Long id, Model model) {
          model.addAttribute("serie", serieService.obtenerPorId(id));
          return "serie-crear";
      }
  
      @GetMapping("/eliminar/{id}")
      public String eliminarSerie(@PathVariable Long id) {
        serieService.eliminar(id);
          return "redirect:/series";
      }
}
