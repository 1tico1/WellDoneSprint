package fiap.com.br.GlobalSolution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import fiap.com.br.GlobalSolution.repository.RoleRepository;

@Controller
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/roles")
    public ModelAndView listarRoles() {
        ModelAndView mv = new ModelAndView("listar_roles");
        mv.addObject("roles", roleRepository.findAll());
        return mv;
    }
}

