package br.com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//@Entity
//@Table(name="pessoa_fisica")
public class PessoaFisica implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*@Id
	@Column(nullable = false)
	private Integer cpf;
	
	@Column(nullable = false)
	private String nomeCompleto;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@ManyToOne
	@JoinColumn(name="pessoaFK2", nullable = false)
	private Pessoa pessoa;

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}*/


}
