package fiap.com.br.GlobalSolution.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "Login/login"; // Ajustado para a estrutura correta
    }
    
    @GetMapping("/acesso_negado")
    public String acessoNegado() {
        return "Login/acess-denied"; // Ajuste se necessário
    }

    // Lida com o logout
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/login?logout"; // Redireciona para a página de login com a mensagem de logout
    }
}
