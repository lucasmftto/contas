package br.com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="conta")
public class Conta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id_conta;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataCriacao;
	
	private Integer cod_matriz;
	
	@ManyToOne
	@JoinColumn(name="pessoaFK", nullable = false)
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn(name="statusFK", nullable = false)
	private Status status;

	public Integer getId_conta() {
		return id_conta;
	}

	public void setId_conta(Integer id_conta) {
		this.id_conta = id_conta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Integer getCod_matriz() {
		return cod_matriz;
	}

	public void setCod_matriz(Integer cod_matriz) {
		this.cod_matriz = cod_matriz;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
}
