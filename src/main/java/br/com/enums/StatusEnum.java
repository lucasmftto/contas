package br.com.enums;

public enum StatusEnum {
	
	ATIVO(1),
	BLOQUEADA(2),
	CANCELADA(3);

	public Integer codStatus;
	
	StatusEnum(Integer valor) {
		codStatus = valor;
	}
	
	public Integer getcodStatus(){
		return codStatus;
	}

}
