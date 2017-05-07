package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.entity.Conta;

@Transactional
@Repository
public class ContaDAOImpl implements ContaDAO {
	
	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public List<Conta> getAllContas() {
		String hql = "FROM Conta as c ORDER BY c.id_conta";
		return (List<Conta>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Conta getContaId(Integer contaId) {
		return entityManager.find(Conta.class, contaId);
	}

	@Override
	public void addConta(Conta conta) {
		entityManager.persist(conta);
	}

	@Override
	public void updateConta(Conta conta) {
		Conta c = getContaId(conta.getId_conta());
		c.setNome(conta.getNome());
		c.setCod_matriz(conta.getCod_matriz());
		c.setDataCriacao(conta.getDataCriacao());
		c.setPessoa(conta.getPessoa());
		c.setStatus(conta.getStatus());
		entityManager.flush();
	}

	@Override
	public void deleteConta(Integer contaId) {
		entityManager.remove(getContaId(contaId));
	}

	@Override
	public List<Conta> getContasByMatriz(Integer id_matriz) {
		//String hql = "FROM Conta as c where c.cod_matriz = :id_matriz ORDER BY c.id_conta";
		
		Query query = entityManager.createQuery("FROM Conta as c where c.cod_matriz = :id_matriz ORDER BY c.id_conta");
		query.setParameter("id_matriz", id_matriz);
		return (List<Conta>) query.getResultList();
	}

}
