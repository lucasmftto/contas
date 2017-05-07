package br.com.service;

import java.util.List;

import br.com.entity.Pessoa;

public interface PessoaService {

	List<Pessoa> getTodasPessoas();

	Pessoa getPessoaId(Integer pessoa);

	boolean addPessoa(Pessoa pessoa);

	void updatePessoa(Pessoa pessoa);

	void deletePessoa(Integer pessoa);
}
