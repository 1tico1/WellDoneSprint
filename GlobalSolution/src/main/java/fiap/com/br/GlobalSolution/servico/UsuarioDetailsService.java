package fiap.com.br.GlobalSolution.servico;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fiap.com.br.GlobalSolution.model.Usuario;
import fiap.com.br.GlobalSolution.repository.UsuarioRepository;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(UsuarioDetailsService.class);

    @Autowired
    private UsuarioRepository repU;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("Tentando carregar o usuário: " + username);

        Usuario user = repU.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        logger.info("Usuário encontrado: " + user.getUsername());
        logger.info("Roles do usuário: " + user.getRoles());

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                user.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(role.getNome())).collect(Collectors.toList()));
    }
}

