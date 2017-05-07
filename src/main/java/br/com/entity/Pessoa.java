package br.com.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="pessoa")
public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id_pessoa;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = true)
	private String nomeFantasia;

	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Column(nullable = false)
	private Integer root_cnpj_cpf;
	
	@Column(nullable = true)
	private Integer branch_cnpj;
	
	@Column(nullable = false)
	private Integer digit_cnpj_cpf;

	public Integer getId_pessoa() {
		return id_pessoa;
	}

	public void setId_pessoa(Integer id_pessoa) {
		this.id_pessoa = id_pessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getRoot_cnpj_cpf() {
		return root_cnpj_cpf;
	}

	public void setRoot_cnpj_cpf(Integer root_cnpj_cpf) {
		this.root_cnpj_cpf = root_cnpj_cpf;
	}

	public Integer getBranch_cnpj() {
		return branch_cnpj;
	}

	public void setBranch_cnpj(Integer branch_cnpj) {
		this.branch_cnpj = branch_cnpj;
	}

	public Integer getDigit_cnpj_cpf() {
		return digit_cnpj_cpf;
	}

	public void setDigit_cnpj_cpf(Integer digit_cnpj_cpf) {
		this.digit_cnpj_cpf = digit_cnpj_cpf;
	} 

}
