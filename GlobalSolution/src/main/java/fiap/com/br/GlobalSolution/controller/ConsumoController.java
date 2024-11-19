package fiap.com.br.GlobalSolution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fiap.com.br.GlobalSolution.model.Consumo;
import fiap.com.br.GlobalSolution.repository.ConsumoRepository;

@Controller
@RequestMapping("/consumo")
public class ConsumoController {

    @Autowired
    private ConsumoRepository consumoRepository;

    @GetMapping("/new")
    public String consumoForm(Model model) {
        model.addAttribute("consumo", new Consumo());
        model.addAttribute("title", "Adicionar/Editar Consumo");
        return "Consumo/consumo-form"; // Caminho ajustado
    }

    @PostMapping("/save")
    public String saveConsumo(@ModelAttribute Consumo consumo) {
        consumoRepository.save(consumo);
        return "redirect:/consumo/list";
    }

    @GetMapping("/list")
    public String listConsumos(Model model) {
        model.addAttribute("consumos", consumoRepository.findAll());
        model.addAttribute("title", "Lista de Consumos");
        return "Consumo/consumo-list"; // Caminho ajustado
    }

    @GetMapping("/edit/{id}")
    public String editConsumo(@PathVariable("id") Long id, Model model) {
        Consumo consumo = consumoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Consumo inválido: " + id));
        model.addAttribute("consumo", consumo);
        model.addAttribute("title", "Editar Consumo");
        return "Consumo/consumo-form"; // Caminho ajustado
    }

    @GetMapping("/delete/{id}")
    public String deleteConsumo(@PathVariable("id") Long id) {
        consumoRepository.deleteById(id);
        return "redirect:/consumo/list";
    }
}
