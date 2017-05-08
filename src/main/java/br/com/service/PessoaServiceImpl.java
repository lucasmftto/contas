package br.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.dao.PessoaDAO;
import br.com.entity.Pessoa;

@Service
@Transactional
public class PessoaServiceImpl implements PessoaService {
	
	@Autowired
	private PessoaDAO pessoaDAO;

	@Override
	public List<Pessoa> getTodasPessoas() {
		return pessoaDAO.getAllPessoas();
	}

	@Override
	public Pessoa getPessoaId(Integer pessoa) {
		return pessoaDAO.getPessoaId(pessoa);
	}

	@Override
	public boolean addPessoa(Pessoa pessoa) {
		try {
			pessoaDAO.addPessoa(pessoa);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void updatePessoa(Pessoa pessoa) {
		pessoaDAO.updatePessoa(pessoa);
	}

	@Override
	public void deletePessoa(Integer pessoa) {
		pessoaDAO.deletePessoa(pessoa);
	}

}
