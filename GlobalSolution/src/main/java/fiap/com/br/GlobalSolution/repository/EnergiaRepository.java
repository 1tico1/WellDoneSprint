package fiap.com.br.GlobalSolution.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import fiap.com.br.GlobalSolution.model.Energia;

public interface EnergiaRepository extends JpaRepository<Energia, Long> {
}
