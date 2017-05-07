package br.com.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@Entity
//@Table(name="pessoa_juridica")
public class PessoaJuridica implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*@Id
	@Column(nullable = false)
	private Integer cnpj;
	
	@Column(nullable = false)
	private String razaoSocial;
	
	@Column(nullable = false)
	private String nomeFantasia;
	
	@ManyToOne
	@JoinColumn(name="pessoaFK1", nullable = false)
	private Pessoa pessoa;

	public Integer getCnpj() {
		return cnpj;
	}

	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}*/
	
}
