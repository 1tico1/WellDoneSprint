package fiap.com.br.GlobalSolution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fiap.com.br.GlobalSolution.model.Relatorio;
import fiap.com.br.GlobalSolution.repository.RelatorioRepository;

@Controller
@RequestMapping("/relatorio")
public class RelatorioController {

    @Autowired
    private RelatorioRepository relatorioRepository;

    @GetMapping("/new")
    public String relatorioForm(Model model) {
        model.addAttribute("relatorio", new Relatorio());
        model.addAttribute("title", "Adicionar/Editar Relatório");
        return "Relatorio/relatorio-form"; // Caminho ajustado para a pasta Relatorio
    }

    @PostMapping("/save")
    public String saveRelatorio(@ModelAttribute Relatorio relatorio) {
        relatorioRepository.save(relatorio);
        return "redirect:/relatorio/list";
    }

    @GetMapping("/list")
    public String listRelatorios(Model model) {
        model.addAttribute("relatorios", relatorioRepository.findAll());
        model.addAttribute("title", "Lista de Relatórios");
        return "Relatorio/relatorios-list"; // Caminho ajustado para a pasta Relatorio
    }

    @GetMapping("/edit/{id}")
    public String editRelatorio(@PathVariable("id") Long id, Model model) {
        Relatorio relatorio = relatorioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Relatório inválido: " + id));
        model.addAttribute("relatorio", relatorio);
        model.addAttribute("title", "Editar Relatório");
        return "Relatorio/relatorio-form"; // Caminho ajustado para a pasta Relatorio
    }

    @GetMapping("/delete/{id}")
    public String deleteRelatorio(@PathVariable("id") Long id) {
        relatorioRepository.deleteById(id);
        return "redirect:/relatorio/list";
    }
}
