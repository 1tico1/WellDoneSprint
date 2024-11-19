package fiap.com.br.GlobalSolution.controller;

import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InfoController {

    private final InfoEndpoint infoEndpoint;

    public InfoController(InfoEndpoint infoEndpoint) {
        this.infoEndpoint = infoEndpoint;
    }

    @GetMapping("/info")
    public String getInfo(Model model) {
        // Obtendo informações do Actuator
        var info = infoEndpoint.info(); // Chama o endpoint info

        model.addAttribute("info", info); // Adiciona as informações ao modelo
        return "Actuator/info"; // Nome da view que será retornada
    }
}
