package br.com.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.entity.Movimentacao;

@Transactional
@Repository
public class MovimentacaoDAOImpl implements MovimentacaoDAO {
	
	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public List<Movimentacao> getAllMovimentacao() {
		String hql = "FROM Movimentacao as c ORDER BY c.id_movimentacao";
		return (List<Movimentacao>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Movimentacao getMovimentacaoId(Integer movimentacaoId) {
		return entityManager.find(Movimentacao.class, movimentacaoId);
	}

	@Override
	public void addMovimentacao(Movimentacao movimentacao) {
		entityManager.persist(movimentacao);

	}

	@Override
	public void updateMovimentacao(Movimentacao movimentacao) {
		Movimentacao m = getMovimentacaoId(movimentacao.getId_movimentacao());
		
		m.setDescricao(movimentacao.getDescricao());
		m.setId_conta(movimentacao.getId_conta());
		m.setId_conta_depositante(movimentacao.getId_conta_depositante());
		m.setValor(movimentacao.getValor());
		
		entityManager.flush();
	}

	@Override
	public void deleteMovimentacao(Integer movimentacaoId) {
		entityManager.remove(getMovimentacaoId(movimentacaoId));
	}

	@Override
	public List<Movimentacao> getMovimentacaoByConta(Integer idConta) {
		Query query = entityManager.createQuery("FROM Movimentacao as c where c.id_conta.id_conta = :id_conta ORDER BY c.id_movimentacao");
		query.setParameter("id_conta", idConta);
		return (List<Movimentacao>) query.getResultList();
		
		
	}

	@Override
	public BigDecimal getSaldoByConta(Integer idConta) {
		Query query = entityManager.createQuery("SELECT SUM(x.valor) FROM Movimentacao x where x.id_conta.id_conta = :id_conta");
		query.setParameter("id_conta", idConta);
		return (BigDecimal) query.getSingleResult();
	}

}
