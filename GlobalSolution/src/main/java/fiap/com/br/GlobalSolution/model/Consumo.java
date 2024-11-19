package fiap.com.br.GlobalSolution.model;

import jakarta.persistence.*;

@Entity
@Table(name = "consumo")
public class Consumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double quantidade; // Em kWh

    @Column(nullable = false)
    private Long usuarioId; // Referência ao usuário
    
    public Consumo() {}

	public Consumo(Long id, Double quantidade, Long usuarioId) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.usuarioId = usuarioId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
    
    

  
}
