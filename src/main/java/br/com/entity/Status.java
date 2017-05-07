package br.com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="status")
public class Status {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cod_status;
	
	@Column(nullable = false)
	private String descricao;

	public Integer getCod_status() {
		return cod_status;
	}

	public void setCod_status(Integer cod_status) {
		this.cod_status = cod_status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
