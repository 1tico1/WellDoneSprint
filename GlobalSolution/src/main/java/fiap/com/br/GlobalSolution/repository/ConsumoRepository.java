package fiap.com.br.GlobalSolution.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import fiap.com.br.GlobalSolution.model.Consumo;


public interface ConsumoRepository extends JpaRepository<Consumo, Long> {
}
