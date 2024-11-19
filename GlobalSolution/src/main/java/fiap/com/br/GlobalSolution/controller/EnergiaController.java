package fiap.com.br.GlobalSolution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fiap.com.br.GlobalSolution.model.Energia;
import fiap.com.br.GlobalSolution.repository.EnergiaRepository;

@Controller
@RequestMapping("/energia")
public class EnergiaController {

    @Autowired
    private EnergiaRepository energiaRepository;

    @GetMapping("/new")
    public String energiaForm(Model model) {
        model.addAttribute("energia", new Energia());
        model.addAttribute("title", "Adicionar/Editar Energia");
        return "Energia/energia-form"; // Caminho ajustado
    }

    @PostMapping("/save")
    public String saveEnergia(@ModelAttribute Energia energia) {
        energiaRepository.save(energia);
        return "redirect:/energia/list";
    }

    @GetMapping("/list")
    public String listEnergias(Model model) {
        model.addAttribute("energies", energiaRepository.findAll());
        model.addAttribute("title", "Lista de Energias");
        return "Energia/energia-list"; // Caminho ajustado
    }

    @GetMapping("/edit/{id}")
    public String editEnergia(@PathVariable("id") Long id, Model model) {
        Energia energia = energiaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Energia inválida: " + id));
        model.addAttribute("energia", energia);
        model.addAttribute("title", "Editar Energia");
        return "Energia/energia-form"; // Caminho ajustado
    }

    @GetMapping("/delete/{id}")
    public String deleteEnergia(@PathVariable("id") Long id) {
        energiaRepository.deleteById(id);
        return "redirect:/energia/list";
    }
}
