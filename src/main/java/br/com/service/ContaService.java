package br.com.service;

import java.util.List;

import br.com.entity.Conta;

public interface ContaService {
	
	List<Conta> getTodasContas();

	Conta getContaId(Integer conta);

	boolean addConta(Conta conta);

	void updateConta(Conta conta);

	void deleteConta(Integer idConta);

	List<Conta> getContasByMatriz(Integer id_matriz);
	
	boolean isContaAtiva(Integer idConta);
	
	boolean isMatriz(Integer idConta);
}
