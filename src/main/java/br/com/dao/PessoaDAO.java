package br.com.dao;

import java.util.List;

import br.com.entity.Pessoa;

public interface PessoaDAO {

	List<Pessoa> getAllPessoas();

	Pessoa getPessoaId(Integer pessoaId);

	void addPessoa(Pessoa pessoa);

	void updatePessoa(Pessoa pessoa);

	void deletePessoa(Integer pessoaId);

}
