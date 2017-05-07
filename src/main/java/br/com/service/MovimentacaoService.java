package br.com.service;

import java.math.BigDecimal;
import java.util.List;

import br.com.entity.Movimentacao;

public interface MovimentacaoService {
	
	List<Movimentacao> getTodasMovimentacoes();

	Movimentacao getMovimentacaoId(Integer idMovimentacao);

	boolean addMovimentacao(Movimentacao movimentacao);

	void updateMovimentacao(Movimentacao movimentacao);

	void deleteMovimentacao(Integer movimentacaoId);
	
	boolean setAporte(Movimentacao movimentacao);
	
	boolean setEstorno(Integer idMovimentacao);
	
	boolean setEstornoTransferencia(Integer idMovimentacao);
	
	boolean isMesmaArvore(Movimentacao movimentacao);
	
	boolean setTransferencia(Movimentacao movimentacao);
	
	Movimentacao geraEntrada(Movimentacao movimentacao);
	
	Movimentacao geraSaidaEstorno(Movimentacao movimentacao);
	
	Movimentacao geraSaida(Movimentacao movimentacao);
	
	List<Movimentacao> getMovimentacoesByConta(Integer idConta);
	
	BigDecimal getSaldoByConta(Integer idConta);

}