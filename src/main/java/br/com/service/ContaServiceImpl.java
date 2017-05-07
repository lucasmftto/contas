package br.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dao.ContaDAO;
import br.com.entity.Conta;
import br.com.enums.StatusEnum;

@Service
public class ContaServiceImpl implements ContaService {

	@Autowired
	private ContaDAO contaDAO;

	@Override
	public List<Conta> getTodasContas() {
		return contaDAO.getAllContas();
	}

	@Override
	public Conta getContaId(Integer conta) {
		Conta c = contaDAO.getContaId(conta);
		return c;
	}

	@Override
	public boolean addConta(Conta conta) {
		try {
			contaDAO.addConta(conta);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public void updateConta(Conta conta) {
		contaDAO.updateConta(conta);
	}

	@Override
	public void deleteConta(Integer idConta) {
		contaDAO.deleteConta(idConta);
	}

	@Override
	public List<Conta> getContasByMatriz(Integer id_matriz) {
		return contaDAO.getContasByMatriz(id_matriz);
	}

	@Override
	public boolean isContaAtiva(Integer idConta) {
		boolean retorno = false;

		Conta c = getContaId(idConta);

		if (c.getStatus().getCod_status() == StatusEnum.ATIVO.getcodStatus()) {
			retorno = true;
		}

		return retorno;
	}

	@Override
	public boolean isMatriz(Integer idConta) {
		boolean retorno = false;

		Conta c = getContaId(idConta);

		if (c.getCod_matriz() == null) {
			retorno = true;
		}

		return retorno;
	}
}
