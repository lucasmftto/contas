package br.com.dao;

import java.math.BigDecimal;
import java.util.List;

import br.com.entity.Movimentacao;

public interface MovimentacaoDAO {
	
	List<Movimentacao> getAllMovimentacao();

	Movimentacao getMovimentacaoId(Integer movimentacaoId);

	void addMovimentacao(Movimentacao movimentacao);

	void updateMovimentacao(Movimentacao movimentacao);

	void deleteMovimentacao(Integer movimentacaoId);
	
	List<Movimentacao> getMovimentacaoByConta(Integer idConta);
	
	BigDecimal getSaldoByConta(Integer idConta);

}
