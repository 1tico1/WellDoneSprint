package fiap.com.br.GlobalSolution.model;

import jakarta.persistence.*;

@Entity
@Table(name = "energia")
public class Energia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipo; // Ex: Solar, Eólica

    @Column(nullable = false)
    private Double geracao; // Em kWh

    @Column(nullable = false)
    private Long usuarioId; 

    public Energia() {}

	public Energia(Long id, String tipo, Double geracao, Long usuarioId) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.geracao = geracao;
		this.usuarioId = usuarioId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getGeracao() {
		return geracao;
	}

	public void setGeracao(Double geracao) {
		this.geracao = geracao;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
    
    
}
