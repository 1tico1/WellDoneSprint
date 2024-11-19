package fiap.com.br.GlobalSolution.model;

import jakarta.persistence.*;

@Entity
@Table(name = "relatorio")
public class Relatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String periodo; // Ex: "Janeiro 2024"

    @Column(nullable = false)
    private Double energiaGerada; // Total de energia gerada

    @Column(nullable = false)
    private Double energiaConsumida; // Total de energia consumida

    public Relatorio() {}

	public Relatorio(Long id, String periodo, Double energiaGerada, Double energiaConsumida) {
		super();
		this.id = id;
		this.periodo = periodo;
		this.energiaGerada = energiaGerada;
		this.energiaConsumida = energiaConsumida;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Double getEnergiaGerada() {
		return energiaGerada;
	}

	public void setEnergiaGerada(Double energiaGerada) {
		this.energiaGerada = energiaGerada;
	}

	public Double getEnergiaConsumida() {
		return energiaConsumida;
	}

	public void setEnergiaConsumida(Double energiaConsumida) {
		this.energiaConsumida = energiaConsumida;
	}
    
    
}
