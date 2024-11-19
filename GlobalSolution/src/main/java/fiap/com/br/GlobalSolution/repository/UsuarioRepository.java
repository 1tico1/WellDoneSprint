package fiap.com.br.GlobalSolution.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fiap.com.br.GlobalSolution.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);
}
