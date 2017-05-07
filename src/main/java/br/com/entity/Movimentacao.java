package br.com.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="movimentacao")
public class Movimentacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id_movimentacao;
	
	@ManyToOne
	@JoinColumn(name="id_conta", nullable = false)
	private Conta id_conta;
	
	@Column(nullable = false)
	private BigDecimal valor;
	
	@Column(nullable = false)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="id_conta_depositante", nullable = true)
	private Conta id_conta_depositante;

	public Integer getId_movimentacao() {
		return id_movimentacao;
	}

	public void setId_movimentacao(Integer id_movimentacao) {
		this.id_movimentacao = id_movimentacao;
	}

	public Conta getId_conta() {
		return id_conta;
	}

	public void setId_conta(Conta id_conta) {
		this.id_conta = id_conta;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Conta getId_conta_depositante() {
		return id_conta_depositante;
	}

	public void setId_conta_depositante(Conta id_conta_depositante) {
		this.id_conta_depositante = id_conta_depositante;
	}

}
