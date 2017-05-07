package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.entity.Pessoa;

@Transactional
@Repository
public class PessoaDAOImpl implements PessoaDAO {
	
	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public List<Pessoa> getAllPessoas() {
		String hql = "FROM Pessoa as c ORDER BY c.id_pessoa";
		return (List<Pessoa>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Pessoa getPessoaId(Integer pessoaId) {
		return entityManager.find(Pessoa.class, pessoaId);
	}

	@Override
	public void addPessoa(Pessoa pessoa) {
		entityManager.persist(pessoa);
	}

	@Override
	public void updatePessoa(Pessoa pessoa) {
		Pessoa p = getPessoaId(pessoa.getId_pessoa());
		
		p.setBranch_cnpj(pessoa.getBranch_cnpj());
		p.setDataNascimento(pessoa.getDataNascimento());
		p.setDigit_cnpj_cpf(pessoa.getDigit_cnpj_cpf());
		p.setNome(pessoa.getNome());
		p.setNomeFantasia(pessoa.getNomeFantasia());
		p.setRoot_cnpj_cpf(pessoa.getRoot_cnpj_cpf());
		
		entityManager.flush();
	}

	@Override
	public void deletePessoa(Integer pessoaId) {
		entityManager.remove(getPessoaId(pessoaId));
	}

}
