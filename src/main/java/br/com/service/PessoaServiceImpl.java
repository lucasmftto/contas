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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa getPessoaId(Integer pessoa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addPessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub
		try {
			pessoaDAO.addPessoa(pessoa);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public void updatePessoa(Pessoa pessoa) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletePessoa(Integer pessoa) {
		// TODO Auto-generated method stub

	}

}
