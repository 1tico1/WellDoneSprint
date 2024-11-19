package fiap.com.br.GlobalSolution.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import fiap.com.br.GlobalSolution.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
