package br.com.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dao.MovimentacaoDAO;
import br.com.entity.Conta;
import br.com.entity.Movimentacao;

@Service
public class MovimentacaoServiceImpl implements MovimentacaoService{
	
	@Autowired
	private MovimentacaoDAO movimentacaoDAO;
	
	@Autowired
	ContaService contaService;
	
	@Override
	public List<Movimentacao> getTodasMovimentacoes() {
		return movimentacaoDAO.getAllMovimentacao();
	}

	@Override
	public Movimentacao getMovimentacaoId(Integer idMovimentacao) {
		Movimentacao m = movimentacaoDAO.getMovimentacaoId(idMovimentacao);
		return m;
	}

	@Override
	public boolean addMovimentacao(Movimentacao movimentacao) {
		try {
			movimentacaoDAO.addMovimentacao(movimentacao);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public void updateMovimentacao(Movimentacao movimentacao) {
		movimentacaoDAO.updateMovimentacao(movimentacao);
	}

	@Override
	public void deleteMovimentacao(Integer movimentacaoId) {
		movimentacaoDAO.deleteMovimentacao(movimentacaoId);
	}

	@Override
	public boolean setAporte(Movimentacao movimentacao) {
		Conta contaDestino = contaService.getContaId(movimentacao.getId_conta().getId_conta());
		
		if (!contaService.isContaAtiva(contaDestino.getId_conta()) ||
				movimentacao.getId_conta_depositante() != null) {
			return false;
		}else{
			addMovimentacao(movimentacao);
			return true;
		}
		
	}

	@Override
	public boolean setEstorno(Integer idMovimentacao) {
		boolean retorno = false;
		Movimentacao m = getMovimentacaoId(idMovimentacao);
		
		Movimentacao add = new Movimentacao();
		
		add.setDescricao("Estorno Aporte: " + m.getDescricao());
		add.setValor(m.getValor().multiply(new BigDecimal(-1)));
		add.setId_conta(m.getId_conta());
		
		if (addMovimentacao(add)) {
			retorno = true;
		}
	
		return retorno;
	}
	
	@Override
	public boolean isMesmaArvore(Movimentacao movimentacao) {
		boolean retorno = false;
		
		Conta conta = contaService.getContaId(movimentacao.getId_conta().getId_conta());
		Conta contaDepositante = contaService.getContaId(movimentacao.getId_conta_depositante().getId_conta());
		
		if (conta.getCod_matriz() == contaDepositante.getCod_matriz()) {
			retorno = true;
		}
		
		return retorno;
	}

	@Override
	public boolean setTransferencia(Movimentacao movimentacao) {
		boolean retorno = false;
		
		if (isMesmaArvore(movimentacao)) {
			//to do Entrada e saida
			addMovimentacao(movimentacao);
			addMovimentacao(this.geraSaida(movimentacao));
			retorno = true;
		}
		return retorno;
	}
	
	@Override
	public Movimentacao geraSaida(Movimentacao movimentacao) {
		Movimentacao retorno = new Movimentacao();
		
		retorno.setValor(movimentacao.getValor().multiply(new BigDecimal(-1)));
		retorno.setDescricao(movimentacao.getDescricao());
		retorno.setId_conta(movimentacao.getId_conta_depositante());
		
		return retorno;
	}
	
	@Override
	public Movimentacao geraSaidaEstorno(Movimentacao movimentacao) {
		Movimentacao retorno = new Movimentacao();
		
		retorno.setValor(movimentacao.getValor().multiply(new BigDecimal(-1)));
		retorno.setDescricao("Estorno transferencia: " + movimentacao.getDescricao());
		retorno.setId_conta(movimentacao.getId_conta());
		
		return retorno;
	}
	
	@Override
	public Movimentacao geraEntrada(Movimentacao movimentacao) {
		Movimentacao retorno = new Movimentacao();
		
		retorno.setId_movimentacao(null);
		retorno.setValor(movimentacao.getValor());
		retorno.setDescricao("Estorno transferencia: " + movimentacao.getDescricao());
		retorno.setId_conta(movimentacao.getId_conta_depositante());
		
		return retorno;
	}


	@Override
	public boolean setEstornoTransferencia(Integer idMovimentacao) {
		boolean retorno = false;
		Movimentacao m = this.getMovimentacaoId(idMovimentacao);
		
		if (m.getId_conta_depositante() != null) {
			this.addMovimentacao(this.geraEntrada(m));
			this.addMovimentacao(this.geraSaidaEstorno(m));
			retorno = true;
		}
		
		return retorno;
		
	}

	@Override
	public List<Movimentacao> getMovimentacoesByConta(Integer idConta) {
		return movimentacaoDAO.getMovimentacaoByConta(idConta);
	}

	@Override
	public BigDecimal getSaldoByConta(Integer idConta) {
		return movimentacaoDAO.getSaldoByConta(idConta);
	}

}
