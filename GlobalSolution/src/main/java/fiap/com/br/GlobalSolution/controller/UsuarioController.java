package fiap.com.br.GlobalSolution.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fiap.com.br.GlobalSolution.model.Role;
import fiap.com.br.GlobalSolution.model.Usuario;
import fiap.com.br.GlobalSolution.repository.RoleRepository;
import fiap.com.br.GlobalSolution.repository.UsuarioRepository;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository repU; // Repositório para usuários

    @Autowired
    private RoleRepository repR; // Repositório para roles

    @Autowired
    private PasswordEncoder passwordEncoder; // Para codificar senhas

    // Método para exibir o formulário de criação de novo usuário
    @GetMapping("/novo_usuario")
    public ModelAndView retornaCadUsuario() {
        ModelAndView mv = new ModelAndView("Usuario/novo_usuario");
        mv.addObject("usuario", new Usuario());
        mv.addObject("roles", repR.findAll()); // Carrega todas as roles para o dropdown
        return mv;	
    }

    @PostMapping("/inserir_usuario")
    public ModelAndView cadastrarUsuario(Usuario usuario, BindingResult bd, 
            @RequestParam(name = "roles") Long id_role) { // Note que agora estamos usando "roles"
        
        if(bd.hasErrors()) {
            ModelAndView mv = new ModelAndView("novo_usuario");
            mv.addObject("usuario", usuario);
            mv.addObject("roles", repR.findAll());
            return mv;
        }

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword())); // Codifica a senha

        // Usando Set para definir as roles
        Set<Role> rolesSet = new HashSet<>();
        
        if(id_role != null) {
            rolesSet.add(repR.findById(id_role).orElse(null)); // Adiciona a role ao usuário
        }
        
        usuario.setRoles(rolesSet); // Define as roles para o usuário
        repU.save(usuario); // Salva o usuário no banco de dados
        
        return new ModelAndView("redirect:/usuario/list"); // Redireciona para a lista de usuários
    }


    @GetMapping("/usuario/list")
    public ModelAndView listarUsuarios() {
        ModelAndView mv = new ModelAndView("Usuario/listar_usuarios"); // Nome da sua nova view
        mv.addObject("usuarios", repU.findAll()); // Obtém todos os usuários do repositório
        return mv;
    }
}
