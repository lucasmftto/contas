package br.com.dao;

import java.util.List;

import br.com.entity.Conta;

public interface ContaDAO {
	
	List<Conta> getAllContas();

	Conta getContaId(Integer contaId);

	void addConta(Conta conta);

	void updateConta(Conta conta);

	void deleteConta(Integer contaId);

	List<Conta> getContasByMatriz(Integer id_matriz);
}
